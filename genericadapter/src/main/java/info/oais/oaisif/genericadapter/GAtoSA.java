/**
 * 
 */
package info.oais.oaisif.genericadapter;

/**
 * Abstract Factory patter to create the communication methods between the Generic Adapter (GA)
 * and the associated Specific Adapter (SA)
 */
public abstract class GAtoSA {
	/**
	 * The Communications type to use.
	 */
	CommType commType;
	
	/**
	 * Set the 
	 * @param ctype The type of communications to use
	 */
	GAtoSA(CommType ctype){
		commType = ctype;
	}
	
	public GAtoSA() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create the factory
	 */
	abstract void create();

}
