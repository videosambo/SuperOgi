package com.superogi.client.renderEngine.graphics;

import com.superogi.client.GameHandler;
import com.superogi.client.entities.Entity;
import com.superogi.client.tiles.Tile;

public class GameCamera {

	private GameHandler handler;
	private float xOffset, yOffset;
	
	public GameCamera(GameHandler handler,float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace() {
		if (xOffset < 0) {
			xOffset = 0;
		} else if (xOffset > handler.getWorld().getWidth() * Tile.TILE_DIMENSION - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILE_DIMENSION - handler.getWidth();
		}
		if (yOffset < 0) {
			yOffset = 0;
		} else if (yOffset > handler.getWorld().getHeight() * Tile.TILE_DIMENSION - handler.getHeight()) {
			yOffset = handler.getWorld().getWidth() * Tile.TILE_DIMENSION - handler.getHeight();
		}
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset+= xAmt;
		yOffset+= yAmt; 
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	
	
}
