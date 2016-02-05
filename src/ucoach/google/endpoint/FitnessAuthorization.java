package ucoach.google.endpoint;

import ucoach.google.util.Authorization;
import ucoach.google.util.TokenHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.fitness.FitnessScopes;

import ucoach.data.client.GoogleTokensClient;
import ucoach.data.client.UserClient;
import ucoach.data.ws.User;
import ucoach.data.ws.GoogleTokens;

@Path("/authorization")
public class FitnessAuthorization {
	
  @Context
  UriInfo uriInfo;

	private String clientId = "google_client_id";
  private String clientSecret = "google_client_secret";
  private String callbackUrl = "/authorization";
  private AuthorizationCodeFlow flow;
  private TokenHandler tokenHandler;

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public Response callback(
  		@QueryParam("code") String code,
  		@QueryParam("state") String state,
  		@QueryParam("error") String error,
  		@Context HttpHeaders headers
  ) throws IOException {

		// Build JSON response object
		JSONObject json = new JSONObject();

		// Check parameters
		if (error != null) {
			System.out.println("Access denied from the user");
			json.put("status", 400).put("message", error);
			return Response.status(400).entity(json.toString()).build();
		}

		if (code == null || state == null || state.split("-").length < 2) {
			json.put("status", 400).put("message", "missing/wrong parameters");
			return Response.status(400).entity(json.toString()).build();
		}
		
		// Parse state
  	String userId =  state.split("-")[0];
  	String authKey = state.split("-")[1];

  	// Validate authorization key
  	if(!Authorization.validateKey(authKey)){
  		json.put("status", 401).put("message", "Not Authorized");
  		
      return Response.status(401).entity(json.toString()).build();
		}

  	// Check if user exists
 		User user = getUser(userId);
 		if (user == null) {
 			System.out.println("User not found");
   		json.put("status", 404).put("message", "User not found");
       return Response.status(404).entity(json.toString()).build();
 		}

		// Set dependencies
	  setDependencies();

		// Request tokens
		TokenResponse tokenResponse = flow.newTokenRequest(code).setRedirectUri(callbackUrl).execute();
		
		// Get credential and store in internal database
		System.out.println("Storing credential..");
		Credential credential = flow.createAndStoreCredential(tokenResponse, userId);
		boolean success = tokenHandler.storeCredential(credential, userId);
		if (!success) {
			System.out.println("Internal server error");
			json.put("status", 500).put("message", "Internal server error");
			return Response.status(500).entity(json.toString()).build();
		}
		
		System.out.println("User authorized");
		json.put("status", 200).put("message", "User authorized");

		// TO DO: redirect the user to proper page
		return Response.ok(json.toString()).build();
  }

	@GET
	@Path("/user/{userId}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response authorizeUser(@PathParam("userId") String userId, @Context HttpHeaders headers)
  		throws IOException {

		if(!Authorization.validateRequest(headers)){
  		JSONObject json = new JSONObject();
  		json.put("status", 401).put("message", "Not Authorized");
  		
      return Response.status(401).entity(json.toString()).build();
		}

		System.out.println("Authorizing user...");
  	
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

		// Set dependencies
		setDependencies();
		
		// Check if user has already authorized the service
    boolean hasAuthorized = hasAuthorized(userId); 
    if (hasAuthorized) {
    	System.out.println("User has already authorized");
    	
    	// Build and return success response
    	JSONObject json = new JSONObject();
  		json.put("status", 200).put("message", "User has already authorized");
    	return Response.ok(json.toString()).build();
    }

    // If not found: authorize new user
    System.out.println("Return authorization url location");

    String state = userId + "-" + Authorization.getAuthorizationKey();
    String url = flow.newAuthorizationUrl().setState(state).setRedirectUri(callbackUrl).build();

    JSONObject json = new JSONObject();
		json.put("status", 200).put("location", url);
		return Response.ok(json.toString()).build();
    //return Response.seeOther(UriBuilder.fromUri(url).build()).build();
  }
	
	/**
	 * Helper method to initialize new flow
	 * @return
	 */
	private AuthorizationCodeFlow initialiazeFlow() {

		// Defining scope collection
		Collection<String> scopes = new ArrayList<String>();
		scopes.add(FitnessScopes.FITNESS_ACTIVITY_READ);
		scopes.add(FitnessScopes.FITNESS_LOCATION_READ);

		return new GoogleAuthorizationCodeFlow.Builder(
      new NetHttpTransport(),
      JacksonFactory.getDefaultInstance(),
      clientId,
      clientSecret,
      scopes
    ).setAccessType("offline").build();
	}
	
	/**
	 * Helper method to check if user has already authorized and if we have a token
	 * @param userId
	 * @return
	 * @throws IOException
	 */
	private boolean hasAuthorized(String userId) throws IOException {
		Credential credential = flow.loadCredential(userId);
		if (credential != null) return true;
		
		// This is needed because the loadCredential always return null
		// TO DO: understand why loadCredential doesn't work properly
		GoogleTokensClient client = new GoogleTokensClient();
		GoogleTokens tokens = client.getGoogleTokensByUser(userId);
		if (tokens != null) return true;

		return false;
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
	 * Helper method to set needed dependencies
	 */
	private void setDependencies() {
		// Set callback URL
		String baseUrl = UriBuilder.fromUri(uriInfo.getBaseUri()).build().toString();
		callbackUrl = StringUtils.stripEnd(baseUrl, "/") + callbackUrl;
		
		// Set google client id and secret
		clientId = String.valueOf(System.getenv("GOOGLE_CLIENT_ID"));
		clientSecret = String.valueOf(System.getenv("GOOGLE_CLIENT_SECRET"));
		
		// Initialize AuthorizationCodeFlow
		flow = initialiazeFlow();

		tokenHandler = new TokenHandler();
	}
}

