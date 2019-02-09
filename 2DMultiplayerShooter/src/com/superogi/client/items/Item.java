package com.superogi.client.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.superogi.client.GameHandler;
import com.superogi.client.renderEngine.graphics.Assets;

public class Item {
	
	//Handler
	
	public static Item[] items = new Item[256];	
	public static Item woodItem = new Item(Assets.itemStick, "Stick", 0);
	
	//Class

	public static final int ITEMDIMENSION = 50;
	
	protected GameHandler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;

	protected int x, y, count;
	
	protected boolean pickedUp = false;
	
	protected Rectangle bounds;
	
	public Item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		
		bounds = new Rectangle(x, y, ITEMDIMENSION, ITEMDIMENSION);
		
		items[id] = this;
	}
	
	public void tick() {
		if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).intersects(bounds)) {
			pickedUp = true;
			handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}
	
	public void render(Graphics g) {
		if(handler == null)
			return;
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEMDIMENSION, ITEMDIMENSION, null);
	}
	
	public Item createNew(int x, int y) {
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	//GETTERS AND SETTERS

	public GameHandler getHandler() {
		return handler;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public void setHandler(GameHandler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}
}