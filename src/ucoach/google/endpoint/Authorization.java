package ucoach.google.endpoint;

import ucoach.data.Client;

import java.io.IOException;
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
import javax.ws.rs.core.MediaType;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.fitness.FitnessScopes;

@Path("/authorization")
public class Authorization {
	
  @Context
  UriInfo uriInfo;

	private String clientId = "google_client_id";
  private String clientSecret = "google_client_secret";
  private String callbackUrl = "/authorization";
  private AuthorizationCodeFlow flow;

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public Response callback(
  		@QueryParam("code") String code,
  		@QueryParam("state") String userId,
  		@QueryParam("error") String error
  ) throws IOException {
  	
  	// Set dependencies
  	setDependencies();

		// Build JSON response object
		JSONObject json = new JSONObject();
		
		// Check parameters
		if (error != null) {
			System.out.println("Access denied from the user");
			json.put("status", 400).put("message", error);
			return Response.status(400).entity(json.toString()).build();
		}

		if (code == null || userId == null) {
			json.put("status", 400).put("message", "missing parameters");
			return Response.status(400).entity(json.toString()).build();
		}
		
		// Request tokens
		flow = initialiazeFlow();
		TokenResponse tokenResponse = flow.newTokenRequest(code).setRedirectUri(callbackUrl).execute();
		
		// Get credential and store in internal database
		System.out.println("Storing credential..");
		Credential credential = flow.createAndStoreCredential(tokenResponse, userId);
		boolean success = storeCredential(credential, userId);
		if (!success) {
			System.out.println("Internal server error");
			json.put("status", 500).put("message", "Internal server error");
			return Response.status(500).entity(json.toString()).build();
		}
		
		System.out.println("User authorized");
		json.put("status", 200).put("message", "User authorized");

		return Response.ok(json.toString()).build();
  }

	@GET
	@Path("/user/{userId}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response authorizeUser(@PathParam("userId") String userId) throws IOException {

		// Set dependencies
	  setDependencies();

		System.out.println("Authorizing user...");
  	
		// Check if userId is provided
		if(userId == null || userId.trim().length() == 0) {
			JSONObject json = new JSONObject();
  		json.put("status", 400).put("message", "UserId cannot be blank");
      return Response.status(400).entity(json.toString()).build();
		}

		flow = initialiazeFlow();
		
		// Load credential
    Credential credential = flow.loadCredential(userId);
    if (credential != null) {
    	System.out.println("User already authorized");
    	
    	// Build and return success response
    	JSONObject json = new JSONObject();
  		json.put("status", 200).put("message", "User already authorized");
    	return Response.ok(json.toString()).build();
    }

    // If not found: authorize new user
    System.out.println("Redirect to authorization page");
    String url = flow.newAuthorizationUrl().setState(userId).setRedirectUri(callbackUrl).build();
    return Response.seeOther(UriBuilder.fromUri(url).build()).build();
  }
	
	/**
	 * Helper method to initialize new flow
	 * @return
	 */
	private AuthorizationCodeFlow initialiazeFlow() {

		return new GoogleAuthorizationCodeFlow.Builder(
        new NetHttpTransport(), JacksonFactory.getDefaultInstance(),
        clientId, clientSecret,
        Collections.singleton(FitnessScopes.FITNESS_ACTIVITY_READ)).setAccessType("offline").build();
	}
	
	/**
	 * Helper method to store tokens in internal database using ucoach.data.Client
	 * @param credential
	 * @param userId
	 */
	private boolean storeCredential(Credential credential, String userId) {
		
		// Get tokens
		String accessToken = credential.getAccessToken();
		String refreshToken = credential.getRefreshToken();
		
		// User client service to store new tokens
		Client client = new Client();
		return client.newGoogleTokens(userId, accessToken, refreshToken);
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
	}
}




