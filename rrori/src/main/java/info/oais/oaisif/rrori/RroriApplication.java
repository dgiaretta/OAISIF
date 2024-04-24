package info.oais.oaisif.rrori;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import info.oais.oaisif.rrori.RroriApplication;

@SpringBootApplication
public class RroriApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SwitchBoardApplication.class, args);
		SpringApplication app = new SpringApplication(RroriApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8083"));
        app.run(args);
	}

}
