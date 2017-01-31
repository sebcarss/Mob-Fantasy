package com.scarss.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public abstract class Component implements PropertyValueAccessible {

	private final Properties properties = new Properties();
	
	public Component() throws IOException {
		loadProperties(getFilename(), properties);
	}
	
	protected void loadProperties(String filename, Properties properties) throws IOException {
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

	/**
	 * Instantiate a new component through reflection
	 * 
	 * @param key
	 * @return
	 */
	protected Component createComponent(String key) {
		String componentName = getPropertyValue(key);
		return instantiateClass(componentName);
	}

	protected Component instantiateClass(String componentName) {
		Component clazzInstance = null;
		try {
			@SuppressWarnings("unchecked")
			Class<Component> clazz = (Class<Component>) Class.forName(componentName);
			Constructor<Component> ctor = clazz.getConstructor();
			clazzInstance = (Component) ctor.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException |
				 NoSuchMethodException | SecurityException | IllegalArgumentException | 
				 InvocationTargetException e) {
			e.printStackTrace(); // TODO Add an appropriate error message
		}
		return clazzInstance;
	}

	protected List<? extends Component> createComponents(String key) {
		String propertyValue = getPropertyValue(key);
		String[] componentArray = propertyValue.split(",");
		List<String> componentNames = Arrays.asList(componentArray);
		List<Component> components = new ArrayList<>();
		
		for (String componentName : componentNames) {
			components.add(instantiateClass(componentName));
		}
		return components;
	}

}