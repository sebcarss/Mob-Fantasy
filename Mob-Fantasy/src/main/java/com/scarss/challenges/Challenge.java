package com.scarss.challenges;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.List;

public class Challenge {

	private String story;
	private String possibleAnswersString;

	public ChallengeResponse processAnswer(String answer) {
		ChallengeResponse response = new ChallengeResponse();
		
		List<String> possibleAnswers = asList(possibleAnswersString.split(","));
		
		for (String possibleAnswer : possibleAnswers) {
			if (answer != null && answer.equals(possibleAnswer)) {
				response.setSuccess(true);
			}
			
//			String[] possibleAnswerKeyValueArray = possibleAnswer.split("=");
//			
//			if (possibleAnswerKeyValueArray != null && possibleAnswerKeyValueArray.length == 2) {
//				String possibleAnswerKey = possibleAnswerKeyValueArray[0];
//				String possibleAnswerValue = possibleAnswerKeyValueArray[1];
//				
//				if (answer != null && answer.equals(possibleAnswerKey)) {
//					Properties properties = new Properties();
//					try {
//						loadProperties(possibleAnswerValue + ".properties", properties);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//					
//					response.setSuccessful(true);
//					response.setDamage(new Integer(properties.getProperty("damage")));
//				}
//			}
		}
		
		return response;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getPossibleAnswersString() {
		return possibleAnswersString;
	}

	public void setPossibleAnswersString(String possibleAnswersString) {
		this.possibleAnswersString = possibleAnswersString;
	}

}