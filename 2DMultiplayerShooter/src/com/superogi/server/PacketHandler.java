package com.superogi.server;

import com.superogi.packet.PingPacket;

public class PacketHandler {

	public void handlePingPacket(Client c, long pingID) {
		c.sendPacket(new PingResponsePacket());
	}
}
