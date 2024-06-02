package info.oais.oaisif.switchBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<SwitchBoardEntry> getByArchiveNameByRequestParam( 
			@PathVariable(value = "name") String name) {
		System.out.println("controller switchBoardRepository is:" + switchBoardRepository);
		List<SwitchBoardEntry> ar = switchBoardRepository.findByArchiveName(name);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ name + " is NULL");
		}
		return ar;	
	}
	@ResponseBody
	@GetMapping(value="/sources-like/{name}", produces = "application/json")
	public List<SwitchBoardEntry> getByArchiveNameLikeByRequestParam( 
			@PathVariable(value = "name") String name) {
		System.out.println("controller switchBoardRepository LIKE is:" + name);
		//List<SwitchBoardEntry> ar = switchBoardRepository.findByArchiveNameLike(name);
		List<SwitchBoardEntry> ar = switchBoardRepository.findByArchiveNameLike(name);
		if ( ar != null) {
			System.out.println("Entry requested is: " + ar);
		} else {
			System.out.println("Entry request for "+ name + " is NULL");
		}
		return ar;	
	}
	
	@ResponseBody
	@RequestMapping(value="/sources", produces = "application/json")
	public List<SwitchBoardEntry> findAll() {
		System.out.println("****** /sources  called");
		//System.out.println("controller rroriRepository is:" + rroriRepository);
		List<SwitchBoardEntry> ar = (List<SwitchBoardEntry>) switchBoardRepository.findAll();
		if ( ar != null) {
			System.out.println("All Entries are: " + ar);
		} else {
			System.out.println("All Entries is NULL");
		}
		return ar;	
	}
	
}
