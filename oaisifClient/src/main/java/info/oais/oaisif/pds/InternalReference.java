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
 * The Internal_Reference class is used to
 *         cross-reference other products in the PDS registry
 *         system.
 * 
 * <p>Java class for Internal_Reference complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Internal_Reference">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <choice>
 *           <element name="lid_reference" type="{http://pds.nasa.gov/pds4/pds/v1}lid_reference"/>
 *           <element name="lidvid_reference" type="{http://pds.nasa.gov/pds4/pds/v1}lidvid_reference"/>
 *         </choice>
 *         <element name="reference_type" type="{http://pds.nasa.gov/pds4/pds/v1}reference_type"/>
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
@XmlType(name = "Internal_Reference", propOrder = {
    "lidReference",
    "lidvidReference",
    "referenceType",
    "comment"
})
public class InternalReference {

    @XmlElement(name = "lid_reference")
    protected String lidReference;
    @XmlElement(name = "lidvid_reference")
    protected String lidvidReference;
    @XmlElement(name = "reference_type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String referenceType;
    protected String comment;

    /**
     * Gets the value of the lidReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLidReference() {
        return lidReference;
    }

    /**
     * Sets the value of the lidReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLidReference(String value) {
        this.lidReference = value;
    }

    /**
     * Gets the value of the lidvidReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLidvidReference() {
        return lidvidReference;
    }

    /**
     * Sets the value of the lidvidReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLidvidReference(String value) {
        this.lidvidReference = value;
    }

    /**
     * Gets the value of the referenceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceType() {
        return referenceType;
    }

    /**
     * Sets the value of the referenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceType(String value) {
        this.referenceType = value;
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