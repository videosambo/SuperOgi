package com.superogi.client.states;

import java.awt.Graphics;

import com.superogi.client.GameHandler;
import com.superogi.client.renderEngine.graphics.Assets;
import com.superogi.client.ui.ClickListener;
import com.superogi.client.ui.UIImageButton;
import com.superogi.client.ui.UIManager;

public class MenuState extends State {
	
	//menu play 520 200 ja 760 300
	private UIManager uiManager;

	public MenuState(GameHandler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.button1anim, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
