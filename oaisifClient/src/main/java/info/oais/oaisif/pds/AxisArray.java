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
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The Axis Array class is used as a component of
 *         the array class and defines an axis of the
 *         array.
 * 
 * <p>Java class for Axis_Array complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Axis_Array">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="axis_name" type="{http://pds.nasa.gov/pds4/pds/v1}axis_name"/>
 *         <element name="local_identifier" type="{http://pds.nasa.gov/pds4/pds/v1}local_identifier" minOccurs="0"/>
 *         <element name="elements" type="{http://pds.nasa.gov/pds4/pds/v1}elements"/>
 *         <element name="unit" type="{http://pds.nasa.gov/pds4/pds/v1}unit" minOccurs="0"/>
 *         <element name="sequence_number" type="{http://pds.nasa.gov/pds4/pds/v1}sequence_number"/>
 *         <element name="Band_Bin_Set" type="{http://pds.nasa.gov/pds4/pds/v1}Band_Bin_Set" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Axis_Array", propOrder = {
    "axisName",
    "localIdentifier",
    "elements",
    "unit",
    "sequenceNumber",
    "bandBinSet"
})
public class AxisArray {

    @XmlElement(name = "axis_name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String axisName;
    @XmlElement(name = "local_identifier")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String localIdentifier;
    @XmlElement(required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger elements;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String unit;
    @XmlElement(name = "sequence_number")
    @XmlSchemaType(name = "unsignedLong")
    protected int sequenceNumber;
    @XmlElement(name = "Band_Bin_Set")
    protected BandBinSet bandBinSet;

    /**
     * Gets the value of the axisName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAxisName() {
        return axisName;
    }

    /**
     * Sets the value of the axisName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAxisName(String value) {
        this.axisName = value;
    }

    /**
     * Gets the value of the localIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalIdentifier() {
        return localIdentifier;
    }

    /**
     * Sets the value of the localIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalIdentifier(String value) {
        this.localIdentifier = value;
    }

    /**
     * Gets the value of the elements property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getElements() {
        return elements;
    }

    /**
     * Sets the value of the elements property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setElements(BigInteger value) {
        this.elements = value;
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
     * Gets the value of the sequenceNumber property.
     * 
     */
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     */
    public void setSequenceNumber(int value) {
        this.sequenceNumber = value;
    }

    /**
     * Gets the value of the bandBinSet property.
     * 
     * @return
     *     possible object is
     *     {@link BandBinSet }
     *     
     */
    public BandBinSet getBandBinSet() {
        return bandBinSet;
    }

    /**
     * Sets the value of the bandBinSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BandBinSet }
     *     
     */
    public void setBandBinSet(BandBinSet value) {
        this.bandBinSet = value;
    }

}