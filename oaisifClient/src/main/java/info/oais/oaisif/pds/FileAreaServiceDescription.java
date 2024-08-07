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
 * The File Area Service Description class
 *         describes a file that contains a service
 *         description.
 * 
 * <p>Java class for File_Area_Service_Description complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="File_Area_Service_Description">
 *   <complexContent>
 *     <extension base="{http://pds.nasa.gov/pds4/pds/v1}File_Area">
 *       <sequence>
 *         <element name="File" type="{http://pds.nasa.gov/pds4/pds/v1}File"/>
 *         <element name="Service_Description" type="{http://pds.nasa.gov/pds4/pds/v1}Service_Description" maxOccurs="unbounded"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "File_Area_Service_Description", propOrder = {
    "file",
    "serviceDescription"
})
public class FileAreaServiceDescription
    extends FileArea
{

    @XmlElement(name = "File", required = true)
    protected File file;
    @XmlElement(name = "Service_Description", required = true)
    protected List<ServiceDescription> serviceDescription;

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link File }
     *     
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link File }
     *     
     */
    public void setFile(File value) {
        this.file = value;
    }

    /**
     * Gets the value of the serviceDescription property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceDescription property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getServiceDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceDescription }
     * </p>
     * 
     * 
     * @return
     *     The value of the serviceDescription property.
     */
    public List<ServiceDescription> getServiceDescription() {
        if (serviceDescription == null) {
            serviceDescription = new ArrayList<>();
        }
        return this.serviceDescription;
    }

}
