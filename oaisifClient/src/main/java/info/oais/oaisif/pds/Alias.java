//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package info.oais.oaisif.pds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The Alias class provides a single alternate name
 *         and identification for this product in this or some other
 *         archive or data system.
 * 
 * <p>Java class for Alias complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Alias">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="alternate_id" type="{http://pds.nasa.gov/pds4/pds/v1}alternate_id" minOccurs="0"/>
 *         <element name="alternate_title" type="{http://pds.nasa.gov/pds4/pds/v1}alternate_title" minOccurs="0"/>
 *         <element name="comment" type="{http://pds.nasa.gov/pds4/pds/v1}comment" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Alias", propOrder = {
    "alternateId",
    "alternateTitle",
    "comment"
})
public class Alias {

    @XmlElement(name = "alternate_id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String alternateId;
    @XmlElement(name = "alternate_title")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String alternateTitle;
    protected String comment;

    /**
     * Gets the value of the alternateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateId() {
        return alternateId;
    }

    /**
     * Sets the value of the alternateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateId(String value) {
        this.alternateId = value;
    }

    /**
     * Gets the value of the alternateTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateTitle() {
        return alternateTitle;
    }

    /**
     * Sets the value of the alternateTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateTitle(String value) {
        this.alternateTitle = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

}
