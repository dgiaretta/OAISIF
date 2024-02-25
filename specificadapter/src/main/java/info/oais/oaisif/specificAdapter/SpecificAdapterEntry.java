package info.oais.oaisif.specificAdapter;

// import javax.swing.JTable;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import jakarta.persistence.Id;
import lombok.*;
	
	@Getter @Setter

	@Entity
	@Table(name = "oaisif-specificadapter")
	public class SpecificAdapterEntry implements Serializable {
		/**
		 * 
		 */
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO);
		//@GeneratedValue(strategy = GenerationType.AUTO)
		
		private Long id;
		

		private String idStr;
		
		private static final long serialVersionUID = 1L;
		
		/**
		 * Set the max length of the JSON String
		 */
		@Column(length=4096)
		private String jsonString=null;
//		/**
//		 * AIP ID   xxx,yyy
//		 */
//		public String aipDoid 	= null;
//		/**
//		 * Is Complete? T/F
//		 */
//		public String isComplete 			= null;
//		/**
//		 * PDI ID   xxx,yyy
//		 */
//		public String pdiDoid	= null;
//		/**
//		 * Info Object ID
//		 */
//		public String ioDoid 			= null;
//		
		public SpecificAdapterEntry() {
			super();
	    }
		public SpecificAdapterEntry(String js) {
			//super();
			jsonString = js;
			id = System.currentTimeMillis();   
			idStr = id.toString();
	    }
		public SpecificAdapterEntry(Long id, String js) {
			//super();
			jsonString = js;
			this.id = id; 
			idStr = id.toString();
	    }
//		
		/**
		 * Get the Identifier for the entry
		 * 
		 * @return Identifier for the SwitchBoard entry
		 */
		public long getId() {
			return id;
		}
		

		/**
		 * Set the Identifier for the entry
		 * 
		 * @param id Identifier for the SA entry
		 */
		public void setId(long id) {
			this.id = id;
			this.idStr = Long.toString(this.id);
		}
		
		/**
		 * Set the jsonString for the entry
		 * 
		 * @param js The String for the AIP
		 */
		public void setJsonString(String js) {
			jsonString = js;
		}
		/**
		 * Get the jsonString for the entry
		 * 
		 * @return The String for the AIP entry
		 */
		public String getJsonString() {
			return jsonString;
		}
//
//		/**
//		 * Get the Archive Name in this SA entry
//		 * 
//		 * @return archiveName - the name of the archive in this SwitchBoard entry
//		 */
//		public String getIsComplete() {
//			return isComplete;
//		}
//		
//		/**
//		 * Set the AIP DOID
//		 * 
//		 * @param doid - of the AIP
//		 */
//		public void setAipDoid(String aipDoid) {
//			this.aipDoid = aipDoid;
//		}
//		/**
//		 * Get the DOID of the AIP
//		 * 
//		 * @return The DOID of the AIP
//		 */
//		public String getAipDoid() {
//			return aipDoid;
//		}
//		/**
//		 * Set the Archive Name in this SwitchBoard entry
//		 * 
//		 * @param isComplete - Is the AIP complete
//		 */
//		public void setIsComplete(String isComplete) {
//			this.isComplete = isComplete;
//		}
//
//		/**
//		 * Get the description of the archive
//		 * 
//		 * @return The description of the archive
//		 */
//		public String getPdiDoid() {
//			return pdiDoid;
//		}
//
//		/**
//		 * Set the description of the archive
//		 * 
//		 * @param pDi - the ID of the PDI
//		 */
//		public void setPdiDoid(String pDi) {
//			this.pdiDoid = pDi;
//		}
//
//		/**
//		 * Get the URL for the archive
//		 * 
//		 * @return The String for the URL to use to access the archive
//		 */	
//		public String getIoDoid() {
//			return ioDoid;
//		}
//
//		/**
//		 * Set the URL for the archive
//		 * 
//		 * @param infoObject ID of the infoObject
//		 */	
//		public void setIoDoid(String infoObject) {
//			this.ioDoid = infoObject;
//		}
//
//
//
		
		@Override
		public String toString() {
			return  "Id:" + id + "    AIP : " + jsonString ;
		}
		/**
		 * @return the m_idStr
		 */
		public String getIdStr() {
			return idStr;
		}
		/**
		 * @param mIdStr the mIdStr to set
		 */
		public void setIdStr(String idStr) {
			this.idStr = idStr;
			id = Long.valueOf(idStr);
		}	
}
