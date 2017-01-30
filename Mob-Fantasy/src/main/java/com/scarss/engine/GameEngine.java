package com.scarss.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.scarss.challenges.SingleOrcAttack;
import com.scarss.properties.Component;

public class GameEngine extends Component implements Runnable {
	
	private static final String CHALLENGES = "challenges";
	private static final String COMPONENT_PATH = "com/scarss/engine/GameEngine.properties";
	private static final String DISPLAY_CONTROLLER = "displayController";
	private static final String WELCOME_MESSAGE = "welcomeMessage";
	
	private DisplayController renderer;
	private final String welcomeMessage;
	private final List<SingleOrcAttack> challenges;
	
	@SuppressWarnings("unchecked")
	public GameEngine() throws IOException {
		this.welcomeMessage = getPropertyValue(WELCOME_MESSAGE);
		this.renderer = (DisplayController) createComponent(DISPLAY_CONTROLLER);
		this.challenges = (List<SingleOrcAttack>) createComponents(CHALLENGES);
	}

	@Override
	public void run() {
		renderer.displayMessage(welcomeMessage);
		
		for (SingleOrcAttack challenge : challenges) {
			challenge.offer();
		}
	}
	
	@Override
	protected String getFilename() {
		return COMPONENT_PATH;
	}

}
