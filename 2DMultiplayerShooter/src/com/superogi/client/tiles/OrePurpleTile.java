package com.superogi.client.tiles;

import com.superogi.client.renderEngine.graphics.Assets;

public class OrePurpleTile extends Tile {

    public OrePurpleTile (int id) {
        super(Assets.blockOrePurple , id, "Purple ore");
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
