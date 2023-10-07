/**
 * 
 */
package info.oais.infomodel.implementation;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import info.oais.infomodel.interfaces.Identifier;
import info.oais.infomodel.interfaces.InformationObject;
import info.oais.infomodel.interfaces.ReferenceInformation;

/**
 * @author david
 *
 */
public class ReferenceInformationRefImpl extends InformationObjectRefImpl implements ReferenceInformation {

	InformationObject m_IO = null;

	/**
	 * Constructor for FixityInformation as an Information Object
	 */
	public ReferenceInformationRefImpl() {
		super();
	}

	public String getString() {
		return getDataObject().toString();
	}

	public void setString(String desc) {
		this.setDataObject(new DataObjectRefImpl((Object)desc));
		
	}
}
