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
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The Group_Field_Binary class allows a group of
 *         table fields.
 * 
 * <p>Java class for Group_Field_Binary complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Group_Field_Binary">
 *   <complexContent>
 *     <extension base="{http://pds.nasa.gov/pds4/pds/v1}Group">
 *       <sequence>
 *         <element name="group_location" type="{http://pds.nasa.gov/pds4/pds/v1}group_location"/>
 *         <element name="group_length" type="{http://pds.nasa.gov/pds4/pds/v1}group_length"/>
 *         <choice maxOccurs="unbounded">
 *           <element name="Field_Binary" type="{http://pds.nasa.gov/pds4/pds/v1}Field_Binary"/>
 *           <element name="Group_Field_Binary" type="{http://pds.nasa.gov/pds4/pds/v1}Group_Field_Binary"/>
 *         </choice>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Group_Field_Binary", propOrder = {
    "groupLocation",
    "groupLength",
    "fieldBinaryOrGroupFieldBinary"
})
public class GroupFieldBinary
    extends Group
{

    @XmlElement(name = "group_location", required = true)
    protected GroupLocation groupLocation;
    @XmlElement(name = "group_length", required = true)
    protected GroupLength groupLength;
    @XmlElements({
        @XmlElement(name = "Field_Binary", type = FieldBinary.class),
        @XmlElement(name = "Group_Field_Binary", type = GroupFieldBinary.class)
    })
    protected List<Object> fieldBinaryOrGroupFieldBinary;

    /**
     * Gets the value of the groupLocation property.
     * 
     * @return
     *     possible object is
     *     {@link GroupLocation }
     *     
     */
    public GroupLocation getGroupLocation() {
        return groupLocation;
    }

    /**
     * Sets the value of the groupLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupLocation }
     *     
     */
    public void setGroupLocation(GroupLocation value) {
        this.groupLocation = value;
    }

    /**
     * Gets the value of the groupLength property.
     * 
     * @return
     *     possible object is
     *     {@link GroupLength }
     *     
     */
    public GroupLength getGroupLength() {
        return groupLength;
    }

    /**
     * Sets the value of the groupLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupLength }
     *     
     */
    public void setGroupLength(GroupLength value) {
        this.groupLength = value;
    }

    /**
     * Gets the value of the fieldBinaryOrGroupFieldBinary property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fieldBinaryOrGroupFieldBinary property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getFieldBinaryOrGroupFieldBinary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FieldBinary }
     * {@link GroupFieldBinary }
     * </p>
     * 
     * 
     * @return
     *     The value of the fieldBinaryOrGroupFieldBinary property.
     */
    public List<Object> getFieldBinaryOrGroupFieldBinary() {
        if (fieldBinaryOrGroupFieldBinary == null) {
            fieldBinaryOrGroupFieldBinary = new ArrayList<>();
        }
        return this.fieldBinaryOrGroupFieldBinary;
    }

}