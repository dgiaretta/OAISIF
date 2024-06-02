package info.oais.oaisif.specificAdapter;

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
	public List<SpecificAdapterEntry> getAIPByDOIDByRequestParam( 
			@PathVariable(value = "ipid") String ipid) {
		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByIdStr(ipid);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ ipid + " is NULL");
		}
		return ar;	
	}
//	/**
//	 * Get an AIP with an identifier like the given string
//	 * baseuri/GetAIP?aipid=xxx    where XXX is archive's identifier for the AIP
//	 * 
//	 */
//	@ResponseBody
//	@GetMapping(value="/information-packages-like/{text}", produces = "application/json")
//	public List<SpecificAdapterEntry> getByIPStringLikeByRequestParam( 
//			@PathVariable(value = "text") String text)  {
//		System.out.println("controller specificAdapterRepository text LIKE is:" + specificAdapterRepository);
//		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByJsonStringLike( text);
//		if ( ar != null) {
//			System.out.println("Entry requested is: " + ar);
//		} else {
//			System.out.println("Entry request for "+ text + " is NULL");
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
	@GetMapping(value="/information-packages", produces = "application/json")
	public String getBySAAll() {
		//System.out.println("controller rroriRepository is:" + rroriRepository);
		List<SpecificAdapterEntry> ar = (List<SpecificAdapterEntry>) specificAdapterRepository.findAll();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		String csvStr = "[ \"IdType\",\"Ident\",\"Package Type\",\"Is Declared Complete\",\"Package Description\",\"Size (if known)\"]";
		String ret = "";
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
				String ident = "\"Local\",\"" + idStr + "\"";
				
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
				
				if (csvStr != "") csvStr = csvStr + ",";
				csvStr = csvStr + "[" + ident + "," + typ + "," + "\""+ compStr + "\"" + "," + "\""+pdStr+"\"" + ",\""+ sizStr + "\"]";
				
				System.out.println("CSVSTR:\r\n"+csvStr);
				
			}
			
			//String escCsvStr = csvStr.replace("\"", "\u0022");
			//System.out.println("ESCCSVSTR:\r\n"+escCsvStr);
			
			ret = "{\"InformationPackage\":{\"version\":\"1.0\",\"PackageType\":\"General\",";
			ret = ret + "\"PackageDescription\":\"This is a list of AIPs in the repository\",";
			ret = ret + "\"InformationObject\":{\"DataObject\":["+ csvStr + "],";
			ret = ret + "\"RepresentationInformation\":{\"IdentifierType\":\"URI\",\"Identifier\":\"http://www.oais.info/oais-if/rrori/RepInfoForAIPAllcsvfile.json\"}";
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
	public List<String> getComponentByIDByRequestParam( 
			@PathVariable(value = "ipid") String idStr, @PathVariable(value = "component") String compStr )   {
		int numrows = 0;
		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
		//List<SpecificAdapterEntry> ar = specificAdapterRepository.findByPdiDoid(doid);
		System.out.println("XXXX Entry idStr requested is: " + idStr + ": component is: "+ compStr);
		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByIdStr(idStr);
		List<String> sio = new ArrayList<String>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		if ( ar != null) {
			Iterator<SpecificAdapterEntry> iter = ar.iterator();
			while(iter.hasNext()) {
				SpecificAdapterEntry sae = iter.next();
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
				
				JsonNode comp = null;
				System.out.println("Getting: "+compStr);
				switch (compStr) {
					case "PDI":
						comp =  node.at("/InformationPackage/PDI");
						break;
					case "IO":
						comp =  node.at("/InformationPackage/InformationObject");
						break;
					case "DO":
						comp =  node.at("/InformationPackage/InformationObject/DataObject");
						break;
				}
			    ;
			    System.out.println(compStr + " as node: "+ comp);
				String cStr = comp.toString();
				System.out.println(compStr + " : "+ cStr);

				sio.add(cStr);
				
			}
		
			return sio; 
		} else {
			System.out.println("Entry request for "+ idStr + " is NULL");
		}
		return null;	
	}
	
