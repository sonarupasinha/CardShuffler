package com.cards.shuffler.main.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This is a Singleton class using enum with methods to load all the properties
 * file at the start of the application.
 * 
 * @author Sona
 *
 */
public enum LoadProperties {
	// Creates a singleton Instance of the class
	INSTANCE;

	/**
	 * This method loads the config properties file
	 * 
	 * @return the config properties file.
	 */
	public Properties loadConfigPropertiesFile() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = LoadProperties.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}

	/**
	 * Loads the error message properties file
	 * 
	 * @return The error message properties file.
	 */
	public Properties loadErrMsgsFile() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = LoadProperties.class.getClassLoader().getResourceAsStream("error.messages");
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}