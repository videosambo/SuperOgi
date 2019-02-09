package com.superogi.packet;

public class ChangePositionResponsePacket extends ResponsePacket {
	private float x, y;

	public ChangePositionResponsePacket(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
}
