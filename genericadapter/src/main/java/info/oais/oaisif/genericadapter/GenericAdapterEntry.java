package info.oais.oaisif.genericadapter;

// import javax.swing.JTable;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Table;
//
//import jakarta.persistence.Id;
import lombok.*;
	
	@Getter @Setter

	@Entity
	@Table(name = "oaisif-genericadapter")
	public class GenericAdapterEntry implements Serializable {
		/**
		 * 
		 */
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO);
		//@GeneratedValue(strategy = GenerationType.AUTO)
		public long id;
		
		public static final long serialVersionUID = 2L;
		/**
		 * Property name
		 */
		//@Column
		public String propertyName			= null;
		/**
		 * Property value
		 */
		//@Column
		public String propertyValue		= null;
		
		public GenericAdapterEntry() {
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
		 * Get the Property Name in this SA entry
		 * 
		 * @return Property Name 
		 */
		public String getPropertyName() {
			return propertyName;
		}
		
		/**
		 * Set the Property name
		 * 
		 * @param propName - Name of the property
		 */
		public void setPropertyName(String propName) {
			this.propertyName = propName;
		}
		/**
		 * Get the Property Value 
		 * 
		 * @return The Property Value
		 */
		public String getPropertyValue() {
			return propertyValue;
		}
		/**
		 * Set the Property Value 
		 * 
		 * @param propVal - The property value
		 */
		public void setPropertyValue(String propVal) {
			this.propertyValue = propVal;
		}
}
