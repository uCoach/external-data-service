cd src
wsimport -keep $1/ws/google-tokens?wsdl
wsimport -keep $1/ws/user?wsdl
cd ..
