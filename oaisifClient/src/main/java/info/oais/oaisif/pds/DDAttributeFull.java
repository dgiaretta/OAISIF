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
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The DD_Attribute_Full class provides a more
 *         complete definition of an attribute in the data
 *         dictionary.
 * 
 * <p>Java class for DD_Attribute_Full complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="DD_Attribute_Full">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="name" type="{http://pds.nasa.gov/pds4/pds/v1}name"/>
 *         <element name="version_id" type="{http://pds.nasa.gov/pds4/pds/v1}version_id"/>
 *         <element name="class_name" type="{http://pds.nasa.gov/pds4/pds/v1}class_name"/>
 *         <element name="local_identifier" type="{http://pds.nasa.gov/pds4/pds/v1}local_identifier"/>
 *         <element name="steward_id" type="{http://pds.nasa.gov/pds4/pds/v1}steward_id"/>
 *         <element name="type" type="{http://pds.nasa.gov/pds4/pds/v1}type"/>
 *         <element name="namespace_id" type="{http://pds.nasa.gov/pds4/pds/v1}namespace_id"/>
 *         <element name="nillable_flag" type="{http://pds.nasa.gov/pds4/pds/v1}nillable_flag"/>
 *         <element name="submitter_name" type="{http://pds.nasa.gov/pds4/pds/v1}submitter_name"/>
 *         <element name="definition" type="{http://pds.nasa.gov/pds4/pds/v1}definition"/>
 *         <element name="comment" type="{http://pds.nasa.gov/pds4/pds/v1}comment" minOccurs="0"/>
 *         <element name="registered_by" type="{http://pds.nasa.gov/pds4/pds/v1}registered_by"/>
 *         <element name="registration_authority_id" type="{http://pds.nasa.gov/pds4/pds/v1}registration_authority_id"/>
 *         <element name="attribute_concept" type="{http://pds.nasa.gov/pds4/pds/v1}attribute_concept"/>
 *         <element name="Terminological_Entry" type="{http://pds.nasa.gov/pds4/pds/v1}Terminological_Entry" maxOccurs="unbounded"/>
 *         <element name="DD_Value_Domain_Full" type="{http://pds.nasa.gov/pds4/pds/v1}DD_Value_Domain_Full" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DD_Attribute_Full", propOrder = {
    "name",
    "versionId",
    "className",
    "localIdentifier",
    "stewardId",
    "type",
    "namespaceId",
    "nillableFlag",
    "submitterName",
    "definition",
    "comment",
    "registeredBy",
    "registrationAuthorityId",
    "attributeConcept",
    "terminologicalEntry",
    "ddValueDomainFull"
})
public class DDAttributeFull {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String name;
    @XmlElement(name = "version_id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String versionId;
    @XmlElement(name = "class_name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String className;
    @XmlElement(name = "local_identifier", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String localIdentifier;
    @XmlElement(name = "steward_id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String stewardId;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String type;
    @XmlElement(name = "namespace_id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String namespaceId;
    @XmlElement(name = "nillable_flag")
    protected boolean nillableFlag;
    @XmlElement(name = "submitter_name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String submitterName;
    @XmlElement(required = true)
    protected String definition;
    protected String comment;
    @XmlElement(name = "registered_by", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String registeredBy;
    @XmlElement(name = "registration_authority_id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String registrationAuthorityId;
    @XmlElement(name = "attribute_concept", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String attributeConcept;
    @XmlElement(name = "Terminological_Entry", required = true)
    protected List<TerminologicalEntry> terminologicalEntry;
    @XmlElement(name = "DD_Value_Domain_Full")
    protected DDValueDomainFull ddValueDomainFull;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the versionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionId() {
        return versionId;
    }

    /**
     * Sets the value of the versionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionId(String value) {
        this.versionId = value;
    }

    /**
     * Gets the value of the className property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Gets the value of the localIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalIdentifier() {
        return localIdentifier;
    }

    /**
     * Sets the value of the localIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalIdentifier(String value) {
        this.localIdentifier = value;
    }

    /**
     * Gets the value of the stewardId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStewardId() {
        return stewardId;
    }

    /**
     * Sets the value of the stewardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStewardId(String value) {
        this.stewardId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the namespaceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespaceId() {
        return namespaceId;
    }

    /**
     * Sets the value of the namespaceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespaceId(String value) {
        this.namespaceId = value;
    }

    /**
     * Gets the value of the nillableFlag property.
     * 
     */
    public boolean isNillableFlag() {
        return nillableFlag;
    }

    /**
     * Sets the value of the nillableFlag property.
     * 
     */
    public void setNillableFlag(boolean value) {
        this.nillableFlag = value;
    }

    /**
     * Gets the value of the submitterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitterName() {
        return submitterName;
    }

    /**
     * Sets the value of the submitterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitterName(String value) {
        this.submitterName = value;
    }

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefinition(String value) {
        this.definition = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the registeredBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisteredBy() {
        return registeredBy;
    }

    /**
     * Sets the value of the registeredBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisteredBy(String value) {
        this.registeredBy = value;
    }

    /**
     * Gets the value of the registrationAuthorityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationAuthorityId() {
        return registrationAuthorityId;
    }

    /**
     * Sets the value of the registrationAuthorityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationAuthorityId(String value) {
        this.registrationAuthorityId = value;
    }

    /**
     * Gets the value of the attributeConcept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeConcept() {
        return attributeConcept;
    }

    /**
     * Sets the value of the attributeConcept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeConcept(String value) {
        this.attributeConcept = value;
    }

    /**
     * Gets the value of the terminologicalEntry property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the terminologicalEntry property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getTerminologicalEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TerminologicalEntry }
     * </p>
     * 
     * 
     * @return
     *     The value of the terminologicalEntry property.
     */
    public List<TerminologicalEntry> getTerminologicalEntry() {
        if (terminologicalEntry == null) {
            terminologicalEntry = new ArrayList<>();
        }
        return this.terminologicalEntry;
    }

    /**
     * Gets the value of the ddValueDomainFull property.
     * 
     * @return
     *     possible object is
     *     {@link DDValueDomainFull }
     *     
     */
    public DDValueDomainFull getDDValueDomainFull() {
        return ddValueDomainFull;
    }

    /**
     * Sets the value of the ddValueDomainFull property.
     * 
     * @param value
     *     allowed object is
     *     {@link DDValueDomainFull }
     *     
     */
    public void setDDValueDomainFull(DDValueDomainFull value) {
        this.ddValueDomainFull = value;
    }

}