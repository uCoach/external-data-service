
package ucoach.data.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "GoogleTokensService", targetNamespace = "http://ws.data.ucoach/", wsdlLocation = "https://ucoach-internal-data-service.herokuapp.com/ws/google-tokens?wsdl")
public class GoogleTokensService
    extends Service
{

    private final static URL GOOGLETOKENSSERVICE_WSDL_LOCATION;
    private final static WebServiceException GOOGLETOKENSSERVICE_EXCEPTION;
    private final static QName GOOGLETOKENSSERVICE_QNAME = new QName("http://ws.data.ucoach/", "GoogleTokensService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://ucoach-internal-data-service.herokuapp.com/ws/google-tokens?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GOOGLETOKENSSERVICE_WSDL_LOCATION = url;
        GOOGLETOKENSSERVICE_EXCEPTION = e;
    }

    public GoogleTokensService() {
        super(__getWsdlLocation(), GOOGLETOKENSSERVICE_QNAME);
    }

    public GoogleTokensService(WebServiceFeature... features) {
        super(__getWsdlLocation(), GOOGLETOKENSSERVICE_QNAME, features);
    }

    public GoogleTokensService(URL wsdlLocation) {
        super(wsdlLocation, GOOGLETOKENSSERVICE_QNAME);
    }

    public GoogleTokensService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GOOGLETOKENSSERVICE_QNAME, features);
    }

    public GoogleTokensService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GoogleTokensService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GoogleTokensInterface
     */
    @WebEndpoint(name = "GoogleTokensServicePort")
    public GoogleTokensInterface getGoogleTokensServicePort() {
        return super.getPort(new QName("http://ws.data.ucoach/", "GoogleTokensServicePort"), GoogleTokensInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GoogleTokensInterface
     */
    @WebEndpoint(name = "GoogleTokensServicePort")
    public GoogleTokensInterface getGoogleTokensServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.data.ucoach/", "GoogleTokensServicePort"), GoogleTokensInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GOOGLETOKENSSERVICE_EXCEPTION!= null) {
            throw GOOGLETOKENSSERVICE_EXCEPTION;
        }
        return GOOGLETOKENSSERVICE_WSDL_LOCATION;
    }

}
