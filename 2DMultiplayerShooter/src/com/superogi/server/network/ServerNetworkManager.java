package com.superogi.server.network;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import com.superogi.packet.ChangePositionPacket;
import com.superogi.packet.ChangePositionResponsePacket;
import com.superogi.packet.Packet;
import com.superogi.packet.PingPacket;
import com.superogi.packet.PingResponsePacket;
import com.superogi.server.ServerClient;

public class ServerNetworkManager {

	private final HashMap<ServerClient, HashSet<Packet>> incomingPackets = new HashMap<>();
	private final Set<SingleConnectionHandler> HANDLERS = new HashSet<>();

	public void handleQueuedPackets() {
		for (Entry<ServerClient, HashSet<Packet>> entry : incomingPackets.entrySet()) {
			for (Packet packet : entry.getValue()) {
				processPacket(entry.getKey(), packet);
			}
		}
		incomingPackets.clear();
	}

	private void processPacket(ServerClient client, Packet packet) {
		if (packet instanceof PingPacket) {
			PingPacket pp = (PingPacket) packet;
			client.getConnectionHandler().sendPacket(new PingResponsePacket(pp.getPingID()));
		} else if (packet instanceof ChangePositionPacket) {
			// TODO: Check for illegal moves
			ChangePositionPacket p = (ChangePositionPacket) packet;
			float approvedX = p.getNewX();
			float approvedY = p.getNewY();
			client.getConnectionHandler().sendPacket(new ChangePositionResponsePacket(approvedX, approvedY));
		}
	}

	public void addSocketHandler(final SingleConnectionHandler connectionHandler) {
		this.HANDLERS.add(connectionHandler);
	}
}
