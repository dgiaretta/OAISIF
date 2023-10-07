package info.oais.oaisif.rrori;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RroriRepository extends CrudRepository<RroriEntry, Long> {
	/**
	 * Get all the RepInfo entries in this RRORI which are associated with an DO Identifier
	 * 
	 * @param doid The Identifier for the Data Object
	 * @return A list of entries of RepInfo
	 */
	List<RroriEntry> findByDoid(String doid);
	/**
	 * Get all the RepInfo entries in this RRORI which are associated with an DO Name
	 * 
	 * @param doName The name for the Data Object
	 * @return A list of entries of RepInfo
	 */
	List<RroriEntry> findByDoName(String doName);
	/**
	 * Get all the RepInfo entries in this RRORI which are associated with an RepInfo Identifier
	 * 
	 * @param ridoid The Identifier for the data object of the RepInfo
	 * @return A list of entries of RepInfo
	 */
	List<RroriEntry> findByRidoid(String ridoid);
}
