package com.superogi.server.network;

import com.superogi.packet.PingResponsePacket;
import com.superogi.server.ServerClient;

public class PacketHandler {

	public void handlePingPacket(ServerClient c, long pingID) {
		c.getConnectionHandler().sendPacket(new PingResponsePacket());
	}
}
