package com.superogi.client.renderengine;

import java.awt.Canvas;
import java.awt.Dimension;

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
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Dimension dimension = new Dimension(width, height);
		
		canvas = new Canvas();
		canvas.setPreferredSize(dimension);
		canvas.setMinimumSize(dimension);
		canvas.setMaximumSize(dimension);
		
		frame.add(canvas);
		frame.pack();
		
	}

}
