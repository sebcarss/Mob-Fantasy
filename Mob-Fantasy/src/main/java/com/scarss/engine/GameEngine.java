package com.scarss.engine;

import java.io.IOException;

import com.scarss.engine.input.UserInputReadable;
import com.scarss.engine.output.GameRenderable;
import com.scarss.properties.Messages;

public class GameEngine implements Runnable {
	
	private final Messages messages;
	private final GameRenderable renderer;
	private final UserInputReadable reader;
	
	public GameEngine(GameRenderable renderer, UserInputReadable reader) {
		this.messages = loadMessages();
		this.renderer = renderer;
		this.reader = reader;
	}

	@Override
	public void run() {
		renderer.displayMessage(messages.getWelcomeMessage());
        renderer.displayMessage("Your name is " + reader.getUserInput());
	}

	private Messages loadMessages() {
		Messages messages = null;
    	
    	try {
			messages = new Messages();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}

    	return messages;
	}

}
