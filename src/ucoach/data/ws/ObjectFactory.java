
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

    private final static QName _CreateUser_QNAME = new QName("http://ws.data.ucoach/", "createUser");
    private final static QName _UpdateUser_QNAME = new QName("http://ws.data.ucoach/", "updateUser");
    private final static QName _DeleteUser_QNAME = new QName("http://ws.data.ucoach/", "deleteUser");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://ws.data.ucoach/", "deleteUserResponse");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://ws.data.ucoach/", "updateUserResponse");
    private final static QName _GetUserResponse_QNAME = new QName("http://ws.data.ucoach/", "getUserResponse");
    private final static QName _GetUserByEmail_QNAME = new QName("http://ws.data.ucoach/", "getUserByEmail");
    private final static QName _GetUser_QNAME = new QName("http://ws.data.ucoach/", "getUser");
    private final static QName _CreateUserResponse_QNAME = new QName("http://ws.data.ucoach/", "createUserResponse");
    private final static QName _GetUserByEmailResponse_QNAME = new QName("http://ws.data.ucoach/", "getUserByEmailResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ucoach.data.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link GetUserByEmail }
     * 
     */
    public GetUserByEmail createGetUserByEmail() {
        return new GetUserByEmail();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link GetUserByEmailResponse }
     * 
     */
    public GetUserByEmailResponse createGetUserByEmailResponse() {
        return new GetUserByEmailResponse();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link HealthMeasure }
     * 
     */
    public HealthMeasure createHealthMeasure() {
        return new HealthMeasure();
    }

    /**
     * Create an instance of {@link Coach }
     * 
     */
    public Coach createCoach() {
        return new Coach();
    }

    /**
     * Create an instance of {@link HmType }
     * 
     */
    public HmType createHmType() {
        return new HmType();
    }

    /**
     * Create an instance of {@link User.CurrentHealthMeasures }
     * 
     */
    public User.CurrentHealthMeasures createUserCurrentHealthMeasures() {
        return new User.CurrentHealthMeasures();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "getUserByEmail")
    public JAXBElement<GetUserByEmail> createGetUserByEmail(GetUserByEmail value) {
        return new JAXBElement<GetUserByEmail>(_GetUserByEmail_QNAME, GetUserByEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.data.ucoach/", name = "getUserByEmailResponse")
    public JAXBElement<GetUserByEmailResponse> createGetUserByEmailResponse(GetUserByEmailResponse value) {
        return new JAXBElement<GetUserByEmailResponse>(_GetUserByEmailResponse_QNAME, GetUserByEmailResponse.class, null, value);
    }

}
