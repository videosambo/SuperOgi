package com.superogi.client;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.superogi.client.renderengine.Display;

public class Game implements Runnable {
	
	private Display display;
	private int height, width;
	private String title;
	
	public int fps;
	
	public Handler handler;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running = false;
	
	private Thread thread;
	
	public Game(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() {
		
	}
	
	private void tick() {
		
	}
	
	private void render() {
		
	}
	
	public void run() {
		
		init();
		
		int fpsCap = 60;
		double timePerTick = 1000000000 / fpsCap;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				fps = ticks;
				ticks = 0;
				timer = 0;
			}

			stop();
		}
	}
	
	public synchronized void start() {
		if (running) 
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		if (!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.err.println("An error occupied when tried to terminite thread");
			e.printStackTrace();
		}
	}
}
