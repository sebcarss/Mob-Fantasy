package com.scarss.challenges.outcomes;

import java.io.IOException;

import com.scarss.properties.Component;

public class FighterAttacksOrcWithLongsword extends Component {

	private static final String COMPONENT_PATH = "com/scarss/challenges/outcomes/FighterAttacksOrcWithLongsword.properties";
	
	public FighterAttacksOrcWithLongsword() throws IOException {
		super();
	}

	@Override
	protected String getFilename() {
		return COMPONENT_PATH;
	}

}
