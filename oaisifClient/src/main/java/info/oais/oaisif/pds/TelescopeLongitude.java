//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package info.oais.oaisif.pds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;


/**
 * The telescope_longitude attribute provides the
 *         angular distance of the telescope east (positive), measured by
 *         the angle contained between the meridian of the telescope and
 *         the reference figure (or datum) prime
 *         meridian.
 * 
 * <p>Java class for telescope_longitude complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="telescope_longitude">
 *   <simpleContent>
 *     <extension base="<http://pds.nasa.gov/pds4/pds/v1>telescope_longitude_WO_Units">
 *       <attribute name="unit" use="required" type="{http://pds.nasa.gov/pds4/pds/v1}Units_of_Angle" />
 *     </extension>
 *   </simpleContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "telescope_longitude", propOrder = {
    "value"
})
public class TelescopeLongitude {

    @XmlValue
    protected double value;
    @XmlAttribute(name = "unit", required = true)
    protected UnitsOfAngle unit;

    /**
     * Gets the value of the value property.
     * 
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link UnitsOfAngle }
     *     
     */
    public UnitsOfAngle getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitsOfAngle }
     *     
     */
    public void setUnit(UnitsOfAngle value) {
        this.unit = value;
    }

}