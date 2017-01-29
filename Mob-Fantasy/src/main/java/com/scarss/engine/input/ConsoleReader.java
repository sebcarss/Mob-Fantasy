package com.scarss.engine.input;

public class ConsoleReader implements UserInputReadable {

	private static final String CONSOLE_START_CHAR = "> ";

	/* (non-Javadoc)
	 * @see com.scarss.engine.input.UserInputReadable#getUserInput()
	 */
	@Override
	public String getUserInput() {
		return System.console().readLine(CONSOLE_START_CHAR);
	}
}
