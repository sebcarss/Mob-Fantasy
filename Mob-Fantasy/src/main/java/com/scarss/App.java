package com.scarss;

import java.io.IOException;

import com.scarss.engine.GameEngine;
import com.scarss.engine.input.ConsoleReader;
import com.scarss.engine.input.UserInputReadable;
import com.scarss.engine.output.ConsoleDisplay;
import com.scarss.engine.output.GameRenderable;

/**
 * Mob Fantasy - A game to give a group of people the experience of programming in a mob. This is a game that
 * should be played with 5 people, non of whom need be developers. The point of this exercise is to allow 
 * people to get a feel for the benefits of pair programming through programming as a mob. 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Create objects for dependency injection into GameEngine
    	UserInputReadable reader = new ConsoleReader();
    	GameRenderable renderer = new ConsoleDisplay(reader);
    	
		try {
			GameEngine gameEngine = new GameEngine(renderer);
			gameEngine.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
