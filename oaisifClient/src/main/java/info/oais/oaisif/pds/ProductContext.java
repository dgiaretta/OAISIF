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
 * The Product Context class describes something
 *         that provides context and provenance for an observational
 *         product.
 * 
 * <p>Java class for Product_Context complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Product_Context">
 *   <complexContent>
 *     <extension base="{http://pds.nasa.gov/pds4/pds/v1}Product">
 *       <sequence>
 *         <element name="Discipline_Area" type="{http://pds.nasa.gov/pds4/pds/v1}Discipline_Area" minOccurs="0"/>
 *         <element name="Reference_List" type="{http://pds.nasa.gov/pds4/pds/v1}Reference_List" minOccurs="0"/>
 *         <choice>
 *           <element name="Agency" type="{http://pds.nasa.gov/pds4/pds/v1}Agency"/>
 *           <element name="Airborne" type="{http://pds.nasa.gov/pds4/pds/v1}Airborne"/>
 *           <element name="Facility" type="{http://pds.nasa.gov/pds4/pds/v1}Facility"/>
 *           <element name="Instrument" type="{http://pds.nasa.gov/pds4/pds/v1}Instrument"/>
 *           <element name="Instrument_Host" type="{http://pds.nasa.gov/pds4/pds/v1}Instrument_Host"/>
 *           <element name="Investigation" type="{http://pds.nasa.gov/pds4/pds/v1}Investigation"/>
 *           <element name="Node" type="{http://pds.nasa.gov/pds4/pds/v1}Node"/>
 *           <element name="Other" type="{http://pds.nasa.gov/pds4/pds/v1}Other"/>
 *           <element name="PDS_Affiliate" type="{http://pds.nasa.gov/pds4/pds/v1}PDS_Affiliate"/>
 *           <element name="PDS_Guest" type="{http://pds.nasa.gov/pds4/pds/v1}PDS_Guest"/>
 *           <element name="Resource" type="{http://pds.nasa.gov/pds4/pds/v1}Resource"/>
 *           <element name="Target" type="{http://pds.nasa.gov/pds4/pds/v1}Target"/>
 *           <element name="Telescope" type="{http://pds.nasa.gov/pds4/pds/v1}Telescope"/>
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
@XmlType(name = "Product_Context", propOrder = {
    "disciplineArea",
    "referenceList",
    "agency",
    "airborne",
    "facility",
    "instrument",
    "instrumentHost",
    "investigation",
    "node",
    "other",
    "pdsAffiliate",
    "pdsGuest",
    "resource",
    "target",
    "telescope"
})
public class ProductContext
    extends Product
{

    @XmlElement(name = "Discipline_Area")
    protected DisciplineArea disciplineArea;
    @XmlElement(name = "Reference_List")
    protected ReferenceList referenceList;
    @XmlElement(name = "Agency")
    protected Agency agency;
    @XmlElement(name = "Airborne")
    protected Airborne airborne;
    @XmlElement(name = "Facility")
    protected Facility facility;
    @XmlElement(name = "Instrument")
    protected Instrument instrument;
    @XmlElement(name = "Instrument_Host")
    protected InstrumentHost instrumentHost;
    @XmlElement(name = "Investigation")
    protected Investigation investigation;
    @XmlElement(name = "Node")
    protected Node node;
    @XmlElement(name = "Other")
    protected Other other;
    @XmlElement(name = "PDS_Affiliate")
    protected PDSAffiliate pdsAffiliate;
    @XmlElement(name = "PDS_Guest")
    protected PDSGuest pdsGuest;
    @XmlElement(name = "Resource")
    protected Resource resource;
    @XmlElement(name = "Target")
    protected Target target;
    @XmlElement(name = "Telescope")
    protected Telescope telescope;

    /**
     * Gets the value of the disciplineArea property.
     * 
     * @return
     *     possible object is
     *     {@link DisciplineArea }
     *     
     */
    public DisciplineArea getDisciplineArea() {
        return disciplineArea;
    }

    /**
     * Sets the value of the disciplineArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisciplineArea }
     *     
     */
    public void setDisciplineArea(DisciplineArea value) {
        this.disciplineArea = value;
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
     * Gets the value of the agency property.
     * 
     * @return
     *     possible object is
     *     {@link Agency }
     *     
     */
    public Agency getAgency() {
        return agency;
    }

    /**
     * Sets the value of the agency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agency }
     *     
     */
    public void setAgency(Agency value) {
        this.agency = value;
    }

    /**
     * Gets the value of the airborne property.
     * 
     * @return
     *     possible object is
     *     {@link Airborne }
     *     
     */
    public Airborne getAirborne() {
        return airborne;
    }

    /**
     * Sets the value of the airborne property.
     * 
     * @param value
     *     allowed object is
     *     {@link Airborne }
     *     
     */
    public void setAirborne(Airborne value) {
        this.airborne = value;
    }

    /**
     * Gets the value of the facility property.
     * 
     * @return
     *     possible object is
     *     {@link Facility }
     *     
     */
    public Facility getFacility() {
        return facility;
    }

    /**
     * Sets the value of the facility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Facility }
     *     
     */
    public void setFacility(Facility value) {
        this.facility = value;
    }

    /**
     * Gets the value of the instrument property.
     * 
     * @return
     *     possible object is
     *     {@link Instrument }
     *     
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * Sets the value of the instrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instrument }
     *     
     */
    public void setInstrument(Instrument value) {
        this.instrument = value;
    }

    /**
     * Gets the value of the instrumentHost property.
     * 
     * @return
     *     possible object is
     *     {@link InstrumentHost }
     *     
     */
    public InstrumentHost getInstrumentHost() {
        return instrumentHost;
    }

    /**
     * Sets the value of the instrumentHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstrumentHost }
     *     
     */
    public void setInstrumentHost(InstrumentHost value) {
        this.instrumentHost = value;
    }

    /**
     * Gets the value of the investigation property.
     * 
     * @return
     *     possible object is
     *     {@link Investigation }
     *     
     */
    public Investigation getInvestigation() {
        return investigation;
    }

    /**
     * Sets the value of the investigation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Investigation }
     *     
     */
    public void setInvestigation(Investigation value) {
        this.investigation = value;
    }

    /**
     * Gets the value of the node property.
     * 
     * @return
     *     possible object is
     *     {@link Node }
     *     
     */
    public Node getNode() {
        return node;
    }

    /**
     * Sets the value of the node property.
     * 
     * @param value
     *     allowed object is
     *     {@link Node }
     *     
     */
    public void setNode(Node value) {
        this.node = value;
    }

    /**
     * Gets the value of the other property.
     * 
     * @return
     *     possible object is
     *     {@link Other }
     *     
     */
    public Other getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     * @param value
     *     allowed object is
     *     {@link Other }
     *     
     */
    public void setOther(Other value) {
        this.other = value;
    }

    /**
     * Gets the value of the pdsAffiliate property.
     * 
     * @return
     *     possible object is
     *     {@link PDSAffiliate }
     *     
     */
    public PDSAffiliate getPDSAffiliate() {
        return pdsAffiliate;
    }

    /**
     * Sets the value of the pdsAffiliate property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDSAffiliate }
     *     
     */
    public void setPDSAffiliate(PDSAffiliate value) {
        this.pdsAffiliate = value;
    }

    /**
     * Gets the value of the pdsGuest property.
     * 
     * @return
     *     possible object is
     *     {@link PDSGuest }
     *     
     */
    public PDSGuest getPDSGuest() {
        return pdsGuest;
    }

    /**
     * Sets the value of the pdsGuest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDSGuest }
     *     
     */
    public void setPDSGuest(PDSGuest value) {
        this.pdsGuest = value;
    }

    /**
     * Gets the value of the resource property.
     * 
     * @return
     *     possible object is
     *     {@link Resource }
     *     
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     * 
     * @param value
     *     allowed object is
     *     {@link Resource }
     *     
     */
    public void setResource(Resource value) {
        this.resource = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link Target }
     *     
     */
    public Target getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link Target }
     *     
     */
    public void setTarget(Target value) {
        this.target = value;
    }

    /**
     * Gets the value of the telescope property.
     * 
     * @return
     *     possible object is
     *     {@link Telescope }
     *     
     */
    public Telescope getTelescope() {
        return telescope;
    }

    /**
     * Sets the value of the telescope property.
     * 
     * @param value
     *     allowed object is
     *     {@link Telescope }
     *     
     */
    public void setTelescope(Telescope value) {
        this.telescope = value;
    }

}