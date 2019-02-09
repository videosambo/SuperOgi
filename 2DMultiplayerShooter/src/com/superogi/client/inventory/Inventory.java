package com.superogi.client.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.superogi.client.GameHandler;
import com.superogi.client.items.Item;

public class Inventory {
	
	private GameHandler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	public Inventory(GameHandler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}
	
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active)
			return;
		
		System.out.println("Inventory");
		for (Item i : inventoryItems) {
			System.out.println(i.getName() + "  " + i.getCount());
		}
	}
	
	public void render(Graphics g) {
		if(!active)
			return;
	}
	
	public void addItem(Item item) {
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}

	public GameHandler getHandler() {
		return handler;
	}

	public void setHandler(GameHandler handler) {
		this.handler = handler;
	}

}
