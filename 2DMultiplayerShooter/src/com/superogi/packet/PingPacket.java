package com.superogi.packet;

public class PingPacket extends Packet {
	private int pingID;

	
	public PingPacket(long authID, int pingID) {
		super(authID);
		this.pingID = pingID;
	}

	public int getPingID() {
		return this.pingID;
	}

}
