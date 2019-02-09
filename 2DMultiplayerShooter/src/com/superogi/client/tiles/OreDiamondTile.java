package com.superogi.client.tiles;

import com.superogi.client.renderEngine.graphics.Assets;

public class OreDiamondTile extends Tile {

    public OreDiamondTile (int id) {
        super(Assets.blockOreDiamond , id, "Diamond ore");
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
