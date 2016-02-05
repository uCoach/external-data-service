package ucoach.google.endpoint;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.json.JSONObject;

import ucoach.data.client.GoogleTokensClient;
import ucoach.data.client.UserClient;
import ucoach.data.ws.GoogleTokens;
import ucoach.data.ws.User;
import ucoach.google.util.*;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.services.fitness.Fitness;
import com.google.api.services.fitness.Fitness.Users.Dataset;
import com.google.api.services.fitness.Fitness.Users.DataSources;
import com.google.api.services.fitness.Fitness.Users.DataSources.Datasets;
import com.google.api.services.fitness.model.DataPoint;
import com.google.api.services.fitness.model.Value;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;

@Path("/counters")
public class FitnessCounters {
	
  @Context
  UriInfo uriInfo;
  private TokenHandler tokenHandler;
  private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
  private static HttpTransport httpTransport;
  private String clientId = "google_client_id";
  private String clientSecret = "google_client_secret";
  private static String dataSourceStepId = "derived:com.google.step_count.delta:com.google.android.gms:estimated_steps";
  private static String dataSourceCaloriesId = "derived:com.google.calories.expended:com.google.android.gms:merge_calories_expended";
  private static String dataSourceDistanceId = "derived:com.google.distance.delta:com.google.android.gms:pruned_distance";

