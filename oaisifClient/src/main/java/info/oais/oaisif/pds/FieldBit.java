//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package info.oais.oaisif.pds;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The Field_Bit class provides parameters for
 *         extracting one field out of a string of bytes which contains
 *         packed data (that is, data values either smaller than a single
 *         byte, or crossing byte boundaries, or both.
 * 
 * <p>Java class for Field_Bit complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Field_Bit">
 *   <complexContent>
 *     <extension base="{http://pds.nasa.gov/pds4/pds/v1}Field">
 *       <sequence>
 *         <element name="start_bit" type="{http://pds.nasa.gov/pds4/pds/v1}start_bit"/>
 *         <element name="stop_bit" type="{http://pds.nasa.gov/pds4/pds/v1}stop_bit"/>
 *         <element name="data_type" type="{http://pds.nasa.gov/pds4/pds/v1}data_type"/>
 *         <element name="field_format" type="{http://pds.nasa.gov/pds4/pds/v1}field_format" minOccurs="0"/>
 *         <element name="unit" type="{http://pds.nasa.gov/pds4/pds/v1}unit" minOccurs="0"/>
 *         <element name="scaling_factor" type="{http://pds.nasa.gov/pds4/pds/v1}scaling_factor" minOccurs="0"/>
 *         <element name="value_offset" type="{http://pds.nasa.gov/pds4/pds/v1}value_offset" minOccurs="0"/>
 *         <element name="description" type="{http://pds.nasa.gov/pds4/pds/v1}description" minOccurs="0"/>
 *         <element name="Special_Constants" type="{http://pds.nasa.gov/pds4/pds/v1}Special_Constants" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Field_Bit", propOrder = {
    "startBit",
    "stopBit",
    "dataType",
    "fieldFormat",
    "unit",
    "scalingFactor",
    "valueOffset",
    "description",
    "specialConstants"
})
public class FieldBit
    extends Field
{

    @XmlElement(name = "start_bit", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger startBit;
    @XmlElement(name = "stop_bit", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger stopBit;
    @XmlElement(name = "data_type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String dataType;
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

    /**
     * Gets the value of the startBit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStartBit() {
        return startBit;
    }

    /**
     * Sets the value of the startBit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStartBit(BigInteger value) {
        this.startBit = value;
    }

    /**
     * Gets the value of the stopBit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStopBit() {
        return stopBit;
    }

    /**
     * Sets the value of the stopBit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStopBit(BigInteger value) {
        this.stopBit = value;
    }

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

}
