package com.scarss.engine.input;

import java.io.IOException;

import com.scarss.properties.Component;

public class ConsoleReader extends Component implements UserInputReadable {
	
	private static final String COMPONENT_PATH = "com/scarss/engine/input/ConsoleReader.properties";

	public ConsoleReader() throws IOException {
		super();
	}

	private static final String CONSOLE_START_CHAR = "> ";

	/* (non-Javadoc)
	 * @see com.scarss.engine.input.UserInputReadable#getUserInput()
	 */
	@Override
	public String getUserInput() {
		return System.console().readLine(CONSOLE_START_CHAR);
	}

	@Override
	protected String getFilename() {
		return COMPONENT_PATH;
	}
}
