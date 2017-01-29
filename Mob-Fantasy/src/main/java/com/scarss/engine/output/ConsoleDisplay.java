package com.scarss.engine.output;

import com.scarss.engine.input.UserInputReadable;

public class ConsoleDisplay implements GameRenderable {

	private final UserInputReadable reader;
	
	public ConsoleDisplay(UserInputReadable reader) {
		this.reader = reader;
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
}
