package com.superogi.client.tiles;

import com.superogi.client.renderEngine.graphics.Assets;

public class OreRubyTile extends Tile {

    public OreRubyTile (int id) {
        super(Assets.blockOreRuby , id, "Ruby ore");
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}