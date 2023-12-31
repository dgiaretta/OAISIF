/**
 * 
 */
package info.oais.infomodel.interfaces;

/**
 * The version associated with an Object.
 * 
 * One version can be compared to another to decide which is the later
 * 
 */
public interface ObjVersion extends Comparable<ObjVersion> {

	/**
	 * Get ObjVersion as a String
	 * @param ver Version as a String
	 * 
	 */
	void setObjVersionString(String ver);
	
	/**
	 * Set ObjVersion as a String
	 * @returns Version as a String
	 * 
	 */
	String getObjVersionString();
	
	/**
	 * Compare one with another
	 * 
	 * @param o the version to be compared.
	 * 
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 */
	public int compareTo(ObjVersion o);
	
	

}
