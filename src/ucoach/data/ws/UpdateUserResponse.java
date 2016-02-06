
package ucoach.data.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per updateUserResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="updateUserResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="updateUser" type="{http://ws.data.ucoach/}user" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateUserResponse", propOrder = {
    "updateUser"
})
public class UpdateUserResponse {

    protected User updateUser;

    /**
     * Recupera il valore della proprietà updateUser.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUpdateUser() {
        return updateUser;
    }

    /**
     * Imposta il valore della proprietà updateUser.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUpdateUser(User value) {
        this.updateUser = value;
    }

}
