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
import jakarta.xml.bind.annotation.XmlType;


/**
 * The Product SIP class defines a product for the
 *         Submission Information Package.
 * 
 * <p>Java class for Product_SIP complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Product_SIP">
 *   <complexContent>
 *     <extension base="{http://pds.nasa.gov/pds4/pds/v1}Product">
 *       <sequence>
 *         <element name="Reference_List" type="{http://pds.nasa.gov/pds4/pds/v1}Reference_List" minOccurs="0"/>
 *         <element name="Information_Package_Component" type="{http://pds.nasa.gov/pds4/pds/v1}Information_Package_Component" maxOccurs="unbounded"/>
 *         <element name="Submission_Information_Package" type="{http://pds.nasa.gov/pds4/pds/v1}Submission_Information_Package"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product_SIP", propOrder = {
    "referenceList",
    "informationPackageComponent",
    "submissionInformationPackage"
})
public class ProductSIP
    extends Product
{

    @XmlElement(name = "Reference_List")
    protected ReferenceList referenceList;
    @XmlElement(name = "Information_Package_Component", required = true)
    protected List<InformationPackageComponent> informationPackageComponent;
    @XmlElement(name = "Submission_Information_Package", required = true)
    protected SubmissionInformationPackage submissionInformationPackage;

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
     * Gets the value of the informationPackageComponent property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informationPackageComponent property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getInformationPackageComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InformationPackageComponent }
     * </p>
     * 
     * 
     * @return
     *     The value of the informationPackageComponent property.
     */
    public List<InformationPackageComponent> getInformationPackageComponent() {
        if (informationPackageComponent == null) {
            informationPackageComponent = new ArrayList<>();
        }
        return this.informationPackageComponent;
    }

    /**
     * Gets the value of the submissionInformationPackage property.
     * 
     * @return
     *     possible object is
     *     {@link SubmissionInformationPackage }
     *     
     */
    public SubmissionInformationPackage getSubmissionInformationPackage() {
        return submissionInformationPackage;
    }

    /**
     * Sets the value of the submissionInformationPackage property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmissionInformationPackage }
     *     
     */
    public void setSubmissionInformationPackage(SubmissionInformationPackage value) {
        this.submissionInformationPackage = value;
    }

}
