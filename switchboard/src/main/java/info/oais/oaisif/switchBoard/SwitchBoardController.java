package info.oais.oaisif.switchBoard;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/oaisif/v1/switchboard")
public class SwitchBoardController {

	@Autowired
	private SwitchBoardRepository switchBoardRepository;
	
	/**
	 * baseuri/ArchiveName?name=xxx
	 * 
	 */
	@ResponseBody
	@Operation(summary = "Get the details of the named source. In particular one can find the RRORI")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the source", 
	    content = { @Content(mediaType = "application/json" 
	      ) }),
	  @ApiResponse(responseCode = "400", description = "Cannot find switchboard", 
	    content = @Content), 
	  @ApiResponse(responseCode = "401", description = "Unauthorized access", 
	    content = @Content), 
	  @ApiResponse(responseCode = "403", description = "Forbidden request", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "switchboard not found", 
	    content = @Content),
	  @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content) })
	@GetMapping(value="/sources/{name}", produces = "application/json")

	public String getByArchiveNameLikeByRequestParam( 
			@PathVariable(value = "name") String name) {
		System.out.println("controller switchBoardRepository LIKE is:" + name);
		//List<SwitchBoardEntry> ar = switchBoardRepository.findByArchiveNameLike(name);
		List<SwitchBoardEntry> ar = switchBoardRepository.findByArchiveNameLike(name);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ name + " is NULL");
		}
		String ret = "";
		String csvStr = "";
		int count = 0;


		if ( ar != null) {
			Iterator<SwitchBoardEntry> iter = ar.iterator();
			while(iter.hasNext()) {
				SwitchBoardEntry sae = iter.next();
				System.out.println("Entry is " + sae);
				/**
				 * Extract the ID as a String and convert to 
				 * IdentifierTYpe:"Local",Identifier:idStr
				 */
				long idStr = sae.getId();
				String ident = ((Long)idStr).toString();
				
				String sName = sae.getArchiveName();
				String sDescription = sae.getArchiveDescription();
				String sUrl = sae.getArchiveURL();
				/*
				 * Add CRFL to existing row - so that last row does not have it.
				 */
				
				if (csvStr != "") csvStr = csvStr + " ";
				if (count > 0) csvStr = csvStr + ",";
				count ++;
				
				csvStr = csvStr + "{\"IdentifierObject\":{\"IdentifierType\":\"Local\",\"IdentifierString\":\"" + ident + "\"},\"archiveName\":\"" + sName + "\",\"archiveDescription\":\"" + sDescription + "\",\"archiveURL\":\"" + sUrl+"\"}";
				
				System.out.println("CSVSTR:\r\n"+csvStr);
				
			}
			csvStr = csvStr + "]";
			String escapedStr = csvStr.replace("\"", "\\\""); //org.apache.commons.text.StringEscapeUtils.escapeJson(csvStr);
		
			ret = "{\"InformationPackage\":{\"version\":\"1.0\",\"PackageType\":\"General\",";
			ret = ret + "\"PackageDescription\":\"This provides details for the requested source known to the Switchboard repository\",";
			ret = ret + "\"InformationObject\":{\"DataObject\":{\"EncodedObject\":{\"Encoding\":\"JSON:http://www.oais.info/oais-if/json-schema/switchboard.schema.json\",\"EncodedContent\":\""+ escapedStr + "\"}},";
			ret = ret + "\"RepresentationInformation\":{\"IdentifierObject\":{\"IdentifierType\":\"URI\",\"IdentifierString\":\"http://www.oais.info/oais-if/switchboard/RepInfoForSwitchboardfile.json\"}}";
			ret = ret + "}}}";
			
			System.out.println("InfoPackage is: " + ret);
		}
	
		return ret;	
	}
	

	@ResponseBody
	@RequestMapping(value="/sources", produces = "application/json")
	public String getBySBAll() {
		System.out.println("****** /sources  called");
		//System.out.println("controller rroriRepository is:" + rroriRepository);
		List<SwitchBoardEntry> ar = (List<SwitchBoardEntry>) switchBoardRepository.findAll();
		if ( ar != null) {
			System.out.println("All Entries are: " + ar);
		} else {
			System.out.println("All Entries is NULL");
		}
		
		String csvStr = "[";   //"\"columns\": [ \"id\",\"sourceName\",\"sourceDescription\",\"sourceURL\"],\"rows\": [";
		String ret = "";
		int count = 0;


		if ( ar != null) {
			Iterator<SwitchBoardEntry> iter = ar.iterator();
			while(iter.hasNext()) {
				SwitchBoardEntry sae = iter.next();
				System.out.println("Entry is " + sae);
				/**
				 * Extract the ID as a String and convert to 
				 * IdentifierTYpe:"Local",Identifier:idStr
				 */
				long idStr = sae.getId();
				String ident = ((Long)idStr).toString();
				
				String sName = sae.getArchiveName();
				String sDescription = sae.getArchiveDescription();
				String sUrl = sae.getArchiveURL();
				/*
				 * Add CRFL to existing row - so that last row does not have it.
				 */
				
				if (csvStr != "") csvStr = csvStr + " ";
				if (count > 0) csvStr = csvStr + ",";
				count ++;
				//String ident = "\"IdentifierType\":\"Local\",\"Identifier\":\"" + idStr + "\"";
				csvStr = csvStr + "{\"IdentifierObject\":{\"IdentifierType\":\"Local\",\"IdentifierString\":\"" + ident + "\"},\"archiveName\":\"" + sName + "\",\"archiveDescription\":\"" + sDescription + "\",\"archiveURL\":\"" + sUrl+"\"}";
				
				System.out.println("CSVSTR:\r\n"+csvStr);
				
			}
			csvStr = csvStr + "]";
			String escapedStr = csvStr.replace("\"", "\\\""); //org.apache.commons.text.StringEscapeUtils.escapeJson(csvStr);
		
			ret = "{\"InformationPackage\":{\"version\":\"1.0\",\"PackageType\":\"General\",";
			ret = ret + "\"PackageDescription\":\"This is a list of sources known to the Switchboard repository\",";
			ret = ret + "\"InformationObject\":{\"DataObject\":{\"EncodedObject\":{\"Encoding\":\"JSON:http://www.oais.info/oais-if/json-schema/switchboard.schema.json\",\"EncodedContent\":\""+ escapedStr + "\"}},";
			ret = ret + "\"RepresentationInformation\":{\"IdentifierObject\":{\"IdentifierType\":\"URI\",\"IdentifierString\":\"http://www.oais.info/oais-if/switchboard/RepInfoForSwitchboardfile.json\"}}";
			ret = ret + "}}}";
			
			System.out.println("InfoPackage is: " + ret);
		}
	
		return ret;	
	}
	
}