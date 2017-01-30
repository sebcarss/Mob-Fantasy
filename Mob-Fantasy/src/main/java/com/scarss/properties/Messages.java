package com.scarss.properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.scarss.challenges.SingleOrcAttack;

public class Messages extends RSCProperties {
	
	private static final String WELCOME_MESSAGE = "welcomeMessage";
	private static final String FILENAME = "com/scarss/properties/messages.properties";

	public Messages() throws IOException {
		super();
	}

	public String getWelcomeMessage() {
		return (String) getPropertyValue(WELCOME_MESSAGE);
	}
	
	public List<SingleOrcAttack> getChallenges() {
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
		
		return null;
	}

	@Override
	protected String getFilename() {
		return FILENAME;
	}
}
