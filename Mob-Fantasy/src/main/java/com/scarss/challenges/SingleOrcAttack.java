package com.scarss.challenges;

import java.io.IOException;

public class SingleOrcAttack extends Challenge {
	
	private static final String FILENAME = "com/scarss/challenges/SingleOrcAttack.properties"; 
	
	public SingleOrcAttack() throws IOException {
		super();
	}
	
	@Override
	protected String getFilename() {
		return FILENAME;
	}
	
}
