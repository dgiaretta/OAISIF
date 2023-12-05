package info.oais.oaisif.genericadapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class GenericAdapterService {
	private static final Logger log = LoggerFactory.getLogger(GenericAdapterService.class);
	
	@Autowired
	GenericAdapterRepository genericAdapterRepository;
	@Autowired 
	private ResourceLoader resourceLoader;
	
	@SuppressWarnings("null")
	@PostConstruct
	public void postConstruct() {
		//ArrayList<String>[] data = null;
		int numrows = -1;
		
		//for (int i=0; i<7; i++)
		//	data[i] = new ArrayList<String>();
		
//		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		String appConfigPath = rootPath + "genericadapter.properties";
//        Properties sbprop = new Properties();
//        
//        System.out.println("InputStream is: " + appConfigPath);
//
//        // load the inputStream using the Properties
//        try {
//			sbprop.load(new FileInputStream(appConfigPath));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
		Resource resource = new ClassPathResource("genericadapter.properties");
		File file = null;
		try {
			file = resource.getFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties appProps = new Properties();
		try {
			appProps.load(new FileInputStream(file));  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        
        // get the value of the property
        @SuppressWarnings("rawtypes")
		Enumeration ex = appProps.propertyNames();
        log.info("Saving the initial values");
        
        while (ex.hasMoreElements()) {
        	numrows++;
        	GenericAdapterEntry sbe = new GenericAdapterEntry();
        	String key = (String) ex.nextElement();
	        String propValue = (String)(appProps.getProperty(key));
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
