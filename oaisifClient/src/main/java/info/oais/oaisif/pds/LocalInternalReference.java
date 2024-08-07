//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package info.oais.oaisif.pds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The Local Internal_Reference class is used to
 *         cross-reference other Description Objects in a PDS4
 *         label.
 * 
 * <p>Java class for Local_Internal_Reference complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Local_Internal_Reference">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="comment" type="{http://pds.nasa.gov/pds4/pds/v1}comment" minOccurs="0"/>
 *         <element name="local_identifier_reference" type="{http://pds.nasa.gov/pds4/pds/v1}local_identifier_reference"/>
 *         <element name="local_reference_type" type="{http://pds.nasa.gov/pds4/pds/v1}local_reference_type"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Local_Internal_Reference", propOrder = {
    "comment",
    "localIdentifierReference",
    "localReferenceType"
})
public class LocalInternalReference {

    protected String comment;
    @XmlElement(name = "local_identifier_reference", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object localIdentifierReference;
    @XmlElement(name = "local_reference_type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String localReferenceType;

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

    /**
     * Gets the value of the localIdentifierReference property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getLocalIdentifierReference() {
        return localIdentifierReference;
    }

    /**
     * Sets the value of the localIdentifierReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setLocalIdentifierReference(Object value) {
        this.localIdentifierReference = value;
    }

    /**
     * Gets the value of the localReferenceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalReferenceType() {
        return localReferenceType;
    }

    /**
     * Sets the value of the localReferenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalReferenceType(String value) {
        this.localReferenceType = value;
    }

}
