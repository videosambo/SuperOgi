package com.superogi.client.tiles;

import com.superogi.client.renderEngine.graphics.Assets;

public class OreGoldTile extends Tile {

    public OreGoldTile(int id) {
        super(Assets.blockOreGold, id, "Gold ore");
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}