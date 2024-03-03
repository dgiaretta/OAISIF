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
//		public String archiveAuth 			= null;
//		/**
//		 * SERIALISATION (JSON, XML,,,,) including VERSION
//		 */
//		public String archiveSerialisation 	= null;
//		/**
//		 * COMMUNICATION PROTOCOL (REST or MAL or ….)
//		 */
//		public String archiveComms			= null;
//		/**
//		 * QUERY LANGUAGE to use and QUERY PARAMETERS
//		 */
//		public String archiveQL				= null;

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

//		/**
//		 * Get the Authentication method to use for the archive
//		 * 
//		 * @return Authentication method to use for the archive
//		 */	
//		public String getArchiveAuth() {
//			return archiveAuth;
//		}
//
//		/**
//		 * Set the Authentication method to use for the archive
//		 * 
//		 * @param archiveAuth Authentication method to use for the archive
//		 */	
//		public void setArchiveAuth(String archiveAuth) {
//			this.archiveAuth = archiveAuth;
//		}
//
//		/**
//		 * Get the serialisation method to use for the archive e.g. JSON or XML
//		 * 
//		 * @return serialisation method to use for the archive e.g. JSON or XML
//		 */			
//		public String getArchiveSerialisation() {
//			return archiveSerialisation;
//		}
//
//		/**
//		 * Set the serialisation method to use for the archive e.g. JSON or XML
//		 * 
//		 * @param archiveSerialisation The serialisation method to use for the archive e.g. JSON or XML
//		 */		
//		public void setArchiveSerialisation(String archiveSerialisation) {
//			this.archiveSerialisation = archiveSerialisation;
//		}
//
//		/**
//		 * Get the communication method to use for the archive e.g. REST
//		 * 
//		 * @return communication method to use for the archive e.g. REST
//		 */	
//		public String getArchiveComms() {
//			return archiveComms;
//		}
//
//		/**
//		 * Set the communication method to use for the archive e.g. REST
//		 * 
//		 * @param archiveComms Communication method to use for the archive e.g. REST
//		 */	
//		public void setArchiveComms(String archiveComms) {
//			this.archiveComms = archiveComms;
//		}
//
//		/**
//		 * Get the Query Language to use for the archive e.g. SQL
//		 * 
//		 * @return Query Language to use for the archive e.g. SQL
//		 */	
//		public String getArchiveQL() {
//			return archiveQL;
//		}
//
//		/**
//		 * Set the Query Language to use for the archive e.g. SQL
//		 * 
//		 * @param archiveQL Query Language to use for the archive e.g. SQL
//		 */	
//		public void setArchiveQL(String archiveQL) {
//			this.archiveQL = archiveQL;
//		}


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
