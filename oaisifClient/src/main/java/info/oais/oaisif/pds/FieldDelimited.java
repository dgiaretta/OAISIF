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
 * The Field_Delimited class defines a field of a
 *         delimited record or a field of a delimited
 *         group.
 * 
 * <p>Java class for Field_Delimited complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Field_Delimited">
 *   <complexContent>
 *     <extension base="{http://pds.nasa.gov/pds4/pds/v1}Field">
 *       <sequence>
 *         <element name="data_type" type="{http://pds.nasa.gov/pds4/pds/v1}data_type"/>
 *         <element name="maximum_field_length" type="{http://pds.nasa.gov/pds4/pds/v1}maximum_field_length" minOccurs="0"/>
 *         <element name="field_format" type="{http://pds.nasa.gov/pds4/pds/v1}field_format" minOccurs="0"/>
 *         <element name="unit" type="{http://pds.nasa.gov/pds4/pds/v1}unit" minOccurs="0"/>
 *         <element name="scaling_factor" type="{http://pds.nasa.gov/pds4/pds/v1}scaling_factor" minOccurs="0"/>
 *         <element name="value_offset" type="{http://pds.nasa.gov/pds4/pds/v1}value_offset" minOccurs="0"/>
 *         <element name="description" type="{http://pds.nasa.gov/pds4/pds/v1}description" minOccurs="0"/>
 *         <element name="Special_Constants" type="{http://pds.nasa.gov/pds4/pds/v1}Special_Constants" minOccurs="0"/>
 *         <element name="Field_Statistics" type="{http://pds.nasa.gov/pds4/pds/v1}Field_Statistics" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Field_Delimited", propOrder = {
    "dataType",
    "maximumFieldLength",
    "fieldFormat",
    "unit",
    "scalingFactor",
    "valueOffset",
    "description",
    "specialConstants",
    "fieldStatistics"
})
public class FieldDelimited
    extends Field
{

    @XmlElement(name = "data_type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String dataType;
    @XmlElement(name = "maximum_field_length")
    protected MaximumFieldLength maximumFieldLength;
    @XmlElement(name = "field_format")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String fieldFormat;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String unit;
    @XmlElement(name = "scaling_factor")
    protected Double scalingFactor;
    @XmlElement(name = "value_offset")
    protected Double valueOffset;
    protected String description;
    @XmlElement(name = "Special_Constants")
    protected SpecialConstants specialConstants;
    @XmlElement(name = "Field_Statistics")
    protected FieldStatistics fieldStatistics;

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

    /**
     * Gets the value of the maximumFieldLength property.
     * 
     * @return
     *     possible object is
     *     {@link MaximumFieldLength }
     *     
     */
    public MaximumFieldLength getMaximumFieldLength() {
        return maximumFieldLength;
    }

    /**
     * Sets the value of the maximumFieldLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumFieldLength }
     *     
     */
    public void setMaximumFieldLength(MaximumFieldLength value) {
        this.maximumFieldLength = value;
    }

    /**
     * Gets the value of the fieldFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldFormat() {
        return fieldFormat;
    }

    /**
     * Sets the value of the fieldFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldFormat(String value) {
        this.fieldFormat = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Gets the value of the scalingFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getScalingFactor() {
        return scalingFactor;
    }

    /**
     * Sets the value of the scalingFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setScalingFactor(Double value) {
        this.scalingFactor = value;
    }

    /**
     * Gets the value of the valueOffset property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValueOffset() {
        return valueOffset;
    }

    /**
     * Sets the value of the valueOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValueOffset(Double value) {
        this.valueOffset = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the specialConstants property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialConstants }
     *     
     */
    public SpecialConstants getSpecialConstants() {
        return specialConstants;
    }

    /**
     * Sets the value of the specialConstants property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialConstants }
     *     
     */
    public void setSpecialConstants(SpecialConstants value) {
        this.specialConstants = value;
    }

    /**
     * Gets the value of the fieldStatistics property.
     * 
     * @return
     *     possible object is
     *     {@link FieldStatistics }
     *     
     */
    public FieldStatistics getFieldStatistics() {
        return fieldStatistics;
    }

    /**
     * Sets the value of the fieldStatistics property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldStatistics }
     *     
     */
    public void setFieldStatistics(FieldStatistics value) {
        this.fieldStatistics = value;
    }

}
