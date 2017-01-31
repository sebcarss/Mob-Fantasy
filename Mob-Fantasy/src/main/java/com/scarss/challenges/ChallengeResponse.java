package com.scarss.challenges;

import com.scarss.properties.Component;

public class ChallengeResponse {

	private boolean successful = false;
	private Integer damage;

	public ChallengeResponse(Component response) {
		if (response != null) {
			successful = true;
			damage = new Integer(response.getPropertyValue("damage"));
		}
	}
	
	public boolean isSuccessful() {
		return successful;
	}

	public Integer getDamage() {
		return damage;
	}
	
}
