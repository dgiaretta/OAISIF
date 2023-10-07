package info.oais.oaisif.switchBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import info.oais.oaisif.rrori.RroriEntry;

@Controller
public class SwitchBoardController {

	@Autowired
	private SwitchBoardRepository switchBoardRepository;
	
	/**
	 * baseuri/ArchiveName?name=xxx
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/ArchiveName", params="name", produces = "application/json")
	public List<SwitchBoardEntry> getByArchiveNameByRequestParam( 
			@RequestParam("name") String name) {
		System.out.println("controller switchBoardRepository is:" + switchBoardRepository);
		List<SwitchBoardEntry> ar = switchBoardRepository.findByArchiveName(name);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ name + " is NULL");
		}
		return ar;	
	}
	@ResponseBody
	@RequestMapping(value="/ArchiveNameLike", params="name", produces = "application/json")
	public List<SwitchBoardEntry> getByArchiveNameLikeByRequestParam( 
			@RequestParam("name") String name) {
		System.out.println("controller switchBoardRepository LIKE is:" + switchBoardRepository);
		//List<SwitchBoardEntry> ar = switchBoardRepository.findByArchiveNameLike(name);
		List<SwitchBoardEntry> ar = switchBoardRepository.findByArchiveNameLike(name);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ name + " is NULL");
		}
		return ar;	
	}
	
	@ResponseBody
	@RequestMapping(value="/ArchiveNameAll", produces = "application/json")
	public List<SwitchBoardEntry> getBySBEAll() {
		//System.out.println("controller rroriRepository is:" + rroriRepository);
		List<SwitchBoardEntry> ar = (List<SwitchBoardEntry>) switchBoardRepository.findAll();
		if ( ar != null) {
			System.out.println("All Entries are: " + ar);
		} else {
			System.out.println("All Entries is NULL");
		}
		return ar;	
	}
	
}
