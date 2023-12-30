package info.oais.oaisif.genericadapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

//import info.oais.oaisif.switchBoard.SwitchBoardEntry;

//import info.oais.oaisif.specificAdapter.SpecificAdapterEntry;
import jakarta.ws.rs.core.HttpHeaders;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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

import info.oais.infomodel.implementation.utility.Config;

@SpringBootApplication
@Component
// @RestController
@Configuration
@PropertySource("classpath:genericadapter.properties")
@JsonIgnoreProperties(ignoreUnknown = true)



/**
 * The Generic Adapter application for Spring Boot
 */
public class GenericadapterApplication {
	
	public static void main(String[] args) {
		
		Properties appProps = new Properties();
		InputStream input = null;
		String filename = "genericadapter.properties";

		appProps = new Config().getProperties(filename);  
	   
		System.out.println("My description   is:" + appProps.getProperty("MYDESCRIPTION"));
	    System.out.println("My Authentication method is:" + appProps.getProperty("MYAUTHENTCATIONMETHOD"));
	    System.out.println("My serialisation is:" + appProps.getProperty("MYSERIALISATIONMETHOD"));
	    System.out.println("My communication   is:" + appProps.getProperty("MYCOMMUNICATIONMETHOD"));
	    System.out.println("My query method is:" + appProps.getProperty("MYQUERYMETHOD"));
		System.out.println("Switchboard root   is:" + appProps.getProperty("SWITCHBOARD"));
	    System.out.println("genericAdapterPort is:" + appProps.getProperty("GENERICADAPTERPORT"));
	    System.out.println("specificAdapter root   is:" + appProps.getProperty("SPECIFICADAPTER"));
		
	    
		SpringApplication app = new SpringApplication(GenericadapterApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", appProps.getProperty("GENERICADAPTERPORT")));
        app.run(args);
        
	}

	

//    public static <T> T json2Java(String str, Class<T> classType){
//    //public static <T> T json2Java(String str, Class<T> classType){
//
//    	T t = null;
//    	
//    	 try {
//    		ObjectMapper mapper = new ObjectMapper();
//    	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//			t=mapper.readValue(str, classType);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//    	 
//        return t;
//    }
    
    
}
