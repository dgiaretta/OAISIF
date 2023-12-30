package info.oais.oaisif.switchBoard;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.oais.infomodel.implementation.utility.Config;

import java.io.FileInputStream;

import jakarta.annotation.PostConstruct;

@Service
public class SwitchBoardService {
	private static final Logger log = LoggerFactory.getLogger(SwitchBoardService.class);
	
	@Autowired
	SwitchBoardRepository switchBoardRepository;
	
	@SuppressWarnings("null")
	@PostConstruct
	public void postConstruct() {
		//ArrayList<String>[] data = null;
		int numrows = -1;
		
		//for (int i=0; i<7; i++)
		//	data[i] = new ArrayList<String>();
		
//		InputStream inputStream = this.getClass().getClassLoader()
//                .getResourceAsStream("switchboard.properties");
//		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		String appConfigPath = rootPath + "switchboard.properties";
//        Properties sbprop = new Properties();
//        //SwitchBoardEntry sbe = new SwitchBoardEntry();
//        System.out.println("InputStream is: " + appConfigPath);
//
//        // load the inputStream using the Properties
//        try {
//			sbprop.load(new FileInputStream(appConfigPath));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        Properties sbprop = new Config().getProperties("switchboard.properties");
        // get the value of the property
        @SuppressWarnings("rawtypes")
		Enumeration ex = sbprop.propertyNames();
        System.out.println("Propertynames:"+ex.toString());
        log.info("Saving the initial values");
        
        while (ex.hasMoreElements()) {
        	numrows++;
        	SwitchBoardEntry sbe = new SwitchBoardEntry();
        	String key = (String) ex.nextElement();
	        String propValue = (String)(sbprop.getProperty(key));
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
        System.out.println("switchBoardRepository is:" + switchBoardRepository);
        System.out.println("Retrieve all records");
        System.out.println("All Entries: " + switchBoardRepository.findAll());
        System.out.println("RRORI Entries: " + switchBoardRepository.findByArchiveName("RRORI"));
	}

	
}
