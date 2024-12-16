package info.oais.oaisif.rrori;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
@PropertySource("classpath:rrori.properties")
public class RroriService {
	private static final Logger log = LoggerFactory.getLogger(RroriService.class);
	
	@Autowired
	RroriRepository rroriRepository;
	
	@SuppressWarnings("null")
	/**
	 * Get the JSON for 3 (THREE) AIPs
	 */
	@Value("${aip0}") 
	private String aip0;
	@Value("${aip1}") 
	private String aip1;
	@Value("${aip2}") 
	private String aip2;
	@PostConstruct
	public void postConstruct() {
	
        log.info("Saving the initial values");
        
    	System.out.println("aip0:"+ aip0);
        rroriRepository.save(new RroriEntry(aip0));
        System.out.println("aip1:"+ aip1);
        rroriRepository.save(new RroriEntry(aip1));
        System.out.println("aip2:"+ aip2);
        rroriRepository.save(new RroriEntry(aip2));

        System.out.println("rroriRepository is:" + rroriRepository);
        System.out.println("Retrieve all records");
        System.out.println("Entries: " + rroriRepository.findAll());

	}

	
}
