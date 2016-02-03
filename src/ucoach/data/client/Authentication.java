package ucoach.data.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class Authentication {

	private static final String AUTHORIZATION_KEY = "default_authentication_key";
	
	/**
	 * Authenticate request with authentication key
	 * @param provider
	 */
	public static void authenticateRequest(BindingProvider provider) {
		
		// Get context
		Map<String, Object> reqContext = provider.getRequestContext();
		
		// Get valid authentication key from Environment
    String validAuthKey = AUTHORIZATION_KEY;
    if (String.valueOf(System.getenv("AUTHORIZATION_KEY")) != "null"){
    	validAuthKey = String.valueOf(System.getenv("AUTHORIZATION_KEY"));
    }

    // Add authentication header
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
    headers.put("Authorization", Collections.singletonList(validAuthKey));
    reqContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
	}
}
