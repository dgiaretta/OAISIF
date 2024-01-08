package info.oais.oaisif.specificAdapter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.oais.infomodel.implementation.utility.OaisIfConfig;
import jakarta.annotation.PostConstruct;

@Service
public class SpecificAdapterService {
	private static final Logger log = LoggerFactory.getLogger(SpecificAdapterService.class);
	
	@Autowired
	SpecificAdapterRepository specificAdapterRepository;
	
	@SuppressWarnings("null")
	@PostConstruct
	public void postConstruct() {
		//ArrayList<String>[] data = null;
		int numrows = -1;
		
		//for (int i=0; i<7; i++)
		//	data[i] = new ArrayList<String>();
		
		Properties appProps = new Properties();
		InputStream input = null;
		String filename = "specificadapter.properties";

		appProps = new OaisIfConfig().getProperties(filename);  
		
        // get the value of the property
        @SuppressWarnings("rawtypes")
		Enumeration ex = appProps.propertyNames();
        log.info("Saving the initial values");
        
        while (ex.hasMoreElements()) {
        	numrows++;
        	SpecificAdapterEntry sbe = new SpecificAdapterEntry();
        	String key = (String) ex.nextElement();
	        String propValue = (String)(appProps.getProperty(key));
	        System.out.println("key: " + key + " propValue : " + propValue);
	        String[] lines = propValue.split("\n"); //System.getProperty("line.separator"));
	
	        //System.out.println("Property value is: " + propValue);
	        sbe.setId(System.currentTimeMillis());   
	        sbe.setAipDoid(lines[0]);
	        sbe.setIsComplete(lines[1]);
	        sbe.setPdiDoid(lines[2]);
	        sbe.setIoDoid(lines[3]);
	        
	        specificAdapterRepository.save(sbe);
        }
        System.out.println("specificAdapterRepository is:" + specificAdapterRepository);
        System.out.println("Retrieve all records");
        System.out.println("Entries: " + specificAdapterRepository.findAll());
    	//log.info("specificAdapter Entries: " + specificAdapterRepository.findByArchiveName("RRORI"));
	}

	
}
