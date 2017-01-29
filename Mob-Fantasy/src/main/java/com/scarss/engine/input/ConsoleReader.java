package com.scarss.engine.input;

public class ConsoleReader implements UserInputReadable {

	/* (non-Javadoc)
	 * @see com.scarss.engine.input.UserInputReadable#getUserInput()
	 */
	@Override
	public String getUserInput() {
		return System.console().readLine();
	}
}
