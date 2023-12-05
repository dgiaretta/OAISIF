/**
 * 
 */
package info.oais.infomodel.implementation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import info.oais.infomodel.interfaces.AccessRightsInformation;

/**
 * AccessRights Information Object
 * @author david
 *
 */
public class AccessRightsInformationRefImpl extends InformationObjectRefImpl implements AccessRightsInformation {

	/**
	 * Constructor for Access Rights Information as an Information Object
	 * 
	 * This implementation adds a method to get a String which encodes the Access Rights
	 */
	public AccessRightsInformationRefImpl() {
		super();
	}
	/**
	 * Set the String value for the Access Rights Information.
	 * 
	 * @param ariStr String for the Access Rights Information.
	 * 
	 */
	public AccessRightsInformationRefImpl(String ariStr) {
		super();
		this.setDataObject(new DataObjectRefImpl((Object)ariStr));
	}

	/**
	 * Get the String value for the Access Rights Information.
	 * 
	 * @return String for the Access Rights Information.
	 * 
	 */	
	@JsonIgnore
	public String getString() {
		return getDataObject().toString();
	}

	/**
	 * Set the String value for the Access Rights Information.
	 * 
	 * @param desc String for the Access Rights Information.
	 * 
	 */
	public void setString(String desc) {
		this.setDataObject(new DataObjectRefImpl((Object)desc));
		
	}

}
