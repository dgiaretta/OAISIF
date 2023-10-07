/**
 * 
 */
package info.oais.infomodel.implementation.pdi;

import info.oais.infomodel.implementation.AccessRightsInformationRefImpl;
import info.oais.infomodel.interfaces.pdi.OaisIfAccessRightsInformation;

/**
 * Access Rights with some convenience methods.
 * 
 */
public class OaisIfAccessRightsInformationRefImpl extends AccessRightsInformationRefImpl implements OaisIfAccessRightsInformation {

	private String m_art = null;
	
	/**
	 * Constructor for OaisIfAccessRightsInformationRefImpl
	 * 
	 * @param ariStr The text string of Access Rights
	 */
	public OaisIfAccessRightsInformationRefImpl(String ariStr) {
		super(ariStr);
		m_art = ariStr;
	}
	

	/**
	 * Get Access Rights Text
	 * 
	 * @return Access rights text
	 */
	public String getAccessRightsText() {
		
		return m_art;
	}

	/**
	 * Set Access Rights Text
	 * 
	 * @param art Access rights text
	 */
	public void setAccessRightsText(String art) {
		m_art = art;

	}

}
