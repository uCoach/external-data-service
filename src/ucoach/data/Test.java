package ucoach.data;

import ucoach.data.Authentication;
import javax.xml.ws.BindingProvider;

import ucoach.data.ws.GoogleTokens;
import ucoach.data.ws.GoogleTokensInterface;
import ucoach.data.ws.GoogleTokensService;

public class Test {

	public static void main(String[] args) throws Exception {
		GoogleTokensService service = new GoogleTokensService();
		GoogleTokensInterface gooleTokens = service.getGoogleTokensImplPort();
		
		Authentication.authenticateRequest((BindingProvider)gooleTokens);

		GoogleTokens tokens = gooleTokens.getTokens(2);
		System.out.println(tokens.getAccessToken());
	}
}
