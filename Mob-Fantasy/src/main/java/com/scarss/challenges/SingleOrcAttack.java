package com.scarss.challenges;

import java.io.IOException;

import com.scarss.properties.Component;

public class SingleOrcAttack extends Component {
	
	private static final String FILENAME = "com/scarss/challenges/SingleOrcAttack.properties"; 
	
	public SingleOrcAttack() throws IOException {
		super();
	}

	private String userAnswer;
	
	public void offer() {
		outputStory();
		getAnswerFromUser();
		processAnswer();
	}
	
	private void outputStory() {
		System.out.println("Single Orc Attack Story");
	}
	
	private void getAnswerFromUser() {
		userAnswer = System.console().readLine("> ");
	}
	
	private void processAnswer() {
		System.out.println("You chose to " + userAnswer + " therefore you died!");
	}

	@Override
	protected String getFilename() {
		return FILENAME;
	}
	
}
