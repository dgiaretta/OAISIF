package info.oais.oaisif.genericadapter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//import info.oais.oaisif.genericadapter.GenericAdapterRepository;
//import info.oais.oaisif.genericadapter.GenericAdapterEntry;

//import info.oais.oaisif.rrori.RroriEntry;

@RestController
@PropertySource("classpath:genericadapter.properties")
@RequestMapping("/oaisif/v1/generic-adapter")
public class GenericAdapterController {
	
	@Value("${SPECIFICADAPTER}") 
	private String specificAdapterUrl;
	@Value("${SWITCHBOARD}") 
	private String switchboardUrl;

	@Autowired
	private GenericAdapterRepository genericAdapterRepository;
	
	@Value("{)")
	/**
	 * Get all the properties needed to communicate with the GA
	 * @return All the name/value pairs for the properties
	 */
	@ResponseBody
	@Operation(summary = "Get the configuration parameters needed to use this instance of the Generic Adapter")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the configuration parameters", 
	    content = { @Content(mediaType = "application/json" 
	      ) }),
	  @ApiResponse(responseCode = "400", description = "Cannot find Generic Adapter", 
	    content = @Content), 
	  @ApiResponse(responseCode = "401", description = "Unauthorized access", 
	    content = @Content), 
	  @ApiResponse(responseCode = "403", description = "Forbidden request", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Generic Adapter not found", 
	    content = @Content),
	  @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content) })
	@GetMapping(value="/properties", produces = "application/json")
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
	 * baseuri/GetProperty?name=xxx    where XXX is the name of the property
	 * 
	 * @param name   name of the property wanted
	 * @returns The String value associated with that property
	 * 
	 */
	@ResponseBody
	@Operation(summary = "Get the named parameter for the Generic Adapter")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the named configuration parameters", 
	    content = { @Content(mediaType = "application/json" 
	      ) }),
	  @ApiResponse(responseCode = "400", description = "Cannot find Generic Adapter", 
	    content = @Content), 
	  @ApiResponse(responseCode = "401", description = "Unauthorized access", 
	    content = @Content), 
	  @ApiResponse(responseCode = "403", description = "Forbidden request", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Generic Adapter not found", 
	    content = @Content),
	  @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content) })
	@GetMapping(value="/properties/{name}",  produces = "application/json")
	public List<GenericAdapterEntry> getPropertyByRequestParam( 
			@PathVariable(value = "name") String name) {
		System.out.println("controller genericAdapterRepository is:" + genericAdapterRepository);
		List<GenericAdapterEntry> ar = genericAdapterRepository.findByPropertyName(name);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ name + " is NULL");
		}
		return ar;	
	}
	
	@Hidden
	@PostMapping("/properties/{name}")
