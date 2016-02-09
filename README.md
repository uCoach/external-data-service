#External data sources service

The External Data Service is a wrapper for external data sources APIs.

The only external source implemented so far is Google-Fit API. In order to integrate that we need to make the user authorize uCoach application to access its data offline. To do so we need to use OAuth2 (Google authorization API).

Once the user has authorized the application we store its google access and refresh tokens in our database (through direct SOAP calls to the external-data-service). After that we can call Google-Fit API (using the user access token) to get data about the user: steps, distance, calories.

For more information and list of endpoints provided see the [Wiki](wiki)

###DEPENDENCIES

	# Google keys
	export GOOGLE_CLIENT_ID="goole_client_id"
	export GOOGLE_CLIENT_SECRET="goole_client_secret"
	
	# Authorization keys
	export INTERNAL_DATA_AUTH_KEY="internal_data_auth_key"
	export EXTERNAL_DATA_AUTH_KEY="external_data_auth_key"

###HOW TO RUN

	git clone https://github.com/uCoach/external-data-service.git
	cd external-data-service
	ant run

#####Deployed on Heorku:

  	https://ucoach-external-data-service.herokuapp.com
