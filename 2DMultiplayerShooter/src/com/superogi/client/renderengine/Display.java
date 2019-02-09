package com.superogi.client.renderengine;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Display {
	
	Canvas canvas;
	JFrame frame;
	
	int height, width;
	String title;
	
	public Display(int height, int width, String title) {
		super();
		this.height = height;
		this.width = width;
		this.title = title;
		
		createDisplay();
	}

	private void createDisplay() {
		
		
	}

}
