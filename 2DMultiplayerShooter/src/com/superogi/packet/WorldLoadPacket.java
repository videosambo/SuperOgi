package com.superogi.packet;

public class WorldLoadPacket extends Packet {
	private String worldName;

	public WorldLoadPacket(long authID, String worldName) {
		super(authID);
		this.worldName = worldName;
	}

	public WorldLoadPacket(long authID) {
		super(authID);
	}

	public String getWorldName() {
		return worldName;
	}

}
