//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package info.oais.oaisif.pds;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for Units_of_Acceleration</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="Units_of_Acceleration">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="cm/s**2"/>
 *     <enumeration value="km/s**2"/>
 *     <enumeration value="m/s**2"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "Units_of_Acceleration")
@XmlEnum
public enum UnitsOfAcceleration {

    @XmlEnumValue("cm/s**2")
    CM_S_2("cm/s**2"),
    @XmlEnumValue("km/s**2")
    KM_S_2("km/s**2"),
    @XmlEnumValue("m/s**2")
    M_S_2("m/s**2");
    private final String value;

    UnitsOfAcceleration(String v) {
        value = v;
    }

    /**
     * Gets the value associated to the enum constant.
     * 
     * @return
     *     The value linked to the enum.
     */
    public String value() {
        return value;
    }

    /**
     * Gets the enum associated to the value passed as parameter.
     * 
     * @param v
     *     The value to get the enum from.
     * @return
     *     The enum which corresponds to the value, if it exists.
     * @throws IllegalArgumentException
     *     If no value matches in the enum declaration.
     */
    public static UnitsOfAcceleration fromValue(String v) {
        for (UnitsOfAcceleration c: UnitsOfAcceleration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
