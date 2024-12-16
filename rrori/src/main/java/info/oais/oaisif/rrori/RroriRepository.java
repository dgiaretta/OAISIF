package info.oais.oaisif.rrori;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface RroriRepository extends CrudRepository<RroriEntry, Long> {
	//@Query("SELECT u FROM oaisif-switchboard u WHERE u.archiveName = name")
	//List<RroriEntry> findByAipDoid(String name);
	List<RroriEntry> findByIdStrLike(String name);

	//List<RroriEntry> findByPdiDoid(String name);
	List<RroriEntry> findByIdStr(String idStr);

	//List<RroriEntry> findByIoDoid(String name);

	//List<RroriEntry> findByDoDoid(String name);
	
	//String getBySAAll();
}
