/**
 * 
 */
package info.oais.infomodel.implementation;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import info.oais.infomodel.interfaces.DataObject;
import info.oais.infomodel.interfaces.Identifier;
import info.oais.infomodel.interfaces.InformationObject;
import info.oais.infomodel.interfaces.ProvenanceInformation;
import info.oais.infomodel.interfaces.RepresentationInformation;

/**
 * Implementation of ProvenanceInformation interface. 
 * There are additional convenience methods to get/set a Provenance String
 * 
 * @author david
 *
 */
public class ProvenanceInformationRefImpl extends InformationObjectRefImpl implements ProvenanceInformation  {

	InformationObject m_IO = null;

	/**
	 * Constructor for ProvenanceInformation as an Information Object
	 */
	public ProvenanceInformationRefImpl() {
		super();
	}
	/**
	 * Set the Information Object for the FixityInformation.
	 * 
	 * @param io Set the Information Object for the FixityInformation.
	 */
	public ProvenanceInformationRefImpl(InformationObject io) {
		super(io.getDataObject(), io.getRepresentationInformation());
		m_IO = io;
	}

	/**
	 * Set the String value for the ProvenanceInformation.
	 * 
	 * @param fixStr Set the String for the ProvenanceInformation.
	 */
	public ProvenanceInformationRefImpl(String provStr) {
		super();
		this.setDataObject(new DataObjectRefImpl((Object)provStr));
	}
	@JsonIgnore
	public String getString() {
		return getDataObject().toString();
	}

	public void setString(String desc) {
		this.setDataObject(new DataObjectRefImpl((Object)desc));
		
	}
	
}
