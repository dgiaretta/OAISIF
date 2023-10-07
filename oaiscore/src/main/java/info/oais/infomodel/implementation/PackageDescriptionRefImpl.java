/**
 * 
 */
package info.oais.infomodel.implementation;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import info.oais.infomodel.interfaces.DataObject;
import info.oais.infomodel.interfaces.Identifier;
import info.oais.infomodel.interfaces.PackageDescription;
import info.oais.infomodel.interfaces.RepresentationInformation;

/**
 * @author david
 *
 */
public class PackageDescriptionRefImpl extends InformationObjectRefImpl implements PackageDescription {
	
	public PackageDescriptionRefImpl(String pdStr) {
		super();
		this.setDataObject(new DataObjectRefImpl((Object)pdStr));
	}

	public String getString() {
		return getDataObject().toString();
	}

	public void setString(String desc) {
		this.setDataObject(new DataObjectRefImpl((Object)desc));
	}

}
