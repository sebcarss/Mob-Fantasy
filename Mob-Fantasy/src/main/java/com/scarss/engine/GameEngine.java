package com.scarss.engine;

import java.io.IOException;

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
        
        String name = getName();
        System.out.println("Your name is " + name);
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

	// TODO Move to an interface for reading input from user
	private String getName() {
		return System.console().readLine();
	}

}
