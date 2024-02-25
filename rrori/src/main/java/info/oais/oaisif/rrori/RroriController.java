package info.oais.oaisif.rrori;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RroriController {

	@Autowired
	private RroriRepository rroriRepository;
	
	/**
	 * Get the RRORI entries for a given DO name, /DOName?name=xxx
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/DOName", params="name", produces = "application/json")
	public List<RroriEntry> getByDoNameByRequestParam( 
			@RequestParam("name") String name) {
		System.out.println("controller rroriRepository is:" + rroriRepository);
		List<RroriEntry> ar = rroriRepository.findByDoName(name);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ name + " is NULL");
		}
		return ar;	
	}
	
	/**
	 * Get the RRORI entries for a given DO identifier, /DOId?identifier=xxx
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/DOId", params="identifier", produces = "application/json")
	public List<RroriEntry> getByDoidByRequestParam( 
			@RequestParam("identifier") String id) {
		//System.out.println("controller rroriRepository is:" + rroriRepository);
		List<RroriEntry> ar = rroriRepository.findByDoid(id);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ id + " is NULL");
		}
		return ar;	
	}
	
	/**
	 * Get the RRORI entries for a given RI Data object Id, /RIDOId?identifier=xxx
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/RIDOId", params="identifier", produces = "application/json")
	public List<RroriEntry> getByRioidByRequestParam( 
			@RequestParam("identifier") String id) {
		//System.out.println("controller rroriRepository is:" + rroriRepository);
		List<RroriEntry> ar = rroriRepository.findByRidoid(id);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ id + " is NULL");
		}
		return ar;	
	}

	/**
	 * Get all the RRORI entries /RIAll
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/RIAll", produces = "application/json")
	public List<RroriEntry> getByRiAll() {
		//System.out.println("controller rroriRepository is:" + rroriRepository);
		List<RroriEntry> ar = (List<RroriEntry>) rroriRepository.findAll();
		if ( ar != null) {
			System.out.println("All Entries are: " + ar);
		} else {
			System.out.println("All Entries is NULL");
		}
		return ar;	
	}
	
}