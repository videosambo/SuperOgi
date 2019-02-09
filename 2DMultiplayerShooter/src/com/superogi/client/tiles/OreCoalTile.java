package com.superogi.client.tiles;

import com.superogi.client.renderEngine.graphics.Assets;

public class OreCoalTile extends Tile {

    public OreCoalTile(int id) {
        super(Assets.blockOreCoal, id, "Coal ore");
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}