package com.superogi.client.entities.creatures;

import com.superogi.client.Game;
import com.superogi.client.Handler;
import com.superogi.client.entities.Entity;
import com.superogi.client.tiles.Tile;

public abstract class Creature extends Entity {

	public static final float DEFAULT_SPEED = 5.0f;
	public static final int DEFAULT_CREATURE_WIDTH = Game.zoom, // 100
			DEFAULT_CREATURE_HEIGHT = Game.zoom; // 100

	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		if (!checkEntityCollision(xMove, 0f))
			moveX();
		if (!checkEntityCollision(0f, yMove))
			moveY();
	}

	public void move(float xMove, float yMove) {
		x += xMove;
		y += yMove;
	}

	public void moveX() {
		if (xMove > 0) {
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_DIMENSION;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_DIMENSION)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_DIMENSION)) {
				x += xMove;
			} else {
				x = tx * Tile.TILE_DIMENSION - bounds.x - bounds.width - 1;
			}
		} else if (xMove < 0) {
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_DIMENSION;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_DIMENSION)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_DIMENSION)) {
				x += xMove;
			} else {
				x = tx * Tile.TILE_DIMENSION + Tile.TILE_DIMENSION - bounds.x;
			}
		}
	}

	public void moveY() {
		if (yMove < 0) {
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_DIMENSION;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_DIMENSION, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_DIMENSION, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILE_DIMENSION + Tile.TILE_DIMENSION - bounds.y;
			}
		} else if (yMove > 0) {
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_DIMENSION;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_DIMENSION, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_DIMENSION, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILE_DIMENSION - bounds.y - bounds.height - 1;
			}
		}

		// y += yMove;
	}

	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	public boolean swimming(int x, int y) {
		if (handler.getWorld().getTile((x + bounds.x + bounds.width) / Tile.TILE_DIMENSION,
				(y + bounds.y + bounds.height) / Tile.TILE_DIMENSION).equals(Tile.waterTile)) {
			return true;
		}
		return false;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
