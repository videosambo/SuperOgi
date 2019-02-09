package com.superogi.packet;

public class PingResponsePacket extends ResponsePacket {

	private int pingID;

	public PingResponsePacket(int pingID) {
		this.pingID = pingID;
	}

	public int pingID() {
		return pingID;
	}

}
