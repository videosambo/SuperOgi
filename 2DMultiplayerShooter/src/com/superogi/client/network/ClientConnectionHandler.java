package com.superogi.client.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.superogi.client.GameHandler;
import com.superogi.packet.LoginResponsePacket;
import com.superogi.packet.Packet;
import com.superogi.packet.PingResponsePacket;
import com.superogi.packet.ResponsePacket;
import com.superogi.packet.WorldLoadResponsePacket;

public class ClientConnectionHandler {
	private final GameHandler handler;

	private Connection connection;

	public ClientConnectionHandler(GameHandler handler) {
		this.handler = handler;
	}

	public void sendPacket(Packet packet) {
		try {
			connection.getOutput().writeObject(packet);
			connection.getOutput().flush();
		} catch (Exception e) {
			System.err.println("Failed to send a packet: " + packet.getClass().getName());
			e.printStackTrace();
		}
	}

	public void listen() {
		try {
			Object obj;
			while ((obj = connection.getInput().readObject()) != null) {
				if (!(obj instanceof ResponsePacket))
					continue;
				else if (obj instanceof LoginResponsePacket) {
					LoginResponsePacket lrp = (LoginResponsePacket) obj;
					long authID = lrp.getAuthID();
					System.out.println("AuthID: " + authID);
					handler.setAuthID(authID);
				} else if (obj instanceof WorldLoadResponsePacket) {

				} else if (obj instanceof PingResponsePacket) {
					PingResponsePacket prp = (PingResponsePacket) obj;
					handler.getPingHandler().returnPing(prp.pingID());
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

	public void sendLogicPacket(LoginPacket lp) {
		try {
			connection.getOutput().writeObject(lp);
			connection.getOutput().flush();
		} catch (Exception e) {
			System.err.println("Failed to send a packet: " + lp.getClass().getName());
			e.printStackTrace();
		}
	}

	public void connect(String ip, int port) throws UnknownHostException, IOException {
		System.out.println("Connecting to " + ip + ":" + port);
		this.connection = new Connection(new Socket(ip, port));
		System.out.println("Connected to server " + ip + "!");
	}

}
