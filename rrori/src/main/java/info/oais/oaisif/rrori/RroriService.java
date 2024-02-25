package info.oais.oaisif.rrori;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;


@Service
@PropertySource("classpath:rrori.properties")
//@Transactional
public class RroriService {
	private static final Logger log = LoggerFactory.getLogger(RroriService.class);
	
	@Autowired
	RroriRepository rroriRepository;
	
	@SuppressWarnings("null")
	/**
	 * Get the JSON for 2 (TWO) RIs
	 */
	@Value("${sb1}") 
	private String sb1;
	@Value("${sb2}") 
	private String sb2;
	
	@PostConstruct
	public void postConstruct() {


		RroriEntry sbe = new RroriEntry();

        // get the value of the property
        @SuppressWarnings("rawtypes")
        String[] myArray = new String[]{sb1, sb2};
		

        for (String propValue : myArray) {
	        System.out.println(" propValue : " + propValue);
	        String[] lines = propValue.split("\n"); 
	        sbe.setId(System.currentTimeMillis());
	        sbe.setDoName(lines[0]);
	        sbe.setDoid(lines[1]); 
	        sbe.setRidoid(lines[2]);
	        sbe.setRirole(lines[3]);
	        
	        System.out.println("******Saving "+ ": " + sbe);
	        rroriRepository.save(sbe);
	        System.out.println("******Saved: ");
        }
        //rroriRepository.flush();
        log.info("RroriRepository is:" + rroriRepository);
        log.info("Retrieve all records");
    	log.info("Entries: " + rroriRepository.findAll());
    	log.info("DO1 Entries: " + rroriRepository.findByDoName("DAVID"));
        
	}
}
