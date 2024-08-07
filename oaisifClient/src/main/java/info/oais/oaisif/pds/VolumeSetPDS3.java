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
 * The Volume_Set_PDS3 class is used to capture the
 *         volume set information from the PDS3 Data Set
 *         Catalog.
 * 
 * <p>Java class for Volume_Set_PDS3 complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Volume_Set_PDS3">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="volume_series_name" type="{http://pds.nasa.gov/pds4/pds/v1}volume_series_name"/>
 *         <element name="volume_set_id" type="{http://pds.nasa.gov/pds4/pds/v1}volume_set_id"/>
 *         <element name="volume_set_name" type="{http://pds.nasa.gov/pds4/pds/v1}volume_set_name"/>
 *         <element name="volumes" type="{http://pds.nasa.gov/pds4/pds/v1}volumes"/>
 *         <element name="description" type="{http://pds.nasa.gov/pds4/pds/v1}description" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Volume_Set_PDS3", propOrder = {
    "volumeSeriesName",
    "volumeSetId",
    "volumeSetName",
    "volumes",
    "description"
})
public class VolumeSetPDS3 {

    @XmlElement(name = "volume_series_name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String volumeSeriesName;
    @XmlElement(name = "volume_set_id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String volumeSetId;
    @XmlElement(name = "volume_set_name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String volumeSetName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger volumes;
    protected String description;

    /**
     * Gets the value of the volumeSeriesName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolumeSeriesName() {
        return volumeSeriesName;
    }

    /**
     * Sets the value of the volumeSeriesName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolumeSeriesName(String value) {
        this.volumeSeriesName = value;
    }

    /**
     * Gets the value of the volumeSetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolumeSetId() {
        return volumeSetId;
    }

    /**
     * Sets the value of the volumeSetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolumeSetId(String value) {
        this.volumeSetId = value;
    }

    /**
     * Gets the value of the volumeSetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolumeSetName() {
        return volumeSetName;
    }

    /**
     * Sets the value of the volumeSetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolumeSetName(String value) {
        this.volumeSetName = value;
    }

    /**
     * Gets the value of the volumes property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVolumes() {
        return volumes;
    }

    /**
     * Sets the value of the volumes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVolumes(BigInteger value) {
        this.volumes = value;
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

}
