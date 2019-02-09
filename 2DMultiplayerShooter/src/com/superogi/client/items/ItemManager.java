package com.superogi.client.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import com.superogi.client.GameHandler;

public class ItemManager {
	
	private GameHandler handler;
	private ArrayList<Item> items;
	
	public ItemManager(GameHandler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
	}
	
	public void tick() {
		Iterator<Item> it = items.iterator();
		while(it.hasNext()) {
			Item i = it.next();
			i.tick();
			if (i.isPickedUp())
				it.remove();
		}
	}
	
	public void render(Graphics g) {
		for (Item i : items) {
			i.render(g);
		}
	}

	public void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
	}

	public GameHandler getHandler() {
		return handler;
	}

	public void setHandler(GameHandler handler) {
		this.handler = handler;
	}
}
