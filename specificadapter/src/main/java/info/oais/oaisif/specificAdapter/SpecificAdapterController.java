package info.oais.oaisif.specificadapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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


@RestController
@RequestMapping("/oaisif/v1/specific-adapter")
public class SpecificAdapterController {

	@Autowired
	private SpecificAdapterRepository specificAdapterRepository;
	
	/**
	 * Get an AIP given an identifier
	 * baseuri/GetAIP?aipid=xxx    where XXX is archive's identifier for the AIP
	 * 
	 */
	@ResponseBody
	@GetMapping(value="/information-packages/{ipid}", produces = "application/json")
	public String getAIPByDOIDByRequestParam( //List<SpecificAdapterEntry> getAIPByDOIDByRequestParam( 
			@PathVariable(value = "ipid") String ipid) {
		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByIdStr(ipid);
		String ret = "";
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
			ret = (ar.get(0).getJsonString()).replace("\\\"", "\"");
		} else {
			System.out.println("Entry request for "+ ipid + " is NULL");
		}
		return ret;	
	}

	
	/**
	 * Get a list of all the AIPs
	 * 
	 * baseuri/AIPAll 
	 * 
	 */
	@ResponseBody
	@GetMapping(value="/information-packages", produces = "application/json")
	public String getBySAAll(@RequestParam(required = false) String query) {
		//System.out.println("controller SARepository is:" + rroriRepository);
		List<SpecificAdapterEntry> ar = (List<SpecificAdapterEntry>) specificAdapterRepository.findAll();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		String csvStr = "["; 
		String ret = "";
		System.out.println("Query is " + query);
		int count = 0;
		if ( ar != null) {
			Iterator<SpecificAdapterEntry> iter = ar.iterator();
			while(iter.hasNext()) {
				SpecificAdapterEntry sae = iter.next();
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
				//
				// If there is a query and the Package Description does not contain the query text then skip this entry 
				if (query != null && !pdStr.contains(query)) continue;
				
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
			ret = ret + "\"PackageDescription\":\"This is a list of IPs in this repository\",";
			ret = ret + "\"InformationObject\":{\"DataObject\":{\"EncodedObject\":{\"Encoding\":\"JSON:http://www.oais.info/oais-if/json-schema/specificadapter.schema.json\",\"EncodedContent\":\""+ escapedStr + "\"}},";
			ret = ret + "\"RepresentationInformation\":{\"IdentifierObject\":{\"IdentifierType\":\"URI\",\"IdentifierString\":\"http://www.oais.info/oais-if/rrori/SpecificAdapterSemantics.txt\"}}";
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
	@GetMapping(value="/information-packages/{ipid}/{component}", produces = "application/json")
	public String getComponentByIDByRequestParam( // List<String> getComponentByIDByRequestParam( 
			@PathVariable(value = "ipid") String idStr, @PathVariable(value = "component") String compStr )   {
		int numrows = 0;
		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
		//List<SpecificAdapterEntry> ar = specificAdapterRepository.findByPdiDoid(doid);
		System.out.println("XXXX Entry idStr requested is: " + idStr + ": component is: "+ compStr);
		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByIdStr(idStr);
		List<String> sio = new ArrayList<String>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		String ipStr = ""; 
		String ipReturn = "";
		String ipUnEscaped = "";
		if ( ar != null) {
			ipStr = ar.get(0).getJsonString();

				System.out.println(" JsonString is:"+ipStr);
				try {
					node = mapper.readTree(ipStr);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" Node is:"+node);
				
				JsonNode comp = null;

				System.out.println("Getting: "+compStr);
				switch (compStr) {
					case "PDI":
						comp =  node.at("/InformationPackage/PDI");
					    ipReturn = "{ \"InformationPackage\": {\"version\": \"1.0\", \"PackageType\": \"General\", \"PackageDescription\": \"This is the " + compStr + " of IP " + idStr + "\",  \"InformationObject\": " + comp.toString() + "}}";
						break;
					case "IO":
						comp =  node.at("/InformationPackage/InformationObject");
					    ipReturn = "{ \"InformationPackage\": {\"version\": \"1.0\", \"PackageType\": \"General\", \"PackageDescription\": \"This is the " + compStr + " of IP " + idStr + "\",  \"InformationObject\": " + comp.toString() + "}}";
						break;
					case "DO":
						comp =  node.at("/InformationPackage/InformationObject/DataObject");
					    ipReturn = "{ \"InformationPackage\": {\"version\": \"1.0\", \"PackageType\": \"General\", \"PackageDescription\": \"This is the " + compStr + " of IP " + idStr + "\",  \"InformationObject\": {\"DataObject\":" + comp.toString() + ",\"RepresentationInformation\":\"None, because only DataObject was requested\"}}}";
						break;
					case "RI":
						comp =  node.at("/InformationPackage/InformationObject/RepresentationInformation");
					    ipReturn = "{ \"InformationPackage\": {\"version\": \"1.0\", \"PackageType\": \"General\", \"PackageDescription\": \"This is the " + compStr + " of IP " + idStr + "\",  \"InformationObject\": " + comp.toString() + "}}";
						break;
				}
			    
				ipUnEscaped = ipReturn.replace("\\\"", "\"");
			    System.out.println(compStr + " as node: "+ ipReturn);
				String cStr = comp.toString();
				
			    System.out.println(compStr + " is:"+cStr);
			    
				System.out.println(compStr + " : "+ cStr);

				sio.add(cStr);
					
			return ipUnEscaped; 
		} else {
			System.out.println("Entry request for "+ idStr + " is NULL");
		}
		return null;	
	}
}
