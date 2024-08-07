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
 * The property map entry consists of a property
 *         name and one or more values.
 * 
 * <p>Java class for Property_Map_Entry complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Property_Map_Entry">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="property_map_type" type="{http://pds.nasa.gov/pds4/pds/v1}property_map_type" minOccurs="0"/>
 *         <element name="property_map_subtype" type="{http://pds.nasa.gov/pds4/pds/v1}property_map_subtype" minOccurs="0"/>
 *         <element name="property_name" type="{http://pds.nasa.gov/pds4/pds/v1}property_name"/>
 *         <element name="property_value" type="{http://pds.nasa.gov/pds4/pds/v1}property_value" maxOccurs="unbounded"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Property_Map_Entry", propOrder = {
    "propertyMapType",
    "propertyMapSubtype",
    "propertyName",
    "propertyValue"
})
public class PropertyMapEntry {

    @XmlElement(name = "property_map_type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String propertyMapType;
    @XmlElement(name = "property_map_subtype")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String propertyMapSubtype;
    @XmlElement(name = "property_name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String propertyName;
    @XmlElement(name = "property_value", required = true)
    protected List<String> propertyValue;

    /**
     * Gets the value of the propertyMapType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyMapType() {
        return propertyMapType;
    }

    /**
     * Sets the value of the propertyMapType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyMapType(String value) {
        this.propertyMapType = value;
    }

    /**
     * Gets the value of the propertyMapSubtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyMapSubtype() {
        return propertyMapSubtype;
    }

    /**
     * Sets the value of the propertyMapSubtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyMapSubtype(String value) {
        this.propertyMapSubtype = value;
    }

    /**
     * Gets the value of the propertyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the value of the propertyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyName(String value) {
        this.propertyName = value;
    }

    /**
     * Gets the value of the propertyValue property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyValue property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getPropertyValue().add(newItem);
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
     *     The value of the propertyValue property.
     */
    public List<String> getPropertyValue() {
        if (propertyValue == null) {
            propertyValue = new ArrayList<>();
        }
        return this.propertyValue;
    }

}
