package info.oais.oaisif.rrori;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.oais.infomodel.implementation.IdentifierRefImpl;
import info.oais.infomodel.implementation.utility.Config;
import jakarta.annotation.PostConstruct;


@Service
//@Transactional
public class RroriService {
	private static final Logger log = LoggerFactory.getLogger(RroriService.class);
	
	@Autowired
	RroriRepository rroriRepository;
	
	@SuppressWarnings("null")
	@PostConstruct
	public void postConstruct() {

		int numrows = -1;

		
//		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		String appConfigPath = rootPath + "rrori.properties";
//        Properties sbprop = new Properties();
//        RroriEntry sbe = new RroriEntry();
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
		RroriEntry sbe = new RroriEntry();
		Properties appProps = new Properties();
		InputStream input = null;
		String filename = "rrori.properties";

		appProps = new Config().getProperties(filename);  
        // get the value of the property
        @SuppressWarnings("rawtypes")
		Enumeration ex = appProps.propertyNames();
        log.info("Saving the initial values");
        String[] idparts = null;
        while (ex.hasMoreElements()) {
        	numrows++;
        	String key = (String) ex.nextElement();
	        String propValue = (String)(appProps.getProperty(key));
	        System.out.println("key: " + key + " propValue : " + propValue);
	        String[] lines = propValue.split("\n"); //System.getProperty("line.separator"));
	        sbe.setId(System.currentTimeMillis());
	        sbe.setDoName(lines[0]);
	        sbe.setDoid(lines[1]); 
	        sbe.setRidoid(lines[2]);
	        sbe.setRirole(lines[3]);
	        
	        System.out.println("******Saving "+ numrows + ": " + sbe);
	        rroriRepository.save(sbe);
	        System.out.println("******Saved: " + numrows);
        }
        //rroriRepository.flush();
        log.info("RroriRepository is:" + rroriRepository);
        log.info("Retrieve all records");
    	log.info("Entries: " + rroriRepository.findAll());
    	log.info("DO1 Entries: " + rroriRepository.findByDoName("DAVID"));
        
	}
}
