package com.scarss;

import java.io.IOException;

import com.scarss.properties.Messages;

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
    	Messages messages = null;
    	
    	try {
			messages = new Messages();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	
        System.out.println(messages.getWelcomeMessage());
    }
}
