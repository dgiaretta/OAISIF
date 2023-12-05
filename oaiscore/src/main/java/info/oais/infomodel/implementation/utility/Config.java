package info.oais.infomodel.implementation.utility;

import static java.util.Objects.nonNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


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
		   
			System.out.println("My description   is:" + appProps.getProperty("MYDESCRIPTION"));
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
	
}
