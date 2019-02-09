package com.superogi.client.states;

import java.awt.Graphics;

import com.superogi.client.GameHandler;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//luokat
	
	protected GameHandler handler;
	
	public State(GameHandler handler) {
		this.handler = handler;
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
