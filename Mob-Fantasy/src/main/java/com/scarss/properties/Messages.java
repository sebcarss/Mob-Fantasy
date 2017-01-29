package com.scarss.properties;

import java.io.IOException;

public class Messages extends RSCProperties {
	
	private static final String WELCOME_MESSAGE = "welcomeMessage";
	private static final String FILENAME = "com/scarss/messages.properties";

	public Messages() throws IOException {
		super();
	}

	public String getWelcomeMessage() {
		return getPropertyValue(WELCOME_MESSAGE);
	}

	@Override
	protected String getFilename() {
		return FILENAME;
	}
}
