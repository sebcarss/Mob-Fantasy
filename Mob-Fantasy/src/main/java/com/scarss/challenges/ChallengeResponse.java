package com.scarss.challenges;

import com.scarss.properties.Component;

public class ChallengeResponse {

	private final Component response;

	public ChallengeResponse(Component response) {
		this.response = response;
	}
	
	public boolean isSuccessful() {
		if (response != null) {
			return true;
		} else {
			return false;
		}
	}
	
}
