package com.scarss.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.scarss.challenges.SingleOrcAttack;
import com.scarss.properties.Component;

public class GameEngine extends Component implements Runnable {
	
	private static final String COMPONENT_PATH = "com/scarss/engine/GameEngine.properties";
	private static final String DISPLAY_CONTROLLER = "displayController";
	private static final String WELCOME_MESSAGE = "welcomeMessage";
	
	private DisplayController renderer;
	private final String welcomeMessage;
	private final List<SingleOrcAttack> challenges;
	
	public GameEngine() throws IOException {
		this.welcomeMessage = getPropertyValue(WELCOME_MESSAGE);
		this.renderer = (DisplayController) createComponent(DISPLAY_CONTROLLER);
		this.challenges = getChallenges();
	}

	@Override
	public void run() {
		renderer.displayMessage(welcomeMessage);
		
		for (SingleOrcAttack challenge : challenges) {
			challenge.offer();
		}
	}
	
	private List<SingleOrcAttack> getChallenges() {
		String obj = getPropertyValue("challenges");
		String[] ary = obj.split(",");
		List<String> challenges = Arrays.asList(ary);
		
		// TODO Refactor
		
		List<SingleOrcAttack> challengeObjects = new ArrayList<>();
		for (String challenge : challenges) {
			try {
				Class<SingleOrcAttack> clazz = (Class<SingleOrcAttack>) Class.forName(challenge);
				try {
					challengeObjects.add(clazz.newInstance());
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return challengeObjects;
	}

	@Override
	protected String getFilename() {
		return COMPONENT_PATH;
	}

}
