package com.superogi.client.renderEngine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Display {
	
	Canvas canvas;
	JFrame frame;
	
	int leveys, korkeus;
	String title;
	
	public Display(int leveys, int korkeus, String title) {
		super();
		this.leveys = leveys;
		this.korkeus = korkeus;
		this.title = title;
		
		createDisplay();
		
	}
	
	public void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(leveys, korkeus);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(leveys, korkeus));
		canvas.setMinimumSize(new Dimension(leveys, korkeus));
		canvas.setMaximumSize(new Dimension(leveys, korkeus));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	

	
}
