package ucoach.google.util;

import java.io.IOException;

import com.google.api.client.auth.oauth2.Credential;

import ucoach.data.client.GoogleTokensClient;
import ucoach.data.ws.GoogleTokens;

public class TokenHandler {

	/**
	 * Helper method to store tokens in internal database using ucoach.data.Client
	 * @param credential
	 * @param userId
	 */
	public boolean storeCredential(Credential credential, String userId) {
		
		// Get tokens
		String accessToken = credential.getAccessToken();
		String refreshToken = credential.getRefreshToken();
		
		// Use client service to store new tokens
		GoogleTokensClient client = new GoogleTokensClient();
		GoogleTokens token = client.newGoogleTokens(userId, accessToken, refreshToken);
		if (token == null) return false;
		return true;
	}

	/**
	 * Helper method to refresh access token and save to DB
	 * @param credential
	 * @param userId
	 * @throws IOException
	 */
	public Credential refreshAccessToken(Credential credential, String userId) throws IOException {
		// Refresh token and store to database
		GoogleTokensClient client = new GoogleTokensClient();
		credential.refreshToken();
		client.updateGoogleTokens(userId, credential.getAccessToken());

		return credential;
	}
}
