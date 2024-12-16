package info.oais.oaisif.rrori;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RroriApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RroriApplication.class, args);
		SpringApplication app = new SpringApplication(RroriApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8083"));
        app.run(args);
	}

}
