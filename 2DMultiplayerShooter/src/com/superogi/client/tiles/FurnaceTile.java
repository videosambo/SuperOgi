package com.superogi.client.tiles;

import java.awt.image.BufferedImage;

import com.superogi.client.renderEngine.graphics.Assets;

public class FurnaceTile extends Tile{

	public FurnaceTile(int id) {
		super(Assets.blockFurnace, id, "Furnace");
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
