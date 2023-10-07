package info.oais.oaisif.specificAdapter;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import info.oais.oaisif.rrori.RroriApplication;

@SpringBootApplication
public class SpecificAdapterApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SwitchBoardApplication.class, args);
		SpringApplication app = new SpringApplication(SpecificAdapterApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8510"));
        app.run(args);
	}

}
