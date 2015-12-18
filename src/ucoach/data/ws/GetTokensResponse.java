
package ucoach.data.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per getTokensResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="getTokensResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tokens" type="{http://ws.data.ucoach/}googleTokens" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTokensResponse", propOrder = {
    "tokens"
})
public class GetTokensResponse {

    protected GoogleTokens tokens;

    /**
     * Recupera il valore della proprietà tokens.
     * 
     * @return
     *     possible object is
     *     {@link GoogleTokens }
     *     
     */
    public GoogleTokens getTokens() {
        return tokens;
    }

    /**
     * Imposta il valore della proprietà tokens.
     * 
     * @param value
     *     allowed object is
     *     {@link GoogleTokens }
     *     
     */
    public void setTokens(GoogleTokens value) {
        this.tokens = value;
    }

}
