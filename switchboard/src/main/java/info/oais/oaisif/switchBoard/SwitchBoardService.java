package info.oais.oaisif.switchBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


import jakarta.annotation.PostConstruct;

@Service
@PropertySource("classpath:switchBoard.properties")
public class SwitchBoardService {
	//private static final Logger log = LoggerFactory.getLogger(SwitchBoardService.class);
	
	@Autowired
	private SwitchBoardRepository switchBoardRepository;
	
	@SuppressWarnings("null")
	/**
	 * Get the JSON for 4 (FOUR) entries
	 */
	@Value("${sb0}") 
	private String sb0;
	@Value("${sb1}") 
	private String sb1;
	@Value("${sb2}") 
	private String sb2;
	@Value("${sb3}") 
	private String sb3;
	
	@PostConstruct
	public void postConstruct() {


		String filename = "switchBoard.properties";
        
		@SuppressWarnings("rawtypes")

        String[] myArray = new String[]{sb0, sb1, sb2, sb3};
        
        for (String propValue : myArray) {
        	SwitchBoardEntry sbe = new SwitchBoardEntry();
        	
	        System.out.println(" propValue : " + propValue);
	        String[] lines = propValue.split("!"); 
	
	        sbe.setId(System.currentTimeMillis());   
	        sbe.setArchiveName(lines[0]);
	        sbe.setArchiveDescription(lines[1]);
	        sbe.setArchiveURL(lines[2]);
	        System.out.println("SBE is:"+sbe.toString());
	        
	        switchBoardRepository.save(sbe);
        }
		
        System.out.println("switchBoardRepository is:  " + switchBoardRepository);
        System.out.println("Retrieve all records");
        System.out.println("All Entries: " + switchBoardRepository.findAll());
        System.out.println("RRORI Entries: " + switchBoardRepository.findByArchiveName("RRORI"));
	}

	
}
