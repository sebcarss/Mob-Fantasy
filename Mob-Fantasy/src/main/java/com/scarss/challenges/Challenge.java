package com.scarss.challenges;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.List;

import com.scarss.properties.Component;

public abstract class Challenge extends Component {

	private static final String POSSIBLE_ANSWERS = "possibleAnswers";

	public Challenge() throws IOException {
		super();
	}

	public ChallengeResponse processAnswer(String answer) {
		Component component = null;
		
		String value = getPropertyValue(POSSIBLE_ANSWERS);
		List<String> possibleAnswers = asList(value.split(","));
		
		for (String possibleAnswer : possibleAnswers) {
			String[] possibleAnswerKeyValueArray = possibleAnswer.split("=");
			
			if (possibleAnswerKeyValueArray != null && possibleAnswerKeyValueArray.length == 2) {
				String possibleAnswerKey = possibleAnswerKeyValueArray[0];
				String possibleAnswerValue = possibleAnswerKeyValueArray[1];
				
				if (answer != null && answer.equals(possibleAnswerKey)) {
					component = instantiateClass(possibleAnswerValue);
				}
			}
		}
		
		return new ChallengeResponse(component);
	}

}