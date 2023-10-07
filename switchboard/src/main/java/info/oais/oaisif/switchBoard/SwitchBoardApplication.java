package info.oais.oaisif.switchBoard;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import info.oais.oaisif.rrori.RroriApplication;

@SpringBootApplication
public class SwitchBoardApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SwitchBoardApplication.class, args);
		SpringApplication app = new SpringApplication(SwitchBoardApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8085"));
        app.run(args);
	}

}
