//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package info.oais.oaisif.pds;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The Target class provides a description of a
 *         phyiscal object that is the object of data collection. This
 *         class captures the PDS3 catalog Target
 *         information.
 * 
 * <p>Java class for Target_PDS3 complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Target_PDS3">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="target_name" type="{http://pds.nasa.gov/pds4/pds/v1}target_name"/>
 *         <element name="orbit_direction" type="{http://pds.nasa.gov/pds4/pds/v1}orbit_direction" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="primary_body_name" type="{http://pds.nasa.gov/pds4/pds/v1}primary_body_name"/>
 *         <element name="rotation_direction" type="{http://pds.nasa.gov/pds4/pds/v1}rotation_direction" minOccurs="0"/>
 *         <element name="target_desc" type="{http://pds.nasa.gov/pds4/pds/v1}target_desc"/>
 *         <element name="target_type" type="{http://pds.nasa.gov/pds4/pds/v1}target_type"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Target_PDS3", propOrder = {
    "targetName",
    "orbitDirection",
    "primaryBodyName",
    "rotationDirection",
    "targetDesc",
    "targetType"
})
public class TargetPDS3 {

    @XmlElement(name = "target_name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String targetName;
    @XmlElement(name = "orbit_direction")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> orbitDirection;
    @XmlElement(name = "primary_body_name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String primaryBodyName;
    @XmlElement(name = "rotation_direction")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String rotationDirection;
    @XmlElement(name = "target_desc", required = true)
    protected String targetDesc;
    @XmlElement(name = "target_type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String targetType;

    /**
     * Gets the value of the targetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetName() {
        return targetName;
    }

    /**
     * Sets the value of the targetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetName(String value) {
        this.targetName = value;
    }

    /**
     * Gets the value of the orbitDirection property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orbitDirection property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getOrbitDirection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * </p>
     * 
     * 
     * @return
     *     The value of the orbitDirection property.
     */
    public List<String> getOrbitDirection() {
        if (orbitDirection == null) {
            orbitDirection = new ArrayList<>();
        }
        return this.orbitDirection;
    }

    /**
     * Gets the value of the primaryBodyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryBodyName() {
        return primaryBodyName;
    }

    /**
     * Sets the value of the primaryBodyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryBodyName(String value) {
        this.primaryBodyName = value;
    }

    /**
     * Gets the value of the rotationDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRotationDirection() {
        return rotationDirection;
    }

    /**
     * Sets the value of the rotationDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRotationDirection(String value) {
        this.rotationDirection = value;
    }

    /**
     * Gets the value of the targetDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetDesc() {
        return targetDesc;
    }

    /**
     * Sets the value of the targetDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetDesc(String value) {
        this.targetDesc = value;
    }

    /**
     * Gets the value of the targetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetType() {
        return targetType;
    }

    /**
     * Sets the value of the targetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetType(String value) {
        this.targetType = value;
    }

}