//	/**
//	 * baseuri/GetPDI?aipid=xxx    where XXX is archive's identifier for the AIP
//	 * 
//	 */
//	@ResponseBody
//	@GetMapping(value="/information-packages/{ipid}/PDI ", produces = "application/json")
//	public List<String> getPDIByIDByRequestParam( 
//			@PathVariable(value = "ipid") String idStr)  {
//		int numrows = 0;
//		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
//		//List<SpecificAdapterEntry> ar = specificAdapterRepository.findByPdiDoid(doid);
//		System.out.println("Entry idStr requested is: " + idStr);
//		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByIdStr(idStr);
//		List<String> sio = new ArrayList<String>();
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode node=null;
//		if ( ar != null) {
//			Iterator<SpecificAdapterEntry> iter = ar.iterator();
//			while(iter.hasNext()) {
//				SpecificAdapterEntry sae = iter.next();
//				System.out.println("Entry: " + numrows + " is " + sae);
//				/**
//				 * Create the AIP tree then extract the PDI
//				 */
//				
//				String aipStr = sae.getJsonString();
//				System.out.println(" JsonString is:"+aipStr);
//				try {
//					node = mapper.readTree(aipStr);
//				} catch (JsonMappingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (JsonProcessingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println(" Node is:"+node);
//			    JsonNode pdi =  node.at("/ArchivalInformationPackage/PDI");
//			    System.out.println("PDI as node: "+ pdi);
//				String pdiStr = pdi.toString();
//				System.out.println("PDI: "+ pdiStr);
//
//				sio.add(pdiStr);
//			}
//		
//			return sio; 
//		} else {
//			System.out.println("Entry request for "+ idStr + " is NULL");
//		}
//		return null;	
//	}
//	
//	/**
//	 * Get Information Object given ID
//	 * baseuri/GetIO?aipid=xxx    where XXX  the identifier
//	 * 
//	 */
//	@ResponseBody
//	@GetMapping(value="/information-packages/{ipid}/IO ", produces = "application/json")
//	public List<String> getIOByIDByRequestParam( 
//			@PathVariable(value = "ipid") String idStr)  {
//		int numrows = 0;
//		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
//		//List<SpecificAdapterEntry> ar = specificAdapterRepository.findByPdiDoid(doid);
//		System.out.println("Entry idStr requested is: " + idStr);
//		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByIdStr(idStr);
//		List<String> sio = new ArrayList<String>();
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode node=null;
//		if ( ar != null) {
//			Iterator<SpecificAdapterEntry> iter = ar.iterator();
//			while(iter.hasNext()) {
//				SpecificAdapterEntry sae = iter.next();
//				System.out.println("Entry: " + numrows + " is " + sae);
//				/**
//				 * Create the AIP tree then extract the PDI
//				 */
//				
//				String aipStr = sae.getJsonString();
//				System.out.println(" JsonString is:"+aipStr);
//				try {
//					node = mapper.readTree(aipStr);
//				} catch (JsonMappingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (JsonProcessingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println(" Node is:"+node);
//			    JsonNode io =  node.at("/ArchivalInformationPackage/InformationObject");
//			    System.out.println("IO as node: "+ io);
//				String ioStr = io.toString();
//				System.out.println("IO: "+ ioStr);
//
//				sio.add(ioStr);
//			}
//		
//			return sio; 
//		} else {
//			System.out.println("Entry request for "+ idStr + " is NULL");
//		}
//		return null;	
//	}
//	
//	/**
//	 * Get Data Object by ID
//	 * baseuri/GetDO?aipid=xxx    where XXX the identifier
//	 * 
//	 */
//	@ResponseBody
//	@GetMapping(value="/information-packages/{ipid}/DO ", produces = "application/json")
//	public List<String> getDOByIDByRequestParam( 
//			@PathVariable(value = "ipid") String idStr)  {
//		int numrows = 0;
//		System.out.println("controller specificAdapterRepository is:" + specificAdapterRepository);
//		//List<SpecificAdapterEntry> ar = specificAdapterRepository.findByPdiDoid(doid);
//		System.out.println("Entry idStr requested is: " + idStr);
//		List<SpecificAdapterEntry> ar = specificAdapterRepository.findByIdStr(idStr);
//		List<String> sio = new ArrayList<String>();
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode node=null;
//		if ( ar != null) {
//			Iterator<SpecificAdapterEntry> iter = ar.iterator();
//			while(iter.hasNext()) {
//				SpecificAdapterEntry sae = iter.next();
//				System.out.println("Entry: " + numrows + " is " + sae);
//				/**
//				 * Create the AIP tree then extract the PDI
//				 */
//				
//				String aipStr = sae.getJsonString();
//				System.out.println(" JsonString is:"+aipStr);
//				try {
//					node = mapper.readTree(aipStr);
//				} catch (JsonMappingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (JsonProcessingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println(" Node is:"+node);
//			    JsonNode dataObj =  node.at("/ArchivalInformationPackage/InformationObject/DataObject");
//			    System.out.println("DO as node: "+ dataObj);
//				String dataObjStr = dataObj.toString();
//				System.out.println("DO: "+ dataObj);
//
//				sio.add(dataObjStr);
//			}
//		
//			return sio; 
//		} else {
//			System.out.println("Entry request for "+ idStr + " is NULL");
//		}
//		return null;	
//	}
}
