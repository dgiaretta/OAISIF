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
 * <p>Java class for Units_of_Map_Scale</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="Units_of_Map_Scale">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="km/pixel"/>
 *     <enumeration value="m/pixel"/>
 *     <enumeration value="mm/pixel"/>
 *     <enumeration value="pixel/deg"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "Units_of_Map_Scale")
@XmlEnum
public enum UnitsOfMapScale {

    @XmlEnumValue("km/pixel")
    KM_PIXEL("km/pixel"),
    @XmlEnumValue("m/pixel")
    M_PIXEL("m/pixel"),
    @XmlEnumValue("mm/pixel")
    MM_PIXEL("mm/pixel"),
    @XmlEnumValue("pixel/deg")
    PIXEL_DEG("pixel/deg");
    private final String value;

    UnitsOfMapScale(String v) {
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
    public static UnitsOfMapScale fromValue(String v) {
        for (UnitsOfMapScale c: UnitsOfMapScale.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
