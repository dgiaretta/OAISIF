package info.oais.oaisif.switchBoard;

// import javax.swing.JTable;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Table;
//
//import jakarta.persistence.Id;
import lombok.*;
	
	@Getter @Setter

	@Entity
	@Table(name = "oaisif-switchBoard")
	public class SwitchBoardEntry implements Serializable {
		/**
		 * 
		 */
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO);
		//@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		private static final long serialVersionUID = 1L;
		/**
		 * NAME of ARCHIVE 
		 */
		public String archiveName 			= null;
		/**
		 * DESCRIPTION OF ARCHIVE
		 */
		public String archiveDescription 	= null;
		/**
		 * URL/PORT
		 */
		public String archiveURL 			= null;
		/**
		 * AUTHENTICATION METHOD FOR COMMS
		 */

		public SwitchBoardEntry() {
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
		 * @param id Identifier for the SwitchBoard entry
		 */
		public void setId(long id) {
			this.id = id;
		}

		/**
		 * Get the Archive Name in this SwitchBoard entry
		 * 
		 * @return archiveName - the name of the archive in this SwitchBoard entry
		 */
		public String getArchiveName() {
			return archiveName;
		}

		/**
		 * Set the Archive Name in this SwitchBoard entry
		 * 
		 * @param archiveName - he name of the archive in this SwitchBoard entry
		 */
		public void setArchiveName(String archiveName) {
			this.archiveName = archiveName;
		}

		/**
		 * Get the description of the archive
		 * 
		 * @return The description of the archive
		 */
		public String getArchiveDescription() {
			return archiveDescription;
		}

		/**
		 * Set the description of the archive
		 * 
		 * @param archiveDescription - the description of the archive
		 */
		public void setArchiveDescription(String archiveDescription) {
			this.archiveDescription = archiveDescription;
		}

		/**
		 * Get the URL for the archive
		 * 
		 * @return The String for the URL to use to access the archive
		 */	
		public String getArchiveURL() {
			return archiveURL;
		}

		/**
		 * Set the URL for the archive
		 * 
		 * @param archiveURL The String for the URL to use to access the archive
		 */	
		public void setArchiveURL(String archiveURL) {
			this.archiveURL = archiveURL;
		}


		@Override
		public String toString() {
			return  "Name: "+ archiveName + "\n" +
					"Description: " + archiveDescription + "\n" +
					"URL and Port: " + archiveURL + "\n";
//					"Authentication: " + archiveAuth + "\n" +
//					"Serialisation: "+ archiveSerialisation + "\n" +
//					"Comms protocol: " + archiveComms + "\n" +
//					"Query language: " + archiveQL + "\n";
		}	
}
