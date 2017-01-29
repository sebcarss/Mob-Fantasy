package com.scarss.engine.output;

public class ConsoleDisplay implements GameRenderable {

	/* (non-Javadoc)
	 * @see com.scarss.engine.output.GameRenderable#displayMessage(java.lang.String)
	 */
	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}
}
