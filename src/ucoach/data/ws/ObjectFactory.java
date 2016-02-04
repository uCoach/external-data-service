
package ucoach.data.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ucoach.data.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SetTokensResponse_QNAME = new QName("http://ws.data.ucoach/", "setTokensResponse");
    private final static QName _GetTokensResponse_QNAME = new QName("http://ws.data.ucoach/", "getTokensResponse");
    private final static QName _SetTokens_QNAME = new QName("http://ws.data.ucoach/", "setTokens");
    private final static QName _GetTokens_QNAME = new QName("http://ws.data.ucoach/", "getTokens");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ucoach.data.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetTokens }
     * 
     */
    public SetTokens createSetTokens() {
        return new SetTokens();
    }

    /**
     * Create an instance of {@link GetTokens }
     * 
     */
    public GetTokens createGetTokens() {
        return new GetTokens();
    }

    /**
     * Create an instance of {@link SetTokensResponse }
     * 
     */
    public SetTokensResponse createSetTokensResponse() {
        return new SetTokensResponse();
    }

    /**
     * Create an instance of {@link GetTokensResponse }
     * 
     */
    public GetTokensResponse createGetTokensResponse() {
        return new GetTokensResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link GoogleTokens }
     * 
     */
    public GoogleTokens createGoogleTokens() {
        return new GoogleTokens();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTokensResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "setTokensResponse")
    public JAXBElement<SetTokensResponse> createSetTokensResponse(SetTokensResponse value) {
        return new JAXBElement<SetTokensResponse>(_SetTokensResponse_QNAME, SetTokensResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTokensResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "getTokensResponse")
    public JAXBElement<GetTokensResponse> createGetTokensResponse(GetTokensResponse value) {
        return new JAXBElement<GetTokensResponse>(_GetTokensResponse_QNAME, GetTokensResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTokens }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "setTokens")
    public JAXBElement<SetTokens> createSetTokens(SetTokens value) {
        return new JAXBElement<SetTokens>(_SetTokens_QNAME, SetTokens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTokens }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "getTokens")
    public JAXBElement<GetTokens> createGetTokens(GetTokens value) {
        return new JAXBElement<GetTokens>(_GetTokens_QNAME, GetTokens.class, null, value);
    }

}
