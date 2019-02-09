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

	private final Thread networkThread;
	public final String bindAddress;
	public final int port;

	public ServerNetworkManager(String ip, int port) {
		this.bindAddress = ip;
		this.port = port;
		this.networkThread = new Thread(() -> {
			while (true) {
				loop();
				try {
					Thread.sleep(1000 / 60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "networkThread");
	}

	/**
	 * Loops 60 times per second
	 */
	private void loop() {
		this.handleQueuedPackets();
	}

	private void handleQueuedPackets() {
		for (Entry<ServerClient, HashSet<Packet>> entry : incomingPackets.entrySet()) {
			for (Packet packet : entry.getValue()) {
				processPacket(entry.getKey(), packet);
			}
		}
		incomingPackets.clear();
	}

	private void processPacket(ServerClient client, Packet packet) {
		if (packet instanceof PingPacket) {
			client.getConnectionHandler().sendPacket(new PingResponsePacket());
		} else if (packet instanceof ChangePositionPacket) {
			// TODO: Check for illegal moves
			client.getConnectionHandler().sendPacket(new ChangePositionResponsePacket);;
		}
	}

	public void startListening() {
		networkThread.start();
	}

	public void addSocketHandler(final SingleConnectionHandler connectionHandler) {
		this.HANDLERS.add(connectionHandler);
	}
}
