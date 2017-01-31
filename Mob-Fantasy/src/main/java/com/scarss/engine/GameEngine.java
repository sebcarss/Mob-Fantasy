package com.scarss.engine;

import java.io.IOException;
import java.util.List;

import com.scarss.challenges.Challenge;
import com.scarss.challenges.ChallengeResponse;
import com.scarss.properties.Component;

public class GameEngine extends Component implements Runnable {
	
	private static final String CHALLENGES = "challenges";
	private static final String COMPONENT_PATH = "com/scarss/engine/GameEngine.properties";
	private static final String DISPLAY_CONTROLLER = "displayController";
	private static final String WELCOME_MESSAGE = "welcomeMessage";
	
	private DisplayController displayController;
	private final String welcomeMessage;
	private final List<Challenge> challenges;
	
	@SuppressWarnings("unchecked")
	public GameEngine() throws IOException {
		this.welcomeMessage = getPropertyValue(WELCOME_MESSAGE);
		this.displayController = (DisplayController) createComponent(DISPLAY_CONTROLLER);
		this.challenges = (List<Challenge>) createComponents(CHALLENGES);
	}

	@Override
	public void run() {
		displayController.render(welcomeMessage);
		
		for (Challenge challenge : challenges) {
			boolean challengeComplete = false;
			
			do {
				ChallengeResponse response = displayController.render(challenge);
				
				if (response.isSuccessful()) {
					challengeComplete = true;
				} 
			} while (!challengeComplete);
		}
	}
	
	@Override
	protected String getFilename() {
		return COMPONENT_PATH;
	}

}
