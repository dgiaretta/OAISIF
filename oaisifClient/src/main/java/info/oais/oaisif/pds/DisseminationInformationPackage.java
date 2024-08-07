//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package info.oais.oaisif.pds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The Dissemination Information Package (DIP)
 *         class defines an Information Package, derived from one or more
 *         AIPs, that is received by a consumer.
 * 
 * <p>Java class for Dissemination_Information_Package complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Dissemination_Information_Package">
 *   <complexContent>
 *     <restriction base="{http://pds.nasa.gov/pds4/pds/v1}Information_Package">
 *       <sequence>
 *         <element name="description" type="{http://pds.nasa.gov/pds4/pds/v1}description"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dissemination_Information_Package")
public class DisseminationInformationPackage
    extends InformationPackage
{


}
