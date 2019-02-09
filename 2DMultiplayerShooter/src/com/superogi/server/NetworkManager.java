package com.superogi.server;

import java.util.HashSet;
import java.util.Set;

import com.superogi.packet.Packet;

public class NetworkManager {

	private final Thread networkThread;
	public final String IP;
	public final int port;

	// Packets
	private final Set<Packet> incomingPackets = new HashSet<>();

	public void NetworkManager(String ip, int port) {
		this.IP = ip;
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

	}

	public void startListening() {
		networkThread.start();
	}
}
