package com.superogi.client.tiles;

import com.superogi.client.renderEngine.graphics.Assets;

public class OreIronTile extends Tile {

    public OreIronTile(int id) {
        super(Assets.blockOreIron, id, "Iron ore");
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
