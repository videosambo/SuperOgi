package com.superogi.client.tiles;

import com.superogi.client.renderEngine.graphics.Assets;

public class StoneTile extends Tile{

	public StoneTile(int id) {
		super(Assets.blockStone, id, "Stone");
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
