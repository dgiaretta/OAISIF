package info.oais.oaisif.rrori;

// import javax.swing.JTable;
import java.io.Serializable;

import info.oais.infomodel.implementation.IdentifierRefImpl;
import info.oais.infomodel.interfaces.Identifier;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import jakarta.persistence.Id;
import lombok.*;
	
	@Getter @Setter

	@Entity
	@Table(name = "oaisif-rrori")
	public class RroriEntry implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		
		@Id
	    //@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		/**
		 * Name or description of the Data Object
		 * 
		 */
		private String doName;
		
		/**
		 * Identifier for the Data Object - here as a STring which has bothe IDName and IdTypd
		 */
		
		private String doid;
		
		/**
		 * Identifier for the Data Object of the associated RepInfo
		 */
		private String ridoid;
		
		/**
		 * Text describing the role of the RepInfo
		 */
		private String rirole;
		
	
		public RroriEntry() {
			super();
		}
		/**
		 * Get the Identifier of the entry
		 * 
		 * @return the Identifier for the entry
		 */
		public long getId() {
			return id;
		}

		/**
		 * Set the Identifier of the entry
		 * 
		 * @param id The Identifier for the entry
		 */
		public void setId(long id) {
			this.id = id;
		}

		/**
		 * Get the name of the Data Object to which this entry refers
		 * 
		 * @return The name of the Data Object to which this entry refers
		 */
		public String getDoName() {
			return doName;
		}

		/**
		 * Set the name of the Data Object to which this entry refers
		 * 
		 * @param doName The name of the Data Object to which this entry refers
		 */
		public void setDoName(String doName) {
			this.doName = doName;
		}

		/**
		 * Get the Identifier of the Data Object to which this entry refers
		 * 
		 * @return The String for the Identifier of the Data Object to which this entry refers
		 */
		public String getDoid() {
			return doid;
		}

		/**
		 * Set the Identifier of the Data Object to which this entry refers
		 * 
		 * @param doid The String for the Identifier of the Data Object to which this entry refers
		 */
		public void setDoid(String doid) {
			this.doid = doid;
		}

		/**
		 * Get the String for the Identifier of the Data Object of the Representation Information
		 * 
		 * @return The String for the Identifier of the Data Object of the Representation Information
		 */
		public String getRidoid() {
			return ridoid;
		}

		/**
		 * Set the String for the Identifier of the Data Object of the Representation Information
		 * 
		 * @param ridoid  The String for the Identifier of the Data Object of the Representation Information
		 */
		public void setRidoid(String ridoid) {
			this.ridoid = ridoid;
		}

		/**
		 * Get the role of the Representation Information e.g. Structure, Semantics, Other, ANdGroup or OrGroup
		 * 
		 * @return The role of the Representation Information e.g. Structure, Semantics, Other, ANdGroup or OrGroup
		 */
		public String getRirole() {
			return rirole;
		}

		/**
		 * Set the role of the Representation Information e.g. Structure, Semantics, Other, ANdGroup or OrGroup
		 * 
		 * @param rirole The role of the Representation Information e.g. Structure, Semantics, Other, ANdGroup or OrGroup
		 */
		public void setRirole(String rirole) {
			this.rirole = rirole;
		}

		@Override
		public String toString() {
			return  "Data Object name/description: " + doName + "\n" +
					"Data Object: "+ doid + "\n" +
					"RepInfo: " + ridoid + "\n" +
					"RI role: " + rirole + "\n" ;
		}	
}
