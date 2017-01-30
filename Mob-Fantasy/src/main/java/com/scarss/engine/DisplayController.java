package com.scarss.engine;

import java.io.IOException;

import com.scarss.engine.output.GameRenderable;
import com.scarss.properties.Component;

public class DisplayController extends Component implements GameRenderable {

	private static final String DISPLAY_RENDERER = "renderer";
	private static final String COMPONENT_PATH = "com/scarss/engine/DisplayController.properties";
	private GameRenderable renderer;
	
	public DisplayController() throws IOException {
		super();
		renderer = (GameRenderable) createComponent(DISPLAY_RENDERER);
	}

	@Override
	protected String getFilename() {
		return COMPONENT_PATH;
	}

	@Override
	public void displayMessage(String message) {
		renderer.displayMessage(message);
	}

	@Override
	public String displayMessageWithInput(String message) {
		return renderer.displayMessageWithInput(message);
	}
	
}
