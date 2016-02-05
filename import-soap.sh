cd src
wsimport -keep $1/ws/google-tokens?wsdl
wsimport -keep $1/ws/user?wsdl
wsimport -keep $1/ws/healthmeasure?wsdl
cd ..
