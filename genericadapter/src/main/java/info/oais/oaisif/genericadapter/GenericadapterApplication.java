package info.oais.oaisif.genericadapter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import info.oais.oaisif.switchBoard.SwitchBoardEntry;

//import info.oais.oaisif.specificAdapter.SpecificAdapterEntry;
import jakarta.ws.rs.core.HttpHeaders;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.bind.annotation.Controller;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

@SpringBootApplication
@Component
@RestController
@Configuration
@JsonIgnoreProperties(ignoreUnknown = true)

/**
 * The Generic Adapter application for Spring Boot
 */
public class GenericadapterApplication {
    @Value("${SWITCHBOARD}")
    /**
     * The port for the switchboard
     */
	static
    String switchboardUrl = "http://localhost:8085";
    /**
     * The port for the specific adapter
     */
    @Value("${SPECIFICADAPTER}")
	static
    String specificAdapterUrl = "http://localhost:8510";
    
    /**
     * The port for the generic adapter
     */
    @Value("${GENERICADAPTER}")
	static 
    String genericAdapterPort="8765";
    


    
	public static void main(String[] args) {

	    System.out.println("Switchboard root   is:" + switchboardUrl);
	    System.out.println("genericAdapterPort is:" + genericAdapterPort);
	    System.out.println("specificAdapter root   is:" + specificAdapterUrl);
		
		SpringApplication app = new SpringApplication(GenericadapterApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", genericAdapterPort));
        app.run(args);
        
        //String loc = switchboardUrl+"/switchBoardEntries/search/findByArchiveName?name=RRORI";
        //GenericadapterApplication ga = new GenericadapterApplication();
        RestTemplate restTemplate = new RestTemplate();
        
        String rrori = (new FindRrori()).getRrori( switchboardUrl);
        System.out.println("rrori is:" + rrori);
        SwitchBoardEntry[] sbes = json2Java(rrori, SwitchBoardEntry[].class);
        System.out.println("SwitchBoardEntry(ies) is (jason2Java):" + sbes);
        System.out.println("Number of SwitchBoardEntry(ies) is:" + sbes.length);
        System.out.println("--------------");
        System.out.println("SwitchBoardEntry[0] is (json2Java):" + sbes[0]);
        System.out.println("--------------");
        String aips = (new FindAips()).getAllAips(specificAdapterUrl );
        System.out.println("List of AIPs in my archive is:" + aips);
//        SpecificAdapterEntry[] aips = json2Java(rrori, SpecificAdapterEntry[].class);
//        System.out.println("My SpecificAdapters AIPs are:" + aips);
//        System.out.println("Number of AIPs is:" + sbes.length);
        
	}
    @Bean
    public RestTemplate getRestTemplate() {
        	return new RestTemplate();
	}
    public static <T> T json2Java(String str, Class<T> classType){
    //public static <T> T json2Java(String str, Class<T> classType){

    	T t = null;
    	
    	 try {
    		ObjectMapper mapper = new ObjectMapper();
    	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			t=mapper.readValue(str, classType);
		}catch (Exception e) {
			e.printStackTrace();
		}
    	 
        return t;
    }

}
