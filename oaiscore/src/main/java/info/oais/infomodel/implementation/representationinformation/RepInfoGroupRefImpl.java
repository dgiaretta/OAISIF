package info.oais.infomodel.implementation.representationinformation;

import java.util.ArrayList;

import info.oais.infomodel.implementation.RepresentationInformationRefImpl;
import info.oais.infomodel.interfaces.RepresentationInformation;
import info.oais.infomodel.interfaces.representationinformation.RepInfoGroup;

/**
 * RepresentationInformation as a Group, each of which may have a category e.g. Structure, Semantic or Other.<br/>
 * Each element is RepresentationInformation which may itself be a Group.
 * 
 * Groups may be tagged as a RepInfoAndGroup or a RepInfoOrGroup by implementing the approriate interface. If neither
 * is  implemented then the default is that it is a RepInfoAndGroup. 
 * 
 * @author David
 *
 */

public class RepInfoGroupRefImpl extends RepresentationInformationRefImpl implements RepInfoGroup {

	/**
	 * For array of objects
	 */
	private ArrayList<RepresentationInformation> group = null;
	
	/** 
	 * Get the InfoGroup for the vertex. 
	 * 
	 * @return The array of Info in the Group
	 */
	public ArrayList<RepresentationInformation> getGroup(){
		return this.group;
	}
	
	/**
	 * Set the members of Info in this group. 
	 * 
	 * @param group An ArrayList of RepInfo
	 */
	public void setGroup(ArrayList<RepresentationInformation> group) {
		this.group = group;
	}

}
