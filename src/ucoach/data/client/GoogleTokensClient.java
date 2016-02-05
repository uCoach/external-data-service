package ucoach.data.client;

import javax.xml.ws.BindingProvider;

import ucoach.data.client.Authorization;
import ucoach.data.ws.GoogleTokens;
import ucoach.data.ws.GoogleTokensInterface;
import ucoach.data.ws.GoogleTokensService;

public class GoogleTokensClient {

	GoogleTokensInterface googleTokens;

	public GoogleTokensClient() {
		// Get service
		GoogleTokensService service = new GoogleTokensService();
		googleTokens = service.getGoogleTokensServicePort();
		
		// Authorize request
		Authorization.authorizeRequest((BindingProvider)googleTokens);
	}

	/**
	 * Method to create new google tokens for given user
	 * @param userId
	 * @param accessToken
	 * @param refreshToken
	 */
	public GoogleTokens newGoogleTokens(String userId, String accessToken, String refreshToken) {

		try {
			// Set new tokens
			return googleTokens.setTokens(Integer.parseInt(userId), accessToken, refreshToken);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	/**
	 * Method to get google tokens for given user
	 * @param userId
	 * @param accessToken
	 * @param refreshToken
	 */
	public GoogleTokens getGoogleTokensByUser(String userId) {

		try {
			return googleTokens.getTokens(Integer.parseInt(userId));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	/**
	 * Method to update tokens with new access token
	 * @param userId
	 * @param accessToken
	 * @return
	 */
	public GoogleTokens updateGoogleTokens(String userId, String accessToken) {

		try {
			return googleTokens.updateTokens(Integer.parseInt(userId), accessToken);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
