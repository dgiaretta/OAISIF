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
 * The Array 1D class is the parent class for all
 *         one dimensional array based classes.
 * 
 * <p>Java class for Array_1D complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="Array_1D">
 *   <complexContent>
 *     <restriction base="{http://pds.nasa.gov/pds4/pds/v1}Array">
 *       <sequence>
 *         <element name="name" type="{http://pds.nasa.gov/pds4/pds/v1}name" minOccurs="0"/>
 *         <element name="local_identifier" type="{http://pds.nasa.gov/pds4/pds/v1}local_identifier" minOccurs="0"/>
 *         <element name="md5_checksum" type="{http://pds.nasa.gov/pds4/pds/v1}md5_checksum" minOccurs="0"/>
 *         <element name="offset" type="{http://pds.nasa.gov/pds4/pds/v1}offset"/>
 *         <element name="axes" type="{http://pds.nasa.gov/pds4/pds/v1}axes"/>
 *         <element name="axis_index_order" type="{http://pds.nasa.gov/pds4/pds/v1}axis_index_order"/>
 *         <element name="description" type="{http://pds.nasa.gov/pds4/pds/v1}description" minOccurs="0"/>
 *         <element name="Element_Array" type="{http://pds.nasa.gov/pds4/pds/v1}Element_Array"/>
 *         <element name="Axis_Array" type="{http://pds.nasa.gov/pds4/pds/v1}Axis_Array"/>
 *         <element name="Special_Constants" type="{http://pds.nasa.gov/pds4/pds/v1}Special_Constants" minOccurs="0"/>
 *         <element name="Object_Statistics" type="{http://pds.nasa.gov/pds4/pds/v1}Object_Statistics" minOccurs="0"/>
 *         <element ref="{http://pds.nasa.gov/pds4/pds/v1}Local_Internal_Reference" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Array_1D")
public class Array1D
    extends Array
{


}
