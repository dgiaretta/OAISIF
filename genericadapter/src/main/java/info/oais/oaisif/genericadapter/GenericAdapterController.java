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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.Schema;
import info.oais.infomodel.implementation.utility.OaisIfConfig;
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
	@Operation(summary = "Get The configuration paratemeters needed to use this instance of the Generic Adapter")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the configuration parameters", 
	    content = { @Content(mediaType = "application/json" 
	      ) }),
	  @ApiResponse(responseCode = "400", description = "Cannot find Generic Adapter", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Generic Adapter not found", 
	    content = @Content) })
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
	@Operation(summary = "Get an AIP from the associated Specific Adapter by its id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the AIP", 
	    content = { @Content(mediaType = "application/json") }),
	  @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "AIP not found", 
	    content = @Content) })
	@RequestMapping(value="/GetAIP", params="doid", produces = "application/json")
	public String getAIPByDOIDByRequestParam( 
			@RequestParam("doid") String doid) {
		Properties appProps = new OaisIfConfig().getProperties("genericadapter.properties");
		  
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
	@Operation(summary = "Get a list of all the AIPs in the associated Specific Adapter")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the list of all AIPs", 
	    content = { @Content(mediaType = "application/json") }),
	  @ApiResponse(responseCode = "400", description = "Could not find the list of AIPs", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Specific Adapter not found", 
	    content = @Content) })
	@RequestMapping(value="/AIPAll", produces = "application/json")
	public String getBySAAll() {
		Properties appProps = new OaisIfConfig().getProperties("genericadapter.properties");

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
	@Operation(summary = "Get the PDI from the AIP with the given id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the PDI", 
	    content = { @Content(mediaType = "application/json") }),
	  @ApiResponse(responseCode = "400", description = "Could not find the PDI in the AIP", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "AIP not found", 
	    content = @Content) })
	@RequestMapping(value="/GetPDI", params="doid", produces = "application/json")
	public String getPDIByDOIDByRequestParam( 
			@RequestParam("doid") String doid) {
		Properties appProps = new OaisIfConfig().getProperties("genericadapter.properties");
		  
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
	@Operation(summary = "Get the Content Information from the AIP with the given id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the Content Information", 
	    content = { @Content(mediaType = "application/json") }),
	  @ApiResponse(responseCode = "400", description = "Could not find the Content INformation in the AIP", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "AIP not found", 
	    content = @Content) })
	@RequestMapping(value="/GetIO", params="doid", produces = "application/json")
	public String getIOByDOIDByRequestParam( 
			@RequestParam("doid") String doid) {
		Properties appProps = new OaisIfConfig().getProperties("genericadapter.properties");
		  
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
//		Properties appProps = new OaisifConfig().getProperties("genericadapter.properties");
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
	
	/**
	 * SWITCHBOARD access
	 */
	@ResponseBody
	@Operation(summary = "Get a list of all the Repositories known from the associated SwitchBoard")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the list of all known repositories", 
	    content = { @Content(mediaType = "application/json") }),
	  @ApiResponse(responseCode = "400", description = "Could not find the list of respositories", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "SwitchBoard not found", 
	    content = @Content) })
	@RequestMapping(value="/GetSwitchboardAll", produces = "application/json")
	public String getBySwitchboardAll() {
		System.out.println("/GetSwitchboardAll  being used ");
		return new OaisIfConfig().getJsonString("genericadapter.properties", "SWITCHBOARD", "/api/SB/ArchiveNameAll" );
//		Properties appProps = new OaisifConfig().getProperties("genericadapter.properties");
//
//		String switchboardUrl = appProps.getProperty("SWITCHBOARD");
//
//	    System.out.println("Switchboard is:" + switchboardUrl);
//		HttpHeaders headers = new HttpHeaders();
//	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	    HttpEntity <String> entity = new HttpEntity<String>(headers);
//	    RestTemplate restTemplate = new RestTemplate();   
//
//	    String aips = restTemplate.exchange(switchboardUrl+"/api/SB/ArchiveNameAll", HttpMethod.GET, entity, String.class).getBody();
//	    return aips;
	}
	
//	public String getJsonString(String propFile, String propKey, String qString)  {
//		Properties appProps = new OaisifConfig().getProperties(propFile);
//		  
//		String specUrl = appProps.getProperty(propKey);
//
//	    System.out.println(propKey +  " is: " + specUrl);
//		HttpHeaders headers = new HttpHeaders();
//	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	    HttpEntity <String> entity = new HttpEntity<String>(headers);
//	    RestTemplate restTemplate = new RestTemplate();   
//
//	    String jsonString = restTemplate.exchange(specUrl +qString, HttpMethod.GET, entity, String.class).getBody();
//	    return jsonString;
//	}

}
