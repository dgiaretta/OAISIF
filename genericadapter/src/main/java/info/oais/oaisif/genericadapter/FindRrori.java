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

import info.oais.oaisif.switchBoard.SwitchBoardEntry;

/**
 * Get the details of the RRORI
 * 
 * @author david
 *
 */
@RestController
public class FindRrori {
//	@Autowired
//	RestTemplate restTemplate;

   @GetMapping(value = "ArchiveName?name=RRORI")
   /**
    * 
    * @param switchboardUrl The URL for the Switchboard
    * @return  The info from RRORI as a String
    */
   public String getRrori(String switchboardUrl) {
	  String loc = switchboardUrl+"/ArchiveName?name=RRORI";
      System.out.println("Switchboard is:" + loc);
	  HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      RestTemplate restTemplate = new RestTemplate();   

      String rrori = restTemplate.exchange(loc, HttpMethod.GET, entity, String.class).getBody();
      //ResponseEntity<SwitchBoardEntry> rrori = restTemplate.exchange(loc, HttpMethod.GET, entity, SwitchBoardEntry.class).getBody();
      return rrori;
   }
}
