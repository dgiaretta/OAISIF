package info.oais.oaisif.rrori;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

@RestController
@RequestMapping("/oaisif/v1/representation-info-repository")
public class RroriController {

	@Autowired
	private RroriRepository rroriRepository;
	
	/**
	 * Get an IP given an identifier
	 * baseuri/oaisif/v1/representation-info-repository/information-packages/XXX  where XXX is archive's identifier for the IP containing
	 * RepInfo
	 * 
	 */
	@ResponseBody
	@GetMapping(value="/information-packages/{ipid}", produces = "application/json")
	public String getAIPByDOIDByRequestParam( 
			@PathVariable(value = "ipid") String ipid) {
		System.out.println("controller rroriRepository is:" + rroriRepository);
		JsonNode node=null;
		ObjectMapper mapper = new ObjectMapper();
		List<RroriEntry> ar = rroriRepository.findByIdStr(ipid);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ ipid + " is NULL");
		}
		try {
			System.out.println("AR:" + ar);
			System.out.println("AR.GET(0):"+ ar.get(0));
			System.out.println("AR.GET(0).GETJSONSTRING():"+ ar.get(0).getJsonString());
			node = mapper.readTree(ar.get(0).getJsonString());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String encJ  = node.toString();
	    //String unencJ = encJ.replace("\\\"", "\"");
	    return encJ;
			
	}
	/**
	 * Get an AIP with an identifier like the given string
	 * baseuri/GetAIP?aipid=xxx    where XXX is archive's identifier for the AIP
	 * 
	 */
	@ResponseBody
	@GetMapping(value="/information-packages-like/{name}", produces = "application/json")
	public List<RroriEntry> getByAIPNameLikeByRequestParam( 
			@PathVariable(value = "name") String name) {
		System.out.println("controller rroriRepository LIKE is:" + rroriRepository);
		List<RroriEntry> ar = rroriRepository.findByIdStrLike(name);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ name + " is NULL");
		}
		return ar;	
	}
	
	/**
	 * Get a list of all the AIPs
	 * 
	 * baseuri/AIPAll 
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/information-packages", produces = "application/json")
	public String getByRIAll() {
		//System.out.println("controller rroriRepository is:" + rroriRepository);
		List<RroriEntry> ar = (List<RroriEntry>) rroriRepository.findAll();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		String ret = "";
		int count = 0;
		String csvStr = "["; //"\"columns\": [ \"IdentifierType\",\"IdentifierString\",\"PackageType\",\"IsDeclaredComplete\",\"PackageDescription\",\"Size\"],\"rows\": ";
		if ( ar != null) {
			Iterator<RroriEntry> iter = ar.iterator();
			while(iter.hasNext()) {
				RroriEntry sae = iter.next();
				System.out.println("Entry is " + sae);
				/**
				 * Extract the ID as a String and convert to 
				 * IdentifierTYpe:"Local",Identifier:idStr
				 */
				String idStr = sae.getIdStr();
				String ident = "\"IdentifierObject\":{\"IdentifierType\":\"Local\",\"IdentifierString\":\"" + idStr + "\"}";
				
				/**
				 * Create the AIP tree then extract the PackageDescription
				 */
				
				String aipStr = sae.getJsonString();
				System.out.println(" JsonString is:"+aipStr);
				try {
					node = mapper.readTree(aipStr);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(" Node is:"+node);
				
			    JsonNode pd =  node.at("/InformationPackage/PackageDescription");
			    System.out.println("PackageDescription as node: "+ pd);
				String pdStr = pd.asText();
				System.out.println("PD: "+ pdStr);
				
				JsonNode comp =  node.at("/InformationPackage/IsDeclaredComplete");
			    System.out.println("IsDeclaredComplete as node: "+ comp);
				String compStr = comp.asText();
				System.out.println("compStr: "+ compStr);
				
				JsonNode typ =  node.at("/InformationPackage/PackageType");
			    System.out.println("PackageType as node: "+ typ);
				String typStr = typ.asText();
				System.out.println("typStr: "+ typStr);
				
				JsonNode siz =  node.at("/InformationPackage/InformationObject/DataObject/size");
			    System.out.println("Size as node: "+ siz);
			    String sizStr = "";
			    if (siz.isMissingNode()) {
			    	sizStr = "0";
			    } else {
			    	sizStr = siz.asText();
			    }
				System.out.println("typStr: "+ typStr);
								
				/*
				 * Add CRFL to existing row - so that last row does not have it.
				 */
				
				if (csvStr != "[") csvStr = csvStr + ",";
				csvStr = csvStr + "{" + ident + ",\"PackageType\":" + typ + "," + "\"IsDeclaredComplete\":\"" + compStr + "\"" + ",\"PackageDescription\":\"" + pdStr +"\"" + ",\"size\":\""+ sizStr + "\"}";
				
				System.out.println("CSVSTR:\r\n"+csvStr);
				
			}
			
			csvStr = csvStr + "]";
			String escapedStr = csvStr.replace("\"", "\\\""); 
			
			ret = "{\"InformationPackage\":{\"version\":\"1.0\",\"PackageType\":\"General\",";
			ret = ret + "\"PackageDescription\":\"This is a list of IPs containing Representation Information in this RRORI\",";
			ret = ret + "\"InformationObject\":{\"DataObject\":{\"EncodedObject\":{\"Encoding\":\"JSON:http://www.oais.info/oais-if/json-schema/rrori.schema.json\",\"EncodedContent\":\""+ escapedStr + "\"}},";
			ret = ret + "\"RepresentationInformation\":{\"IdentifierObject\":{\"IdentifierType\":\"URI\",\"IdentifierString\":\"http://www.oais.info/oais-if/rrori/RepInfoForRRORIfile.json\"}}";
			ret = ret + "}}}";
			
			System.out.println("InfoPackage is: " + ret);
		}
	
		return ret;	
	}
	/**
	 * baseuri/GetPDI?aipid=xxx    where XXX is archive's identifier for the AIP
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/information-packages/{ipid}/{component}", produces = "application/json")
	public List<String> getPDIByIDByRequestParam( 
			@PathVariable(value = "ipid") String idStr, @PathVariable(value = "component") String compStr) {
		int numrows = 0;
		System.out.println("controller rroriRepository is:" + rroriRepository);
		//List<RroriEntry> ar = rroriRepository.findByPdiDoid(doid);
		System.out.println("Entry idStr requested is: " + idStr);
		List<RroriEntry> ar = rroriRepository.findByIdStr(idStr);
		List<String> sio = new ArrayList<String>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		if ( ar != null) {
			Iterator<RroriEntry> iter = ar.iterator();
			while(iter.hasNext()) {
				RroriEntry sae = iter.next();
				System.out.println("Entry: " + numrows + " is " + sae);
				/**
				 * Create the AIP tree then extract the PDI
				 */
				
				String aipStr = sae.getJsonString();
				System.out.println(" JsonString is:"+aipStr);
				try {
					node = mapper.readTree(aipStr);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" Node is:"+node);
			    JsonNode pdi =  node.at("/ArchivalInformationPackage/PDI");
			    System.out.println("PDI as node: "+ pdi);
				String pdiStr = pdi.toString();
				System.out.println("PDI: "+ pdiStr);

				sio.add(pdiStr);
			}
		
			return sio; 
		} else {
			System.out.println("Entry request for "+ idStr + " is NULL");
		}
		return null;	
	}
	
	/**
	 * Get Information Object given ID
	 * baseuri/GetIO?aipid=xxx    where XXX  the identifier
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/information-packages/{ipid}/IO", produces = "application/json")
	public List<String> getIOByIDByRequestParam( 
			@RequestParam("ipid") String idStr) {
		int numrows = 0;
		System.out.println("controller rroriRepository is:" + rroriRepository);
		//List<RroriEntry> ar = rroriRepository.findByPdiDoid(doid);
		System.out.println("Entry idStr requested is: " + idStr);
		List<RroriEntry> ar = rroriRepository.findByIdStr(idStr);
		List<String> sio = new ArrayList<String>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		if ( ar != null) {
			Iterator<RroriEntry> iter = ar.iterator();
			while(iter.hasNext()) {
				RroriEntry sae = iter.next();
				System.out.println("Entry: " + numrows + " is " + sae);
				/**
				 * Create the AIP tree then extract the PDI
				 */
				
				String aipStr = sae.getJsonString();
				System.out.println(" JsonString is:"+aipStr);
				try {
					node = mapper.readTree(aipStr);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" Node is:"+node);
			    JsonNode io =  node.at("/ArchivalInformationPackage/InformationObject");
			    System.out.println("IO as node: "+ io);
				String ioStr = io.toString();
				System.out.println("IO: "+ ioStr);

				sio.add(ioStr);
			}
		
			return sio; 
		} else {
			System.out.println("Entry request for "+ idStr + " is NULL");
		}
		return null;	
	}
	
	/**
	 * Get Data Object by ID
	 * baseuri/GetDO?aipid=xxx    where XXX the identifier
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/information-packages/{ipid}/DO", produces = "application/json")
	public List<String> getDOByIDByRequestParam( 
			@RequestParam("ipid") String idStr) {
		int numrows = 0;
		System.out.println("controller rroriRepository is:" + rroriRepository);
		//List<RroriEntry> ar = rroriRepository.findByPdiDoid(doid);
		System.out.println("Entry idStr requested is: " + idStr);
		List<RroriEntry> ar = rroriRepository.findByIdStr(idStr);
		List<String> sio = new ArrayList<String>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		if ( ar != null) {
			Iterator<RroriEntry> iter = ar.iterator();
			while(iter.hasNext()) {
				RroriEntry sae = iter.next();
				System.out.println("Entry: " + numrows + " is " + sae);
				/**
				 * Create the AIP tree then extract the PDI
				 */
				
				String aipStr = sae.getJsonString();
				System.out.println(" JsonString is:"+aipStr);
				try {
					node = mapper.readTree(aipStr);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" Node is:"+node);
			    JsonNode dataObj =  node.at("/ArchivalInformationPackage/InformationObject/DataObject");
			    System.out.println("DO as node: "+ dataObj);
				String dataObjStr = dataObj.toString();
				System.out.println("DO: "+ dataObj);

				sio.add(dataObjStr);
			}
		
			return sio; 
		} else {
			System.out.println("Entry request for "+ idStr + " is NULL");
		}
		return null;	
	}
}