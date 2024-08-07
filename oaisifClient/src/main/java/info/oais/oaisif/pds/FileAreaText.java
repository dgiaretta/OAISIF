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
 * The File Area Text class describes a file that
 *         contains a text stream object.
 * 
 * <p>Java class for File_Area_Text complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="File_Area_Text">
 *   <complexContent>
 *     <extension base="{http://pds.nasa.gov/pds4/pds/v1}File_Area">
 *       <sequence>
 *         <element name="File" type="{http://pds.nasa.gov/pds4/pds/v1}File"/>
 *         <element name="Stream_Text" type="{http://pds.nasa.gov/pds4/pds/v1}Stream_Text"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "File_Area_Text", propOrder = {
    "file",
    "streamText"
})
public class FileAreaText
    extends FileArea
{

    @XmlElement(name = "File", required = true)
    protected File file;
    @XmlElement(name = "Stream_Text", required = true)
    protected StreamText streamText;

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
     * Gets the value of the streamText property.
     * 
     * @return
     *     possible object is
     *     {@link StreamText }
     *     
     */
    public StreamText getStreamText() {
        return streamText;
    }

    /**
     * Sets the value of the streamText property.
     * 
     * @param value
     *     allowed object is
     *     {@link StreamText }
     *     
     */
    public void setStreamText(StreamText value) {
        this.streamText = value;
    }

}
