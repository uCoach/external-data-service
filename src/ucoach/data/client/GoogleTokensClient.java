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
	public boolean newGoogleTokens(String userId, String accessToken, String refreshToken) {

		try {
			// Set new tokens
			GoogleTokens token = googleTokens.setTokens(Integer.parseInt(userId), accessToken, refreshToken);
			if (token == null) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
