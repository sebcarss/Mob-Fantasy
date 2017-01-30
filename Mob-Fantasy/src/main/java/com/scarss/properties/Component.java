package com.scarss.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class Component implements PropertyValueAccessible {

	private final Properties properties = new Properties();
	
	public Component() throws IOException {
		loadProperties(getFilename());
	}
	
	private void loadProperties(String filename) throws IOException {
		InputStream inputStream = getInputStream(filename);
		
		if (inputStream != null) {
			properties.load(inputStream);
			inputStream.close();
		} else {
			throw new FileNotFoundException("Property file " + filename + " not found in the classpath!");
		}
	}

	private InputStream getInputStream(String filename) {
		return getClass().getClassLoader().getResourceAsStream(filename);
	}
	
	/** 
	 * This is the file path and name of the properties file within the src/main/resources folder.
	 * It is required for each properties file to be loaded properly to a Properties file.
	 * e.g "com/scarss/properties/Messages.properties" 
	 * 
	 * @return
	 */
	protected abstract String getFilename();

	/* (non-Javadoc)
	 * @see com.scarss.properties.PropertyValueAccessible#getPropertyValue(java.lang.String)
	 */
	@Override
	public String getPropertyValue(String key) {
		return properties.getProperty(key);
	}

}