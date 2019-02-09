package com.superogi.server.network;

import com.superogi.packet.PingResponsePacket;
import com.superogi.server.ServerPlayer;

public class PacketHandler {

	public void handlePingPacket(ServerPlayer c, int pingID) {
		c.getConnectionHandler().sendPacket(new PingResponsePacket(pingID));
	}

	public void handleLoginPacket(ServerPlayer c) {

	}
}
