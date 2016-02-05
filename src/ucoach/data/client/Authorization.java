package ucoach.data.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class Authorization {

	private static final String AUTHORIZATION_KEY = "default_authorization_key";
	
	/**
	 * Authorize request with authentication key
	 * @param provider
	 */
	public static void authorizeRequest(BindingProvider provider) {
		
		// Get context
		Map<String, Object> reqContext = provider.getRequestContext();
		
		// Get valid authorization key from Environment
    String validAuthKey = AUTHORIZATION_KEY;
    if (String.valueOf(System.getenv("INTERNAL_DATA_AUTH_KEY")) != "null"){
    	validAuthKey = String.valueOf(System.getenv("INTERNAL_DATA_AUTH_KEY"));
    }

    // Add authorization header
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
    headers.put("Authorization", Collections.singletonList(validAuthKey));
    reqContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
	}
}
