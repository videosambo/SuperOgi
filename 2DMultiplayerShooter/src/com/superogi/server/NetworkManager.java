package com.superogi.server;

import java.util.HashSet;
import java.util.Set;

import com.superogi.packet.Packet;
import com.superogi.packet.PingPacket;

public class NetworkManager {

	private final Set<SingleConnectionHandler> HANDLERS = new HashSet<>();

	private final Thread networkThread;
	public final String bindAddress;
	public final int port;

	// Packets
	private final Set<Packet> incomingPackets = new HashSet<>();

	public NetworkManager(String ip, int port) {
		this.bindAddress = ip;
		this.port = port;
		this.networkThread = new Thread(() -> {
			loop();
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
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
		for (Packet p : incomingPackets) {
			if (p instanceof PingPacket) {

			}
		}
	}

	public void startListening() {
		networkThread.start();
	}

	public Set<Packet> getIncomingPackets() {
		return incomingPackets;
	}

	public void addSocketHandler(final SingleConnectionHandler connectionHandler) {
		this.HANDLERS.add(connectionHandler);
	}
}
