package info.oais.oaisif.switchBoard;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SwitchBoardRepository extends CrudRepository<SwitchBoardEntry, Long> {
	//@Query("SELECT u FROM oaisif-switchBoard u WHERE u.archiveName = name")
	List<SwitchBoardEntry> findByArchiveName(String name);
	List<SwitchBoardEntry> findByArchiveNameLike(String name);
	//List<SwitchBoardEntry> getAll();
}
