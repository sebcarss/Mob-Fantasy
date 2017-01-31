package com.scarss.challenges;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.scarss.properties.Component;

public abstract class Challenge extends Component {

	private static final String POSSIBLE_ANSWERS = "possibleAnswers";

	public Challenge() throws IOException {
		super();
	}

	public ChallengeResponse processAnswer(String answer) {
		ChallengeResponse response = new ChallengeResponse();
		
		String value = getPropertyValue(POSSIBLE_ANSWERS);
		List<String> possibleAnswers = asList(value.split(","));
		
		for (String possibleAnswer : possibleAnswers) {
			String[] possibleAnswerKeyValueArray = possibleAnswer.split("=");
			
			if (possibleAnswerKeyValueArray != null && possibleAnswerKeyValueArray.length == 2) {
				String possibleAnswerKey = possibleAnswerKeyValueArray[0];
				String possibleAnswerValue = possibleAnswerKeyValueArray[1];
				
				if (answer != null && answer.equals(possibleAnswerKey)) {
					Properties properties = new Properties();
					try {
						loadProperties(possibleAnswerValue + ".properties", properties);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					response.setSuccessful(true);
					response.setDamage(new Integer(properties.getProperty("damage")));
				}
			}
		}
		
		return response;
	}

}