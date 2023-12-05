package info.oais.oaisif.genericadapter;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// import info.oais.oaisif.switchBoard.SwitchBoardEntry;

/**
 * Get a list of all the AIPs 
 * 
 * @author david
 *
 */
@RestController
public class FindAips {
//	@Autowired
//	RestTemplate restTemplate;

   @GetMapping(value = "/AIPAll")
   /**
    * 
    * @param specificAdapterUrl The URL of the Specific Adapter to use
    * @return the AIPs
    */
   public String getAllAips(String specificAdapterUrl) {
	  String loc = null;   // specificAdapterUrl+"/AIPAll";
      System.out.println("SpecificAdapter is:" + loc);
	  HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      RestTemplate restTemplate = new RestTemplate();   

      String aips = restTemplate.exchange(loc, HttpMethod.GET, entity, String.class).getBody();
      //ResponseEntity<SwitchBoardEntry> rrori = restTemplate.exchange(loc, HttpMethod.GET, entity, SwitchBoardEntry.class).getBody();
      return aips;
   }
}
