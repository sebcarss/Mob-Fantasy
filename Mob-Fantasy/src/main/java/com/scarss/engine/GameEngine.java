package com.scarss.engine;

import java.io.IOException;

import com.scarss.engine.input.UserInputReadable;
import com.scarss.engine.output.GameRenderable;
import com.scarss.properties.Messages;

public class GameEngine implements Runnable {
	
	private final Messages messages;
	private final GameRenderable renderer;
	
	public GameEngine(GameRenderable renderer) {
		this.messages = loadMessages();
		this.renderer = renderer;
	}

	@Override
	public void run() {
		renderer.displayMessage(messages.getWelcomeMessage());
        String userInput = renderer.displayMessageWithInput("Your name is");
        renderer.displayMessage("You typed: " + userInput);
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
