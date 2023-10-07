/**
 * 
 */
package info.oais.infomodel.implementation;

import info.oais.infomodel.interfaces.DataObject;
import info.oais.infomodel.interfaces.OtherRepInfo;
import info.oais.infomodel.interfaces.RepresentationInformation;
import info.oais.infomodel.interfaces.SemanticRepInfo;
import info.oais.infomodel.interfaces.StructureRepInfo;
import info.oais.infomodel.interfaces.representationinformation.RepInfoCategory;

/**
 * @author david
 *
 */
public class RepresentationInformationRefImpl extends InformationObjectRefImpl implements RepresentationInformation {
	RepInfoCategory m_repCat = null;
	public OtherRepInfo m_OtherRepInfo;
	public SemanticRepInfo m_SemanticRepInfo;
	public StructureRepInfo m_StructureRepInfo;
	
	/**
	 * Create RepInfo
	 */
	public RepresentationInformationRefImpl() {
		super();
		//m_repCat = new RepInfoCategoryRefImpl();
	}
	/**
	 * Create RepInfo with specific Data and RepInfo objects
	 *
	 * @param dat Data Object for this Information Object
	 * @param ri  The Data Object of the Representation Information for this Information Object  
	 */	
	public RepresentationInformationRefImpl(DataObject digiObj, RepresentationInformation repInf) {
		super(digiObj, repInf);
		//m_repCat = new RepInfoCategoryRefImpl();
	}

	//@JsonGetter("RICategory")
	public RepInfoCategory getCategory() {
		return m_repCat;
	}

	//@JsonSetter("RICategory")
	public void setCategory(RepInfoCategory cat) {
		m_repCat = cat;

	}
	@Override
	public SemanticRepInfo getSemanticRepInfo() {
		
		return m_SemanticRepInfo;
	}
	@Override
	public StructureRepInfo getStructureRepInfo() {
		
		return m_StructureRepInfo;
	}
	@Override
	public OtherRepInfo getOtherRepInfo() {
		
		return m_OtherRepInfo;
	}
	@Override
	public void putSemanticRepInfo(SemanticRepInfo semRI) {
		m_SemanticRepInfo = semRI;
		
	}
	@Override
	public void putStructureRepInfo(StructureRepInfo strRI) {
		m_StructureRepInfo = strRI;
		
	}
	@Override
	public void putOtherRepInfo(OtherRepInfo otherRI) {
		m_OtherRepInfo = otherRI;
		
	}

}
