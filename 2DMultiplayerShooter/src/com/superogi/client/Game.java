package com.superogi.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.superogi.client.input.KeyManager;
import com.superogi.client.input.MouseManager;
import com.superogi.client.renderEngine.Display;
import com.superogi.client.renderEngine.graphics.Assets;
import com.superogi.client.renderEngine.graphics.GameCamera;
import com.superogi.client.states.GameState;
import com.superogi.client.states.MenuState;
import com.superogi.client.states.SettingsState;
import com.superogi.client.states.State;

public class Game implements Runnable {

	private Display display;
	private int korkeus, leveys;
	public String title;

	public static int zoom = 100;

	public int fps;

	// states
	public State gameState;
	public State menuState;
	public State settingsState;

	// input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	// camera
	private GameCamera gameCamera;

	// handler
	private GameHandler handler;

	private BufferStrategy bs;
	private Graphics g;

	Assets assets = new Assets();

	private boolean running = false;

	private Thread thread;

	public Game(int leveys, int korkeus, String title) {
		handler = new GameHandler(this);
		this.leveys = leveys;
		this.korkeus = korkeus;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init() {
		display = new Display(leveys, korkeus, title);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		gameCamera = new GameCamera(handler, 0, 0);

		MenuState menuStateClass = new MenuState(handler); 
		
		gameState = new GameState(handler);
		menuState = menuStateClass;
		settingsState = new SettingsState(handler);
		State.setState(menuState);
		menuStateClass.createLoginMenu();
		
	}

	// peli logiikka
	private void tick() {
		keyManager.tick();
		if (State.getState() != null)
			State.getState().tick();

		handler.getClientConnectionHandler().clearQueue();
	}

	// render�inti
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		g.clearRect(0, 0, leveys, korkeus);
		if (State.getState() != null)
			State.getState().render(g);
		// alku

		// loppu
		// fps
		g.setColor(Color.RED);
		g.setFont(new Font("Impact", Font.PLAIN, 20));
		g.drawString("FPS: " + fps, 20, 30);

		// hiiri pos

		g.drawString("Mouse: X: " + getMouseManager().getMouseX() + "   Y: " + getMouseManager().getMouseY(), 20, 60);
		bs.show();
		g.dispose();
	}

	// Main loop
	public void run() {

		init();

		int fpsCap = 60;
		double timePerTick = 1000000000 / fpsCap;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		// Oikea main loop
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

		}

		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getKorkeus() {
		return korkeus;
	}

	public int getLeveys() {
		return leveys;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.err.println("Threadin pysäyttämisessä sattui virhe!");
			e.printStackTrace();
		}

	}

}
