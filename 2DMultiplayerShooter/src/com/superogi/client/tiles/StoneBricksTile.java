package com.superogi.client.tiles;

import com.superogi.client.renderEngine.graphics.Assets;

public class StoneBricksTile extends Tile {

    public StoneBricksTile (int id) {
        super(Assets.blockStoneBricks , id, "Stonebricks");
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
