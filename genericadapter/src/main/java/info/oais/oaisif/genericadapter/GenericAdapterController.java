package info.oais.oaisif.genericadapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import info.oais.oaisif.genericadapter.GenericAdapterRepository;
import info.oais.infomodel.implementation.utility.Config;
import info.oais.oaisif.genericadapter.GenericAdapterEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import info.oais.oaisif.rrori.RroriEntry;

@RestController
@RequestMapping("/api/GA")
public class GenericAdapterController {

	@Autowired
	private GenericAdapterRepository genericAdapterRepository;
	
	/**
	 * baseuri/GetProperty?name=xxx    where XXX is the name of the property
	 * 
	 */
	@ResponseBody
	@GetMapping(value="/GetProperty", params="name", produces = "application/json")
	public List<GenericAdapterEntry> getPropertyByRequestParam( 
			@RequestParam("name") String name) {
		System.out.println("controller genericAdapterRepository is:" + genericAdapterRepository);
		List<GenericAdapterEntry> ar = genericAdapterRepository.findByPropertyName(name);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ name + " is NULL");
		}
		return ar;	
	}
//	@ResponseBody
//	@RequestMapping(value="/AIPLike", params="doid", produces = "application/json")
//	public List<GenericAdapterEntry> getByAIPNameLikeByRequestParam( 
//			@RequestParam("doid") String name) {
//		System.out.println("controller genericAdapterRepository LIKE is:" + genericAdapterRepository);
//		List<GenericAdapterEntry> ar = genericAdapterRepository.findByAIPDoidLike(name);
//		if ( ar != null) {
//			System.out.println("Entry requested is: " + ar);
//		} else {
//			System.out.println("Entry request for "+ name + " is NULL");
//		}
//		return ar;	
//	}
	
	@ResponseBody
	@GetMapping(value="/GetConfig", produces = "application/json")
	public List<GenericAdapterEntry> getAllProperties() {
		//System.out.println("controller rroriRepository is:" + rroriRepository);
		List<GenericAdapterEntry> ar = null;
		ar = genericAdapterRepository.findByPropertyName("MYDESCRIPTION");
		System.out.println(ar);
		
		List<GenericAdapterEntry> atemp = genericAdapterRepository.findByPropertyName("MYAUTHENTCATIONMETHOD");
		ar = Stream.concat(ar.stream(), atemp.stream()).toList();
		System.out.println(ar);
		
		atemp = genericAdapterRepository.findByPropertyName("MYSERIALISATIONMETHOD");
		ar = Stream.concat(ar.stream(), atemp.stream()).toList();
		System.out.println(ar);
		
		atemp = genericAdapterRepository.findByPropertyName("MYCOMMUNICATIONMETHOD");
		ar = Stream.concat(ar.stream(), atemp.stream()).toList();
		System.out.println(ar);
		
		atemp = genericAdapterRepository.findByPropertyName("MYQUERYMETHOD");
		ar = Stream.concat(ar.stream(), atemp.stream()).toList();
		System.out.println(ar);
		
		if ( ar != null) {
			System.out.println("All Entries are: " + ar);
		} else {
			System.out.println("All Entries is NULL");
		}
		return ar;	
	}
	/**
	 * baseuri/GetAIP?doid=xxx    where XXX is iii,jjj for the 2 parts of the identifier
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/GetAIP", params="doid", produces = "application/json")
	public String getAIPByDOIDByRequestParam( 
			@RequestParam("doid") String doid) {
		Properties appProps = new Config().getProperties("genericadapter.properties");
		  
		String specificAdapterUrl = appProps.getProperty("SPECIFICADAPTER");

	    System.out.println("SpecificAdapter is:" + specificAdapterUrl);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    RestTemplate restTemplate = new RestTemplate();   

	    String aips = restTemplate.exchange(specificAdapterUrl+"/api/SA/GetAIP?doid="+doid, HttpMethod.GET, entity, String.class).getBody();
	    return aips;
	}
	
	@ResponseBody
	@RequestMapping(value="/AIPAll", produces = "application/json")
	public String getBySAAll() {
		Properties appProps = new Config().getProperties("genericadapter.properties");

		String specificAdapterUrl = appProps.getProperty("SPECIFICADAPTER");

	    System.out.println("SpecificAdapter is:" + specificAdapterUrl);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    RestTemplate restTemplate = new RestTemplate();   

	    String aips = restTemplate.exchange(specificAdapterUrl+"/api/SA/AIPAll", HttpMethod.GET, entity, String.class).getBody();
	    return aips;
	}
	
	/**
	 * baseuri/GetPDI?doid=xxx    where XXX is iii,jjj for the 2 parts of the identifier
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/GetPDI", params="doid", produces = "application/json")
	public String getPDIByDOIDByRequestParam( 
			@RequestParam("doid") String doid) {
		Properties appProps = new Config().getProperties("genericadapter.properties");
		  
		String specificAdapterUrl = appProps.getProperty("SPECIFICADAPTER");

	    System.out.println("SpecificAdapter is:" + specificAdapterUrl);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    RestTemplate restTemplate = new RestTemplate();   

	    String pdi = restTemplate.exchange(specificAdapterUrl+"/api/SA/GetPDI?doid="+doid, HttpMethod.GET, entity, String.class).getBody();
	    return pdi;
	}
	
	/**
	 * Get Information Object
	 * baseuri/GetIO?doid=xxx    where XXX is iii,jjj for the 2 parts of the identifier
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/GetIO", params="doid", produces = "application/json")
	public String getIOByDOIDByRequestParam( 
			@RequestParam("doid") String doid) {
		Properties appProps = new Config().getProperties("genericadapter.properties");
		  
		String specificAdapterUrl = appProps.getProperty("SPECIFICADAPTER");

	    System.out.println("SpecificAdapter is:" + specificAdapterUrl);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    RestTemplate restTemplate = new RestTemplate();   

	    String aips = restTemplate.exchange(specificAdapterUrl+"/api/SA/GetIO?doid="+doid, HttpMethod.GET, entity, String.class).getBody();
	    return aips;
	}
	
	/**
	 * Get Data Object by ID
	 * baseuri/GetDO?doid=xxx    where XXX is iii,jjj for the 2 parts of the identifier
	 * 
	 */
//	@ResponseBody
//	@RequestMapping(value="/GetDO", params="doid", produces = "application/json")
//	public String getDOByDOIDByRequestParam( 
//			@RequestParam("doid") String doid) {
//		Properties appProps = new Config().getProperties("genericadapter.properties");
//		  
//		String specificAdapterUrl = appProps.getProperty("SPECIFICADAPTER");
//
//	    System.out.println("SpecificAdapter is:" + specificAdapterUrl);
//		HttpHeaders headers = new HttpHeaders();
//	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	    HttpEntity <String> entity = new HttpEntity<String>(headers);
//	    RestTemplate restTemplate = new RestTemplate();   
//
//	    String aips = restTemplate.exchange(specificAdapterUrl+"/GetDO?doid="+doid, HttpMethod.GET, entity, String.class).getBody();
//	    return aips;
//	}
}
