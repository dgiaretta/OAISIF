package info.oais.oaisif.switchBoard;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.oais.infomodel.implementation.utility.OaisIfConfig;

import jakarta.annotation.PostConstruct;

@Service
public class SwitchBoardService {
	private static final Logger log = LoggerFactory.getLogger(SwitchBoardService.class);
	
	@Autowired
	SwitchBoardRepository switchBoardRepository;
	
	@SuppressWarnings("null")
	@PostConstruct
	public void postConstruct() {

		
		Properties appProps = new Properties();
		String filename = "switchBoard.properties";

		appProps = new OaisIfConfig().getProperties(filename);  
        
        if (appProps != null) {
			@SuppressWarnings("rawtypes")
			Enumeration ex = appProps.propertyNames();
	        log.info("Saving the initial values");
	        System.out.println("Propertynames:"+ex.toString());
	        log.info("Saving the initial values");
	        
	        while (ex != null && ex.hasMoreElements()) {
	        	SwitchBoardEntry sbe = new SwitchBoardEntry();
	        	String key = (String) ex.nextElement();
		        String propValue = (String)(appProps.getProperty(key));
		        System.out.println("key: " + key + " propValue : " + propValue);
		        String[] lines = propValue.split("!"); //System.getProperty("line.separator"));
		
		        //System.out.println("Property value is: " + propValue);
		        sbe.setId(System.currentTimeMillis());   
		        sbe.setArchiveName(lines[0]);
		        sbe.setArchiveDescription(lines[1]);
		        sbe.setArchiveURL(lines[2]);
		        System.out.println("SBE is:"+sbe.toString());
		        //sbe.setArchiveAuth(lines[3]);
		        //sbe.setArchiveSerialisation(lines[4]);
		        //sbe.setArchiveComms(lines[5]);
		        //sbe.setArchiveQL(lines[6]);
		        switchBoardRepository.save(sbe);
	        }
		}
        System.out.println("switchBoardRepository is:  " + switchBoardRepository);
        System.out.println("Retrieve all records");
        System.out.println("All Entries: " + switchBoardRepository.findAll());
        System.out.println("RRORI Entries: " + switchBoardRepository.findByArchiveName("RRORI"));
	}

	
}
