package com.scarss.challenges;

import com.scarss.properties.Component;

public class ChallengeResponse {

	private boolean successful = false;
	private Integer damage;

	public ChallengeResponse() {
//		damage = new Integer(response.getPropertyValue("damage"));
	}
	
	public boolean isSuccess() {
		return successful;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setSuccess(boolean successful) {
		this.successful = successful;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}
	
}
