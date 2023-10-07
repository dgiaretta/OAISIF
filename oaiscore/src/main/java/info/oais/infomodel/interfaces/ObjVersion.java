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
	 * Compare one with another
	 * 
	 * @param o the version to be compared.
	 * 
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 */
	public int compareTo(ObjVersion o);
	
	

}
