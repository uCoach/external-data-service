
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

    private final static QName _GetHMTypesResponse_QNAME = new QName("http://ws.data.ucoach/", "getHMTypesResponse");
    private final static QName _GetHMTypes_QNAME = new QName("http://ws.data.ucoach/", "getHMTypes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ucoach.data.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHMTypesResponse }
     * 
     */
    public GetHMTypesResponse createGetHMTypesResponse() {
        return new GetHMTypesResponse();
    }

    /**
     * Create an instance of {@link GetHMTypes }
     * 
     */
    public GetHMTypes createGetHMTypes() {
        return new GetHMTypes();
    }

    /**
     * Create an instance of {@link HmType }
     * 
     */
    public HmType createHmType() {
        return new HmType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHMTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "getHMTypesResponse")
    public JAXBElement<GetHMTypesResponse> createGetHMTypesResponse(GetHMTypesResponse value) {
        return new JAXBElement<GetHMTypesResponse>(_GetHMTypesResponse_QNAME, GetHMTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHMTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "getHMTypes")
    public JAXBElement<GetHMTypes> createGetHMTypes(GetHMTypes value) {
        return new JAXBElement<GetHMTypes>(_GetHMTypes_QNAME, GetHMTypes.class, null, value);
    }

}
