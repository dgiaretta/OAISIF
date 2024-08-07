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
 * The Table Binary class is an extension of table
 *         base and defines a simple binary table.
 * 
 * <p>Java class for Table_Binary complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Table_Binary">
 *   <complexContent>
 *     <extension base="{http://pds.nasa.gov/pds4/pds/v1}Table_Base">
 *       <sequence>
 *         <element name="record_delimiter" type="{http://pds.nasa.gov/pds4/pds/v1}record_delimiter" minOccurs="0"/>
 *         <element name="Uniformly_Sampled" type="{http://pds.nasa.gov/pds4/pds/v1}Uniformly_Sampled" minOccurs="0"/>
 *         <element name="Record_Binary" type="{http://pds.nasa.gov/pds4/pds/v1}Record_Binary"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Table_Binary", propOrder = {
    "recordDelimiter",
    "uniformlySampled",
    "recordBinary"
})
public class TableBinary
    extends TableBase
{

    @XmlElement(name = "record_delimiter")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String recordDelimiter;
    @XmlElement(name = "Uniformly_Sampled")
    protected UniformlySampled uniformlySampled;
    @XmlElement(name = "Record_Binary", required = true)
    protected RecordBinary recordBinary;

    /**
     * Gets the value of the recordDelimiter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordDelimiter() {
        return recordDelimiter;
    }

    /**
     * Sets the value of the recordDelimiter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordDelimiter(String value) {
        this.recordDelimiter = value;
    }

    /**
     * Gets the value of the uniformlySampled property.
     * 
     * @return
     *     possible object is
     *     {@link UniformlySampled }
     *     
     */
    public UniformlySampled getUniformlySampled() {
        return uniformlySampled;
    }

    /**
     * Sets the value of the uniformlySampled property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniformlySampled }
     *     
     */
    public void setUniformlySampled(UniformlySampled value) {
        this.uniformlySampled = value;
    }

    /**
     * Gets the value of the recordBinary property.
     * 
     * @return
     *     possible object is
     *     {@link RecordBinary }
     *     
     */
    public RecordBinary getRecordBinary() {
        return recordBinary;
    }

    /**
     * Sets the value of the recordBinary property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordBinary }
     *     
     */
    public void setRecordBinary(RecordBinary value) {
        this.recordBinary = value;
    }

}
