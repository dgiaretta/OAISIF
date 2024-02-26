package info.oais.oaisif.genericadapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import info.oais.oaisif.genericadapter.GenericAdapterEntry;

import jakarta.annotation.PostConstruct;

@Service
@PropertySource("classpath:genericadapter.properties")
public class GenericAdapterService {
	private static final Logger log = LoggerFactory.getLogger(GenericAdapterService.class);
	
	@Autowired
	GenericAdapterRepository genericAdapterRepository;
	@SuppressWarnings("null")
	
	/**
	 * Get the values for the config properties
	 */
	@Value("${SWITCHBOARD}") 
	private String switchboard;
	@Value("${GENERICADAPTERPORT}") 
	private String genericadapterport;
	@Value("${MYDESCRIPTION}") 
	private String mydescription;
	@Value("${SPECIFICADAPTER}") 
	private String specificadapter;
	@Value("${MYAUTHENTCATIONMETHOD}") 
	private String myauthenticationmethod;
	@Value("${MYSERIALISATIONMETHOD}") 
	private String myserialisationmethod;
	@Value("${MYCOMMUNICATIONMETHOD}") 
	private String mycommunicationmethod;
	@Value("${MYQUERYMETHOD}") 
	private String myquerymethod;

	@PostConstruct
	public void postConstruct() {
		// get the value of the property
        @SuppressWarnings("rawtypes")
        String[] myKeys = new String[]{"SWITCHBOARD", "GENERICADAPTERPORT", "MYDESCRIPTION", "SPECIFICADAPTER",
        		"MYAUTHENTCATIONMETHOD", "MYSERIALISATIONMETHOD", "MYCOMMUNICATIONMETHOD", "MYQUERYMETHOD"};
        String[] propValues = new String[] {switchboard, genericadapterport, mydescription, specificadapter,
        		myauthenticationmethod, myserialisationmethod, mycommunicationmethod, myquerymethod};
        
        
        for (int i=0; i<myKeys.length; i++) {
        	
        	GenericAdapterEntry sbe = new GenericAdapterEntry();
        	String key = myKeys[i];
	        String propValue = propValues[i];
	        System.out.println("key: " + key + " propValue : " + propValue);
	
	        sbe.setId(System.currentTimeMillis());   
	        sbe.setPropertyName(key);
	        sbe.setPropertyValue(propValue);
	       
	        genericAdapterRepository.save(sbe);
        }
        log.info("genericAdapterRepository is:" + genericAdapterRepository);
        log.info("Retrieve all records");
    	log.info("Entries: " + genericAdapterRepository.findAll());
 
	}

	
}
