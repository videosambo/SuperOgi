package com.superogi.client;

import java.util.HashMap;

import com.superogi.client.network.ClientConnectionHandler;
import com.superogi.packet.PingPacket;

public class PingHandler {
	private final HashMap<Integer, Long> sentPings = new HashMap<>();
	private final ClientConnectionHandler conHandler;

	private int lastPing;

	public PingHandler(ClientConnectionHandler conHandler) {
		this.conHandler = conHandler;
		lastPing = -1;
	}

	public int getLastPing() {
		return lastPing;
	}

	public void sendPing() {
		conHandler.sendPacket(new PingPacket(conHandler.getGameHandler().getAuthID()));
	}

	public void returnPing(int pingID) {
		if (sentPings.containsKey(pingID)) {
			System.err.println("Server sent an unlogged ping response with ID: " + pingID);
		} else {
			long sentTime = sentPings.get(pingID);
			lastPing = (int) ((System.nanoTime() - sentTime) / 1E9);
		}
	}
}
