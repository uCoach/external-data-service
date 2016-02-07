
package ucoach.data.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per getUserByEmailResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="getUserByEmailResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userByEmail" type="{http://ws.data.ucoach/}user" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserByEmailResponse", propOrder = {
    "userByEmail"
})
public class GetUserByEmailResponse {

    protected User userByEmail;

    /**
     * Recupera il valore della proprietà userByEmail.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUserByEmail() {
        return userByEmail;
    }

    /**
     * Imposta il valore della proprietà userByEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUserByEmail(User value) {
        this.userByEmail = value;
    }

}