//	/**
//	 * 
//	 * @param aipid The Id the archive uses
//	 * @return List of AIPs that match
//	 */
//	@ResponseBody
//	@GetMapping(value="/information-packages-like/{ipid}", produces = "application/json")
//	public List<GenericAdapterEntry> getByIPNameLikeByRequestParam( 
//			@PathVariable(value = "ipid") String ipid) {
//		System.out.println("controller genericAdapterRepository LIKE is:" + genericAdapterRepository);
//		List<GenericAdapterEntry> ar = genericAdapterRepository.findByIdLike(ipid);
//		if ( ar != null) {
//			System.out.println("Entry requested is: " + ar);
//		} else {
//			System.out.println("Entry request for "+ ipid + " is NULL");
//		}
//		return ar;	
//	}
//	
	

	/**
	 * baseuri/information-packages/xxx    where XXX is the identifier
	 * @param ipid The String to identify the IP
	 * @return The JSON for the IP
	 */
	@ResponseBody
	@Operation(summary = "Get an IP from the associated Specific Adapter by its id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the AIP", 
	    content = { @Content(mediaType = "application/json") }),
	  @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "AIP not found", 
	    content = @Content) })
	@GetMapping(value="/information-packages/{ipid}", produces = "application/json")
	public String getAIPByIDByRequestParam( 
			@PathVariable(value = "ipid") String ipid) {
		//Properties appProps = new OaisIfConfig().getProperties("genericadapter.properties");
		  
		//String specificAdapterUrl = appProps.getProperty("SPECIFICADAPTER");

	    System.out.println("XXXXSpecificAdapter is:" + specificAdapterUrl);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    RestTemplate restTemplate = new RestTemplate();   

	    String aips = restTemplate.exchange(specificAdapterUrl+"/oaisif/v1/specific-adapter/information-packages/"+ipid, HttpMethod.GET, entity, String.class).getBody();
	    
	    /**
	     * Extract the AIP - the first element in the array which is returned at node jsonString
	     */
	    ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		try {
			node = mapper.readTree(aips);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" Node is:"+node);
	    JsonNode aip =  (node.get(0)).at("/jsonString");
	    System.out.println("AIP:"+ aip);
	    
	    return aip.asText();
	}
	
	@ResponseBody
	@Operation(summary = "Get a list of all the IPs in the associated Specific Adapter")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the list of all AIPs", 
	    content = { @Content(mediaType = "application/json") }),
	  @ApiResponse(responseCode = "400", description = "Could not find the list of AIPs", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Specific Adapter not found", 
	    content = @Content) })
	@GetMapping(value="/information-packages", produces = "application/json")
	public String getBySAAll() {
		//Properties appProps = new OaisIfConfig().getProperties("genericadapter.properties");

		//String specificAdapterUrl = appProps.getProperty("SPECIFICADAPTER");

	    System.out.println("XXXYYYSpecificAdapter is:" + specificAdapterUrl);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    RestTemplate restTemplate = new RestTemplate();   

	    String aips = restTemplate.exchange(specificAdapterUrl+"/oaisif/v1/specific-adapter/information-packages", HttpMethod.GET, entity, String.class).getBody();
	    return aips;
	}
	
	
	
	
	/**
	 * baseuri/information-packages/{id}/{component}    where {id} is the identifier for the IP
	 * 
	 */
	@ResponseBody
	@Operation(summary = "Get the specified component from the IP with the given id. The component may be IO (InformationObject), DO (DataObject) or PDI")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the ", 
	    content = { @Content(mediaType = "application/json") }),
	  @ApiResponse(responseCode = "400", description = "Could not find the component in the IP", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "IP not found", 
	    content = @Content) })
	@GetMapping(value="/information-packages/{id}/{component}", produces = "application/json")
	public String getComponentByIPIDByRequestParam( 
			@PathVariable(value = "id") String idStr, @PathVariable(value = "component") String compStr )  {
		//String aipStr = getAIPByDOIDByRequestParam( doid);
		//Properties appProps = new OaisIfConfig().getProperties("genericadapter.properties");
		  
		//String specificAdapterUrl = appProps.getProperty("SPECIFICADAPTER");
/**
 * Need to create AIP then get PDI then package that as Info Object in IP
 */
		//ArchivalInformationPackageRefImpl aip = null;
		//aip = new Json2Java().json2Java(aipStr, ArchivalInformationPackageRefImpl.class);
		//PreservationDescriptionInformation pdi = aip.getPDI();
		//DGXXXX
				
	    System.out.println("XXXYYYZZZSpecificAdapter is:" + specificAdapterUrl);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    RestTemplate restTemplate = new RestTemplate();   
//
	    String cStr = restTemplate.exchange(specificAdapterUrl+"/oaisif/v1/specific-adapter/information-packages/"+idStr+"/"+compStr, HttpMethod.GET, entity, String.class).getBody();
	    System.out.println(compStr + " is:"+cStr);
	    //return "{ \"InformationPackage\": {\"version\": \"1.0\", \"PackageType\": \"General\", \"PackageDescription\": \"This is the " + compStr + " of IP " + ipid + "\",  \"InformationObject\": {\"PDI\":" + pdi + "}}}";
	    return cStr;
	}
	
	
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
	@GetMapping(value="/sources", produces = "application/json")
	public String getBySwitchboardAll() {
		System.out.println("/switchboard/sources  being used ");
	    System.out.println("Switchboard is:" + switchboardUrl);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    RestTemplate restTemplate = new RestTemplate();   

	    String aips = restTemplate.exchange(switchboardUrl+"/oaisif/v1/switchboard/sources", HttpMethod.GET, entity, String.class).getBody();
	    return aips;
	}
	
	@ResponseBody
	@Operation(summary = "Get the details of the named source, e.g. RRORI, from the associated SwitchBoard")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the named repository", 
	    content = { @Content(mediaType = "application/json") }),
	  @ApiResponse(responseCode = "400", description = "Could not find the list of respositories", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "SwitchBoard not found", 
	    content = @Content) })
	@GetMapping(value="/sources/{name}", produces = "application/json")
	public String getBySwitchboardName(
			@PathVariable(value = "name") String name) {
		System.out.println("/switchboard/sources/" + name + "  being used ");
	    System.out.println("Switchboard is:" + switchboardUrl);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    RestTemplate restTemplate = new RestTemplate();   

	    String aips = restTemplate.exchange(switchboardUrl+"/oaisif/v1/switchboard/sources/"+name, HttpMethod.GET, entity, String.class).getBody();
	    return aips;
	}
}
