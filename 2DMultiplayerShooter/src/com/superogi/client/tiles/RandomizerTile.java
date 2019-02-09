package com.superogi.client.tiles;

import java.awt.image.BufferedImage;

import com.superogi.client.renderEngine.graphics.Assets;

public class RandomizerTile extends Tile {

	public RandomizerTile(int id) {
		super(Assets.blockRandomizer, id, "Randomizer");
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
