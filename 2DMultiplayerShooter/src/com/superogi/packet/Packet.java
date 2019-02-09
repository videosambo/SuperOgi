package com.superogi.packet;

public abstract class Packet {
	private final long authID;

	public Packet(long authID) {
		this.authID = authID;
	}

	public long getAuthID() {
		return this.authID;
	}

}
