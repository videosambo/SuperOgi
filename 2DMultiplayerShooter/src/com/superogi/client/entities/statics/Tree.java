package com.superogi.client.entities.statics;

import java.awt.Graphics;

import com.superogi.client.Handler;
import com.superogi.client.items.Item;
import com.superogi.client.renderEngine.graphics.Assets;
import com.superogi.client.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x + 40, y, 50, 20);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree1, (int) (x - handler.getGameCamera().getxOffset()) - 25,
				(int) (y - handler.getGameCamera().getyOffset() - (Tile.TILE_DIMENSION * 2) - 20), Tile.TILE_DIMENSION,
				Tile.TILE_DIMENSION * 3, null);
	}

	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));
	}

}