  @GET
	@Path("/user/{userId}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response getUserActivities(@PathParam("userId") String userId, @Context HttpHeaders headers)
  		throws GeneralSecurityException, IOException {

  	if(!Authorization.validateRequest(headers)){
  		JSONObject json = new JSONObject();
  		json.put("status", 401).put("message", "Not Authorized");
  		
      return Response.status(401).entity(json.toString()).build();
		}

  	setDependencies();

  	System.out.println("Getting user activities");

		// Check if userId is provided
		if(userId == null || userId.trim().length() == 0) {
			JSONObject json = new JSONObject();
  		json.put("status", 400).put("message", "UserId cannot be blank");
  		
      return Response.status(400).entity(json.toString()).build();
		}

		// Check if user exists
		User user = getUser(userId);
		if (user == null) {
			JSONObject json = new JSONObject();
			System.out.println("User not found");
  		json.put("status", 404).put("message", "User not found");
      return Response.status(404).entity(json.toString()).build();
		}		
	
		// Get (and check) google tokens
		GoogleTokens googleTokens = getGoogleTokens(user);
		if (googleTokens == null) {
			JSONObject json = new JSONObject();
			System.out.println("User hasn't authorize");
  		json.put("status", 400).put("message", "User hasn't authorize");
      return Response.status(400).entity(json.toString()).build();
		}

		// Set google credential
  	GoogleCredential credential = new GoogleCredential
  			.Builder()
  			.setTransport(httpTransport)
        .setJsonFactory(JSON_FACTORY)
        .setClientSecrets(clientId, clientSecret).build()
        .setAccessToken(googleTokens.getAccessToken());

  	// Connect to google fit
  	Fitness fitness = new Fitness.Builder(httpTransport, JSON_FACTORY, credential)
  			.setApplicationName("ucoach").build();  	
  	Datasets datasets = fitness.users().dataSources().datasets();
  	
  	// Build set of time frames
  	Map<String, String> map = new HashMap<String, String>();
  	map.put("today", TimeFrameHelper.getTodayDateWindow());
  	map.put("yesterday", TimeFrameHelper.getYesterdayDateWindow());
  	map.put("last-week", TimeFrameHelper.getLastWeekDateWindow());
  	map.put("last-month", TimeFrameHelper.getLastMonthDateWindow());

  	// Build steps JSON object 
  	JSONObject steps = new JSONObject();

  	// For each time frame execute a request
  	for (Map.Entry<String, String> entry : map.entrySet()) {
  		String datasetId = entry.getValue();
  		String stepsCount = getIntDataFromGoogleFit(datasets, dataSourceStepId, datasetId, credential, googleTokens);

  		// Add to JSON object
  		steps.put(entry.getKey(), stepsCount);
  	}

  	// Build calories JSON object 
   	JSONObject calories = new JSONObject();

   	// For each time frame execute a request
   	for (Map.Entry<String, String> entry : map.entrySet()) {
   		String datasetId = entry.getValue();
   		String caloriesCount = getFloatDataFromGoogleFit(datasets, dataSourceCaloriesId, datasetId, credential, googleTokens);

   		// Add to JSON object
   		calories.put(entry.getKey(), caloriesCount);
   	}
   	
   	// Build distance JSON object 
   	JSONObject distance = new JSONObject();

   	// For each time frame execute a request
   	for (Map.Entry<String, String> entry : map.entrySet()) {
   		String datasetId = entry.getValue();
   		String distanceCount = getFloatDataFromGoogleFit(datasets, dataSourceDistanceId, datasetId, credential, googleTokens);

   		// Add to JSON object
   		distance.put(entry.getKey(), distanceCount);
   	}

  	// Build JSON response object
  	JSONObject json = new JSONObject();
  	json.put("steps", steps)
  		.put("calories", calories)
  		.put("distance", distance)
  		.put("status", 200);
		
		System.out.println("Returning activities");
  	return Response.ok(json.toString()).build();
  }

  /**
	 * Helper method to get user by id
	 * @param userId
	 * @return
	 */
	private User getUser(String userId) {
		UserClient client = new UserClient();
		return client.getUser(userId);
	}

	/**
	 * Get user google tokens
	 * @param user
	 * @return
	 */
	private GoogleTokens getGoogleTokens(User user) {
		GoogleTokensClient client = new GoogleTokensClient();
		return client.getGoogleTokensByUser(Integer.toString(user.getId()));
	}
	
	/**
	 * Helper method to set needed dependencies
	 * @throws IOException 
	 * @throws GeneralSecurityException 
	 */
	private void setDependencies() throws GeneralSecurityException, IOException {
		
		// Set google client id and secret
		clientId = String.valueOf(System.getenv("GOOGLE_CLIENT_ID"));
		clientSecret = String.valueOf(System.getenv("GOOGLE_CLIENT_SECRET"));
		
		httpTransport = GoogleNetHttpTransport.newTrustedTransport();

		tokenHandler = new TokenHandler();
	}

	
	/**
	 * Method to perform a request to Google-fit API
	 * and sum total with integer values
	 * @param datasets
	 * @param dataSourceId
	 * @param datasetId
	 * @param credential
	 * @param googleTokens
	 * @return
	 * @throws IOException
	 */
	private String getIntDataFromGoogleFit(
			Datasets datasets,
			String dataSourceId,
			String datasetId,
			GoogleCredential credential,
			GoogleTokens googleTokens
		) throws IOException {
		
		List<DataPoint> points = getDataPoints(datasets, dataSourceId, datasetId, credential, googleTokens);

  	// Sum all steps
  	int sum = 0;
  	for(Iterator<DataPoint> i = points.iterator(); i.hasNext(); ) {
  		DataPoint point = i.next();
  		for(Iterator<Value> v = point.getValue().iterator(); v.hasNext(); ) {
  			int value = v.next().getIntVal();
  			sum += value;
  		}
  	}

  	return Integer.toString(sum);
	}
	
	/**
	 * Method to perform a request to Google-fit API
	 * and sum total with float values
	 * @param datasets
	 * @param dataSourceId
	 * @param datasetId
	 * @param credential
	 * @param googleTokens
	 * @return
	 * @throws IOException
	 */
	private String getFloatDataFromGoogleFit(
			Datasets datasets,
			String dataSourceId,
			String datasetId,
			GoogleCredential credential,
			GoogleTokens googleTokens
		) throws IOException {
		
		List<DataPoint> points = getDataPoints(datasets, dataSourceId, datasetId, credential, googleTokens);

  	// Sum all steps
  	double sum = 0;
  	for(Iterator<DataPoint> i = points.iterator(); i.hasNext(); ) {
  		DataPoint point = i.next();
  		for(Iterator<Value> v = point.getValue().iterator(); v.hasNext(); ) {
  			double value = v.next().getFpVal();
  			sum += value;
  		}
  	}

  	return Double.toString(sum);
	}

	/**
	 * Method to perform a request to Google-fit API
	 * @param datasets
	 * @param dataSourceId
	 * @param datasetId
	 * @param credential
	 * @param googleTokens
	 * @return
	 * @throws IOException
	 */
	private List<DataPoint> getDataPoints(
			Datasets datasets,
			String dataSourceId,
			String datasetId,
			GoogleCredential credential,
			GoogleTokens googleTokens
		) throws IOException {

		//Get data points from google fit API
		List<DataPoint> points = null;
		try {
			points = datasets.get("me", dataSourceId, datasetId).execute().getPoint();
		} catch (GoogleJsonResponseException e) {
	 		// If token expired: refresh it and re-try
	 		if (e.getStatusCode() == 401) {
	 			System.out.println("Refreshing token");
	
	 			String userId = Integer.toString(googleTokens.getUser().getId());
	 			credential.setRefreshToken(googleTokens.getRefreshToken());
	 			tokenHandler.refreshAccessToken(credential, userId);
	 			
	 			points = datasets.get("me", dataSourceStepId, datasetId).execute().getPoint();
	 		}
	 		else e.printStackTrace();
		}
 	
		return points;
	}
}