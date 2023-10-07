package info.oais.oaisif.specificAdapter;

// import javax.swing.JTable;
import java.io.Serializable;

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
		private long id;
		
		private static final long serialVersionUID = 1L;
		/**
		 * AIP ID   xxx,yyy
		 */
		public String aipDoid 	= null;
		/**
		 * Is Complete? T/F
		 */
		public String isComplete 			= null;
		/**
		 * PDI ID   xxx,yyy
		 */
		public String pDi 	= null;
		/**
		 * Info Object ID
		 */
		public String infoObject 			= null;
		
		public SpecificAdapterEntry() {
			super();
		}
		
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
		}

		/**
		 * Get the Archive Name in this SA entry
		 * 
		 * @return archiveName - the name of the archive in this SwitchBoard entry
		 */
		public String getIsComplete() {
			return isComplete;
		}
		
		/**
		 * Set the AIP DOID
		 * 
		 * @param doid - of the AIP
		 */
		public void setAipDoid(String aipDoid) {
			this.aipDoid = aipDoid;
		}
		/**
		 * Get the DOID of the AIP
		 * 
		 * @return The DOID of the AIP
		 */
		public String getAipDoid() {
			return aipDoid;
		}
		/**
		 * Set the Archive Name in this SwitchBoard entry
		 * 
		 * @param isComplete - Is the AIP complete
		 */
		public void setIsComplete(String isComplete) {
			this.isComplete = isComplete;
		}

		/**
		 * Get the description of the archive
		 * 
		 * @return The description of the archive
		 */
		public String getpDi() {
			return pDi;
		}

		/**
		 * Set the description of the archive
		 * 
		 * @param pDi - the ID of the PDI
		 */
		public void setpDi(String pDi) {
			this.pDi = pDi;
		}

		/**
		 * Get the URL for the archive
		 * 
		 * @return The String for the URL to use to access the archive
		 */	
		public String getInfoObject() {
			return infoObject;
		}

		/**
		 * Set the URL for the archive
		 * 
		 * @param infoObject ID of the infoObject
		 */	
		public void setInfoObject(String infoObject) {
			this.infoObject = infoObject;
		}



		@Override
		public String toString() {
			return  "AIP DOID: " + aipDoid + "\n" +
					"IsComplete: "+ isComplete + "\n" +
					"PDI: " + pDi + "\n" +
					"InfoObject: " + infoObject + "\n" ;
		}	
}
