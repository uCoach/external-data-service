package ucoach.data;

import ucoach.data.Authentication;
import javax.xml.ws.BindingProvider;

import ucoach.data.ws.GoogleTokens;
import ucoach.data.ws.GoogleTokensInterface;
import ucoach.data.ws.GoogleTokensService;

public class Client {

	/**
	 * Method to create new google tokens for given user
	 * @param userId
	 * @param accessToken
	 * @param refreshToken
	 */
	public boolean newGoogleTokens(String userId, String accessToken, String refreshToken) {

		try {
			// Get service
			GoogleTokensService service = new GoogleTokensService();
			GoogleTokensInterface gooleTokens = service.getGoogleTokensImplPort();
			
			// Authenticate request
			Authentication.authenticateRequest((BindingProvider)gooleTokens);
	
			// Set new tokens
			GoogleTokens token = gooleTokens.setTokens(Integer.parseInt(userId), accessToken, refreshToken);
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
