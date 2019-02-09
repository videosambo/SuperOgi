package com.superogi.client.tiles;

import com.superogi.client.renderEngine.graphics.Assets;

public class ChestTile extends Tile {

	public ChestTile(int id) {
		super(Assets.blockChest, id, "Chest");
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
