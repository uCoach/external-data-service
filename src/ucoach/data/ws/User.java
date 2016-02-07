
package ucoach.data.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per user complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="user">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="twitterUsername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentHealthMeasures" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="healthMeasure" type="{http://ws.data.ucoach/}healthMeasure" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="coach" type="{http://ws.data.ucoach/}coach" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "id",
    "firstname",
    "lastname",
    "birthdate",
    "email",
    "password",
    "twitterUsername",
    "currentHealthMeasures",
    "coach"
})
public class User {

    protected int id;
    protected String firstname;
    protected String lastname;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar birthdate;
    protected String email;
    protected String password;
    protected String twitterUsername;
    protected User.CurrentHealthMeasures currentHealthMeasures;
    protected Coach coach;

    /**
     * Recupera il valore della proprietà id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Recupera il valore della proprietà firstname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Imposta il valore della proprietà firstname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Recupera il valore della proprietà lastname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Imposta il valore della proprietà lastname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Recupera il valore della proprietà birthdate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthdate() {
        return birthdate;
    }

    /**
     * Imposta il valore della proprietà birthdate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthdate(XMLGregorianCalendar value) {
        this.birthdate = value;
    }

    /**
     * Recupera il valore della proprietà email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta il valore della proprietà email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Recupera il valore della proprietà password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta il valore della proprietà password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Recupera il valore della proprietà twitterUsername.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTwitterUsername() {
        return twitterUsername;
    }

    /**
     * Imposta il valore della proprietà twitterUsername.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTwitterUsername(String value) {
        this.twitterUsername = value;
    }

    /**
     * Recupera il valore della proprietà currentHealthMeasures.
     * 
     * @return
     *     possible object is
     *     {@link User.CurrentHealthMeasures }
     *     
     */
    public User.CurrentHealthMeasures getCurrentHealthMeasures() {
        return currentHealthMeasures;
    }

    /**
     * Imposta il valore della proprietà currentHealthMeasures.
     * 
     * @param value
     *     allowed object is
     *     {@link User.CurrentHealthMeasures }
     *     
     */
    public void setCurrentHealthMeasures(User.CurrentHealthMeasures value) {
        this.currentHealthMeasures = value;
    }

    /**
     * Recupera il valore della proprietà coach.
     * 
     * @return
     *     possible object is
     *     {@link Coach }
     *     
     */
    public Coach getCoach() {
        return coach;
    }

    /**
     * Imposta il valore della proprietà coach.
     * 
     * @param value
     *     allowed object is
     *     {@link Coach }
     *     
     */
    public void setCoach(Coach value) {
        this.coach = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="healthMeasure" type="{http://ws.data.ucoach/}healthMeasure" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "healthMeasure"
    })
    public static class CurrentHealthMeasures {

        protected List<HealthMeasure> healthMeasure;

        /**
         * Gets the value of the healthMeasure property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the healthMeasure property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHealthMeasure().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link HealthMeasure }
         * 
         * 
         */
        public List<HealthMeasure> getHealthMeasure() {
            if (healthMeasure == null) {
                healthMeasure = new ArrayList<HealthMeasure>();
            }
            return this.healthMeasure;
        }

    }

}
