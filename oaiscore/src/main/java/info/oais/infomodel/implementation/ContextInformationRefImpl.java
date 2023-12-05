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

import info.oais.infomodel.interfaces.ContextInformation;
import info.oais.infomodel.interfaces.DataObject;
import info.oais.infomodel.interfaces.Identifier;
import info.oais.infomodel.interfaces.RepresentationInformation;

/**
 * Context Information implementation
 * @author david
 *
 */
public class ContextInformationRefImpl extends InformationObjectRefImpl implements ContextInformation {

	/**
	 * Constructor for the ContextInformation.
	 * 
	 */
	public ContextInformationRefImpl() {
		super();
	}
	/**
	 * Set the String value for the ContextInformation.
	 * 
	 * @param contextStr String for the ContextInformation.
	 */
	public ContextInformationRefImpl(String contextStr) {
		super();
		this.setDataObject(new DataObjectRefImpl((Object)contextStr));
	}

	/**
	 * Get the String value for the ContextInformation.
	 * 
	 * @return String for the ContextInformation.
	 */
	@JsonIgnore
	public String getString() {
		return getDataObject().toString();
	}

	/**
	 * Set the String value for the ContextInformation.
	 * 
	 * @param desc String for the ContextInformation.
	 */
	public void setString(String desc) {
		this.setDataObject(new DataObjectRefImpl((Object)desc));
		
	}

}
