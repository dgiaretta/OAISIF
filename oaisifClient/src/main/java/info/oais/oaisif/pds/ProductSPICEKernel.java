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
 * The Product SPICE Kernel class defines a SPICE
 *         kernel product.
 * 
 * <p>Java class for Product_SPICE_Kernel complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Product_SPICE_Kernel">
 *   <complexContent>
 *     <extension base="{http://pds.nasa.gov/pds4/pds/v1}Product">
 *       <sequence>
 *         <element name="Context_Area" type="{http://pds.nasa.gov/pds4/pds/v1}Context_Area"/>
 *         <element name="Reference_List" type="{http://pds.nasa.gov/pds4/pds/v1}Reference_List" minOccurs="0"/>
 *         <element name="File_Area_SPICE_Kernel" type="{http://pds.nasa.gov/pds4/pds/v1}File_Area_SPICE_Kernel"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product_SPICE_Kernel", propOrder = {
    "contextArea",
    "referenceList",
    "fileAreaSPICEKernel"
})
public class ProductSPICEKernel
    extends Product
{

    @XmlElement(name = "Context_Area", required = true)
    protected ContextArea contextArea;
    @XmlElement(name = "Reference_List")
    protected ReferenceList referenceList;
    @XmlElement(name = "File_Area_SPICE_Kernel", required = true)
    protected FileAreaSPICEKernel fileAreaSPICEKernel;

    /**
     * Gets the value of the contextArea property.
     * 
     * @return
     *     possible object is
     *     {@link ContextArea }
     *     
     */
    public ContextArea getContextArea() {
        return contextArea;
    }

    /**
     * Sets the value of the contextArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextArea }
     *     
     */
    public void setContextArea(ContextArea value) {
        this.contextArea = value;
    }

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
     * Gets the value of the fileAreaSPICEKernel property.
     * 
     * @return
     *     possible object is
     *     {@link FileAreaSPICEKernel }
     *     
     */
    public FileAreaSPICEKernel getFileAreaSPICEKernel() {
        return fileAreaSPICEKernel;
    }

    /**
     * Sets the value of the fileAreaSPICEKernel property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileAreaSPICEKernel }
     *     
     */
    public void setFileAreaSPICEKernel(FileAreaSPICEKernel value) {
        this.fileAreaSPICEKernel = value;
    }

}