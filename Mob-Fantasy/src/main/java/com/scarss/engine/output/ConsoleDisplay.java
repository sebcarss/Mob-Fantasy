package com.scarss.engine.output;

import java.io.IOException;

import com.scarss.engine.input.UserInputReadable;
import com.scarss.properties.Component;

public class ConsoleDisplay extends Component implements GameRenderable {
	
	private final static String COMPONENT_PATH = "com/scarss/engine/output/ConsoleDisplay.properties";
	private static final String READER = "reader";
	private UserInputReadable reader;
	
	public ConsoleDisplay() throws IOException {
		reader = (UserInputReadable) createComponent(READER);
	}

	/* (non-Javadoc)
	 * @see com.scarss.engine.output.GameRenderable#displayMessage(java.lang.String)
	 */
	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

	/* (non-Javadoc)
	 * @see com.scarss.engine.output.GameRenderable#displayMessage(java.lang.String)
	 */
	@Override
	public String displayMessageWithInput(String message) {
		System.out.println(message);
		return reader.getUserInput();
	}

	@Override
	protected String getFilename() {
		return COMPONENT_PATH;
	}
}
