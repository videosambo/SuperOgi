package com.superogi.client.states;

import java.awt.Graphics;

import com.superogi.client.GameHandler;
import com.superogi.client.renderEngine.graphics.Assets;
import com.superogi.client.ui.ClickListener;
import com.superogi.client.ui.UIImageButton;
import com.superogi.client.ui.UIManager;
import com.superogi.client.worlds.World;

public class GameState extends State {

	private World world;
	private boolean escMenu = false;
	private UIManager uiManager;

	public GameState(GameHandler handler) {
		super(handler);
		// world = new World(handler, "res/worlds/DebugWorld.oki");
		world = new World(handler, "res/worlds/Map1.oki");
		handler.setWorld(world);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton((int) (handler.getWidth() / 2), (int) (handler.getHeight() / 2), 200, 50,
				Assets.button2anim, new ClickListener() {
					@Override
					public void onClick() {
						handler.getMouseManager().setUIManager(null);
						State.setState(handler.getGame().menuState);
					}
				}));

	}

	@Override
	public void tick() {
		if (!escMenu) {
			world.tick();
		} else {
			uiManager.tick();
		}
		getInput();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		// menu
		if (escMenu) {
			g.drawImage(Assets.box3, handler.getWidth() / 2 - 150, handler.getHeight() / 2 - 200, 300, 400, null);
			uiManager.render(g);
		}
	}

	private void getInput() {
		if (handler.getKeyManager().esc)
			escMenu = !escMenu;
	}
}
