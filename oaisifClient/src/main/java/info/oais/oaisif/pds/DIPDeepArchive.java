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
 * The Dissemination Information Package Deep
 *         Archive class is an Information Package derived from one or more
 *         AIPs and is received by the National Space Science Data Center
 *         (NSSDC).
 * 
 * <p>Java class for DIP_Deep_Archive complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="DIP_Deep_Archive">
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
@XmlType(name = "DIP_Deep_Archive")
public class DIPDeepArchive
    extends InformationPackage
{


}