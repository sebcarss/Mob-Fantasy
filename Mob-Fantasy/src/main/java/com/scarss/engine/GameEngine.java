package com.scarss.engine;

import java.io.IOException;
import java.util.List;

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
		renderer.displayMessage(messages.getWelcomeMessage());
		
		List<SingleOrcAttack> challenges = (List<SingleOrcAttack>) messages.getChallenges();
		
		for (SingleOrcAttack challenge : challenges) {
			challenge.offer();
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
