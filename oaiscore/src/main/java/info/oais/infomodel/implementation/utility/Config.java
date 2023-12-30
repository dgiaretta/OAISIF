package info.oais.infomodel.implementation.utility;

import static java.util.Objects.nonNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration


/** This class is responsible for loading configuration from properties file.
 * @author David Giaretta
 *
 */
public class Config {
	/**
	 * Load the properties from the named properties file in the classpath.
	 * 
	 * @param prop The name of the properties file
	 * @return the Properties object with the entries from the properties file.
	 */
	public Properties getProperties(String prop) {
		Properties appProps = new Properties();
		InputStream input = null;
		String filename = prop;
		try { 
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);

			System.out.println("Props file resource:"+input);

			if (input == null) {
		        System.out.println("Sorry, unable to find " + filename);
		        return null;
		    }

			appProps.load(input);            
		   
			//System.out.println("My description   is:" + appProps.getProperty("MYDESCRIPTION"));
		} catch (Exception ex) {
		    ex.printStackTrace();
		} finally {
		    if (input != null) {
		        try {
		            input.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
		return appProps;
	}
	
	public String getJsonString(String propFile, String propKey, String qString)  {
		
		System.out.println("propFile: "+propFile+"\n"+"propKey: "+propKey+"\n"+"qString: "+qString);
		Properties appProps = getProperties(propFile); //new Config().getProperties(propFile);
		  
		String specUrl = appProps.getProperty(propKey);

	    System.out.println(propKey +  " is: " + specUrl);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    RestTemplate restTemplate = new RestTemplate();   

	    String jsonString = restTemplate.exchange(specUrl +qString, HttpMethod.GET, entity, String.class).getBody();
	    return jsonString;
	}
}
