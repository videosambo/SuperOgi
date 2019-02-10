package com.superogi.client.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import com.superogi.client.GameHandler;
import com.superogi.client.states.GameState;
import com.superogi.client.states.MenuState;
import com.superogi.client.states.State;
import com.superogi.packet.LoginResponsePacket;
import com.superogi.packet.PingResponsePacket;
import com.superogi.packet.ResponsePacket;
import com.superogi.packet.WorldLoadPacket;
import com.superogi.packet.WorldLoadResponsePacket;

public class ClientConnectionHandler {
	private final GameHandler handler;

	private Connection connection;
	private final Set<Object> packetQueue = new HashSet<>();

	public ClientConnectionHandler(GameHandler handler) {
		this.handler = handler;
	}

	public void queuePacket(Object obj) {
		this.packetQueue.add(obj);
	}

	public void clearQueue() {
		if (connection == null)
			return;
		try {
			for (Object packet : packetQueue) {
				connection.getOutput().writeObject(packet);
				System.out.println("Sent packet: " + packet.getClass().getName());
			}
			connection.getOutput().flush();
			packetQueue.clear();
		} catch (Exception e) {
			System.err.println("Failed to send a packet.");
			e.printStackTrace();
		}
	}

	public void listen() {
		try {
			Object obj;
			while ((obj = connection.getInput().readObject()) != null) {
				System.out.println("Got response: " + obj.getClass().getName());
				if (!(obj instanceof ResponsePacket))
					continue;
				else if (obj instanceof LoginResponsePacket) {
					LoginResponsePacket lrp = (LoginResponsePacket) obj;
					long authID = lrp.getAuthID();
					System.out.println("AuthID: " + authID);
					handler.setAuthID(authID);
					
					//sankon muutoksia.
					MenuState ms = new MenuState(handler);
					State.setState(new GameState(handler));
					ms.deleteMenu();
					this.queuePacket(new WorldLoadPacket(authID));
					
				} else if (obj instanceof WorldLoadResponsePacket) {

				} else if (obj instanceof PingResponsePacket) {
					PingResponsePacket prp = (PingResponsePacket) obj;
					handler.getPingHandler().returnPing(prp.pingID());
				} else {
					System.err.println("Packet not parsed: " + obj.getClass().getName());
				}
			}
		} catch (Exception e) {
			System.err.println("Exception when listening to packets.");
			e.printStackTrace();
		}
	}

	public GameHandler getGameHandler() {
		return handler;
	}

	public void connect(String ip, int port) throws UnknownHostException, IOException {
		System.out.println("Connecting to " + ip + ":" + port);
		this.connection = new Connection(new Socket(ip, port));
		System.out.println("Connected to server " + ip + "!");
		new Thread(() -> {
			listen();
		}).start();
	}

}
