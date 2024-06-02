package info.oais.oaisif.oldrrori;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RroriApplication {

	public static void main(String[] args) {
		//RroriApplication.run(RroriApplication.class, args);
		SpringApplication app = new SpringApplication(RroriApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8083"));
        app.run(args);
	}

}
