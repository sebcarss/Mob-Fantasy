package com.scarss.engine;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.scarss.challenges.SingleOrcAttack;
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
		// Welcome message - intro only
		renderer.displayMessage(messages.getWelcomeMessage());
		
		@SuppressWarnings("unchecked")
		List<SingleOrcAttack> challenges = (List<SingleOrcAttack>) messages.getChallenges();
		
		// Loop for each question
        String userInput = renderer.displayMessageWithInput("Your name is");
        
        renderer.displayMessage("You typed: " + userInput);
        
        if (null != userInput && userInput.equals("Seb")) {
        	renderer.displayMessage("Whoop!");
        } else {
        	renderer.displayMessage("You suck!");
        }
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
