package com.superogi.client.entities.statics;

import com.superogi.client.GameHandler;
import com.superogi.client.entities.Entity;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(GameHandler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
