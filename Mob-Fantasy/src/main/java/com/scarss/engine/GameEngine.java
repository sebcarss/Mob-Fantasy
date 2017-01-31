package com.scarss.engine;

import java.io.IOException;
import java.util.List;

import com.scarss.challenges.Challenge;
import com.scarss.challenges.ChallengeResponse;
import com.scarss.properties.Component;

public class GameEngine extends Component implements Runnable {
	
	private static final String HEALTH = "health";
	private static final String CHALLENGES = "challenges";
	private static final String COMPONENT_PATH = "com/scarss/engine/GameEngine.properties";
	private static final String DISPLAY_CONTROLLER = "displayController";
	private static final String WELCOME_MESSAGE = "welcomeMessage";
	
	private DisplayController displayController;
	private final String welcomeMessage;
	private final List<Challenge> challenges;
//	private Integer health;
	
	@SuppressWarnings("unchecked")
	public GameEngine() throws IOException {
		this.welcomeMessage = getPropertyValue(WELCOME_MESSAGE);
		this.displayController = (DisplayController) createComponent(DISPLAY_CONTROLLER);
		this.challenges = (List<Challenge>) createChallenges(CHALLENGES);
//		this.health = new Integer(getPropertyValue(HEALTH));
	}

	@Override
	public void run() {
		displayController.render(welcomeMessage);
//		displayController.render(getHealthMessage());
		
		for (Challenge challenge : challenges) {
			boolean challengeComplete = false;
			
			do {
				ChallengeResponse response = displayController.render(challenge);
//				if (response.getDamage() != null) {
//					health = health - response.getDamage();
//				}
//				displayController.render(getHealthMessage());
				
				if (response.isSuccess()) {
					challengeComplete = true;
				} else {
					displayController.render("\nOh dear, that didn't work this time... please try something else.");
				}
			} while (!challengeComplete);
		}
		
		displayController.render("Well Done! You have completed the game as a mob... what a great learning experience!");
	}

//	private String getHealthMessage() {
//		return "The mob's health is currently: " + health;
//	}
	
	@Override
	protected String getFilename() {
		return COMPONENT_PATH;
	}

}
