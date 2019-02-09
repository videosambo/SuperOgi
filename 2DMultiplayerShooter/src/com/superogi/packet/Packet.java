package com.superogi.packet;

import java.io.Serializable;

public abstract class Packet implements Serializable {
	private static final long serialVersionUID = 9048067052928705147L;
	private final long authID;

	public Packet(long authID) {
		this.authID = authID;
	}

	public long getAuthID() {
		return this.authID;
	}

}
