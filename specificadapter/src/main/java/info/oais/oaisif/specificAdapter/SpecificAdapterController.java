package info.oais.oaisif.specificAdapter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import info.oais.oaisif.genericadapter.Config;

//import info.oais.oaisif.rrori.RroriEntry;

@RestController
@RequestMapping("/api/SA")
public class SpecificAdapterController {

	@Autowired
	private SpecificAdapterRepository specificAdapterRepository;
	
	/**
	 * Get an AIP given an identifier
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
	/**
	 * Get a list of all the AIPs
	 * 
	 * baseuri/AIPAll 
	 * 
	 */
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
	/**
	 * baseuri/GetPDI?doid=xxx    where XXX is iii,jjj for the 2 parts of the identifier
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/GetPDI", params="doid", produces = "application/json")
	public List<SpecificAdapterEntry> getPDIByDOIDByRequestParam( 
			@RequestParam("doid") String doid) {
		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByPdiDoid(doid);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ doid + " is NULL");
		}
		return ar;	
	}
	
	/**
	 * Get Information Object given ID
	 * baseuri/GetIO?doid=xxx    where XXX is iii,jjj for the 2 parts of the identifier
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/GetIO", params="doid", produces = "application/json")
	public List<SpecificAdapterEntry> getIOByDOIDByRequestParam( 
			@RequestParam("doid") String doid) {
		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByIoDoid(doid);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ doid + " is NULL");
		}
		return ar;	
	}
	
	/**
	 * Get Data Object by ID
	 * baseuri/GetDO?doid=xxx    where XXX is iii,jjj for the 2 parts of the identifier
	 * 
	 */
//	@ResponseBody
//	@RequestMapping(value="/GetDO", params="doid", produces = "application/json")
//	public List<SpecificAdapterEntry> getDOByDOIDByRequestParam( 
//			@RequestParam("doid") String doid) {
//		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
//		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByDoDoid(doid);
//		if ( ar != null) {
//			System.out.println("Entry requested is: " + ar);
//		} else {
//			System.out.println("Entry request for "+ doid + " is NULL");
//		}
//		return ar;	
//	}
}
