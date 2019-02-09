package com.superogi.client.tiles;

import com.superogi.client.renderEngine.graphics.Assets;

public class SmoothStoneTile extends Tile {

    public SmoothStoneTile (int id) {
        super(Assets.blockSmoothStone , id, "Smooth stone");
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
