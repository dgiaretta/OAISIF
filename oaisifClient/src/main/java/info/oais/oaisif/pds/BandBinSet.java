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
 * The Band_Bin_Set class contains the spectral
 *         characteristics for all the spectral bands in a
 *         qube.
 * 
 * <p>Java class for Band_Bin_Set complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Band_Bin_Set">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Band_Bin" type="{http://pds.nasa.gov/pds4/pds/v1}Band_Bin" maxOccurs="unbounded"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Band_Bin_Set", propOrder = {
    "bandBin"
})
public class BandBinSet {

    @XmlElement(name = "Band_Bin", required = true)
    protected List<BandBin> bandBin;

    /**
     * Gets the value of the bandBin property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bandBin property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getBandBin().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BandBin }
     * </p>
     * 
     * 
     * @return
     *     The value of the bandBin property.
     */
    public List<BandBin> getBandBin() {
        if (bandBin == null) {
            bandBin = new ArrayList<>();
        }
        return this.bandBin;
    }

}