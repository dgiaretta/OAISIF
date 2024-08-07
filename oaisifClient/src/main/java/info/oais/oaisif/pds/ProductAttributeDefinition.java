//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package info.oais.oaisif.pds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The Product Attribute Definition provides an
 *         attribute definition in XML encoding.
 * 
 * <p>Java class for Product_Attribute_Definition complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Product_Attribute_Definition">
 *   <complexContent>
 *     <extension base="{http://pds.nasa.gov/pds4/pds/v1}Product">
 *       <sequence>
 *         <element name="Reference_List" type="{http://pds.nasa.gov/pds4/pds/v1}Reference_List" minOccurs="0"/>
 *         <element name="DD_Attribute_Full" type="{http://pds.nasa.gov/pds4/pds/v1}DD_Attribute_Full"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product_Attribute_Definition", propOrder = {
    "referenceList",
    "ddAttributeFull"
})
public class ProductAttributeDefinition
    extends Product
{

    @XmlElement(name = "Reference_List")
    protected ReferenceList referenceList;
    @XmlElement(name = "DD_Attribute_Full", required = true)
    protected DDAttributeFull ddAttributeFull;

    /**
     * Gets the value of the referenceList property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceList }
     *     
     */
    public ReferenceList getReferenceList() {
        return referenceList;
    }

    /**
     * Sets the value of the referenceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceList }
     *     
     */
    public void setReferenceList(ReferenceList value) {
        this.referenceList = value;
    }

    /**
     * Gets the value of the ddAttributeFull property.
     * 
     * @return
     *     possible object is
     *     {@link DDAttributeFull }
     *     
     */
    public DDAttributeFull getDDAttributeFull() {
        return ddAttributeFull;
    }

    /**
     * Sets the value of the ddAttributeFull property.
     * 
     * @param value
     *     allowed object is
     *     {@link DDAttributeFull }
     *     
     */
    public void setDDAttributeFull(DDAttributeFull value) {
        this.ddAttributeFull = value;
    }

}
