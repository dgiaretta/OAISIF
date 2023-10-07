package info.oais.oaisif.specificAdapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import info.oais.oaisif.rrori.RroriEntry;

@Controller
public class SpecificAdapterController {

	@Autowired
	private SpecificAdapterRepository specificAdapterRepository;
	
	/**
	 * baseuri/GetAIP?doid=xxx    where XXX is iii,jjj for the 2 parts of the identifier
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/GetAIP", params="doid", produces = "application/json")
	public List<SpecificAdapterEntry> getAIPByDOIDByRequestParam( 
			@RequestParam("doid") String doid) {
		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByAipDoid(doid);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ doid + " is NULL");
		}
		return ar;	
	}
//	@ResponseBody
//	@RequestMapping(value="/AIPLike", params="doid", produces = "application/json")
//	public List<SpecificAdapterEntry> getByAIPNameLikeByRequestParam( 
//			@RequestParam("doid") String name) {
//		System.out.println("controller specificAdapterRepository LIKE is:" + specificAdapterRepository);
//		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByAIPDoidLike(name);
//		if ( ar != null) {
//			System.out.println("Entry requested is: " + ar);
//		} else {
//			System.out.println("Entry request for "+ name + " is NULL");
//		}
//		return ar;	
//	}
	
	@ResponseBody
	@RequestMapping(value="/AIPAll", produces = "application/json")
	public List<SpecificAdapterEntry> getBySAAll() {
		//System.out.println("controller rroriRepository is:" + rroriRepository);
		List<SpecificAdapterEntry> ar = (List<SpecificAdapterEntry>) specificAdapterRepository.findAll();
		if ( ar != null) {
			System.out.println("All Entries are: " + ar);
		} else {
			System.out.println("All Entries is NULL");
		}
		return ar;	
	}
	
}
