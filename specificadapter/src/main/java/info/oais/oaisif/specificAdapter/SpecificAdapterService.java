package info.oais.oaisif.specificAdapter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String appConfigPath = rootPath + "specificadapter.properties";
        Properties sbprop = new Properties();
        
        System.out.println("InputStream is: " + appConfigPath);

        // load the inputStream using the Properties
        try {
			sbprop.load(new FileInputStream(appConfigPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // get the value of the property
        @SuppressWarnings("rawtypes")
		Enumeration ex = sbprop.propertyNames();
        log.info("Saving the initial values");
        
        while (ex.hasMoreElements()) {
        	numrows++;
        	SpecificAdapterEntry sbe = new SpecificAdapterEntry();
        	String key = (String) ex.nextElement();
	        String propValue = (String)(sbprop.getProperty(key));
	        System.out.println("key: " + key + " propValue : " + propValue);
	        String[] lines = propValue.split("\n"); //System.getProperty("line.separator"));
	
	        //System.out.println("Property value is: " + propValue);
	        sbe.setId(System.currentTimeMillis());   
	        sbe.setAipDoid(lines[0]);
	        sbe.setIsComplete(lines[1]);
	        sbe.setpDi(lines[2]);
	        sbe.setInfoObject(lines[3]);
	        
	        specificAdapterRepository.save(sbe);
        }
        log.info("specificAdapterRepository is:" + specificAdapterRepository);
        log.info("Retrieve all records");
    	log.info("Entries: " + specificAdapterRepository.findAll());
    	//log.info("specificAdapter Entries: " + specificAdapterRepository.findByArchiveName("RRORI"));
	}

	
}
