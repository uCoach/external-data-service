package ucoach.data.client;

import javax.xml.ws.BindingProvider;

import ucoach.data.client.Authorization;
import ucoach.data.ws.User;
import ucoach.data.ws.UserInterface;
import ucoach.data.ws.UserService;

public class UserClient {

	UserInterface userInterface;

	public UserClient() {
		// Get service
		UserService service = new UserService();
		userInterface = service.getUserServicePort();
		
		// Authorize request
		Authorization.authorizeRequest((BindingProvider)userInterface);
	}

	/**
	 * Method to get user by id
	 * @param userId
	 */
	public User getUser(String userId) {

		User user;

		try {
			// Get user by id
			user = userInterface.getUser(Integer.parseInt(userId));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
}
