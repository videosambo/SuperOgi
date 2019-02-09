package com.superogi.packet;

public class ChangePositionPacket extends Packet {

	private float x, y;

	public ChangePositionPacket(long authID, float newX, float newY) {
		super(authID);
		this.x = newX;
		this.y = newY;
	}

	public float getNewX() {
		return x;
	}

	public float getNewY() {
		return y;
	}
}
