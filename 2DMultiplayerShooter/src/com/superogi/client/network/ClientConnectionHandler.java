package com.superogi.client.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.superogi.client.GameHandler;
import com.superogi.packet.LoginResponsePacket;
import com.superogi.packet.Packet;
import com.superogi.packet.PingResponsePacket;
import com.superogi.packet.ResponsePacket;
import com.superogi.packet.WorldLoadResponsePacket;

public class ClientConnectionHandler {
	private final ObjectOutputStream oos;
	private final ObjectInputStream ois;
	private final PacketHandler ph;
	private final GameHandler handler;

	public ClientConnectionHandler(PacketHandler ph, Socket s, GameHandler handler) throws IOException {
		this.ph = ph;
		this.handler = handler;
		this.oos = new ObjectOutputStream(s.getOutputStream());
		this.ois = new ObjectInputStream(s.getInputStream());
	}

	public void sendPacket(Packet packet) {
		try {
			oos.writeObject(packet);
			oos.flush();
		} catch (Exception e) {
			System.err.println("Failed to send a packet: " + packet.getClass().getName());
			e.printStackTrace();
		}
	}

	public void listen() {
		try {
			Object obj;
			while ((obj = ois.readObject()) != null) {
				if (!(obj instanceof ResponsePacket))
					continue;
				else if (obj instanceof LoginResponsePacket) {
					LoginResponsePacket lrp = (LoginResponsePacket) obj;
					long authID = lrp.getAuthID();
					System.out.println("AuthID: " + authID);
					// TODO: Store it
				} else if (obj instanceof WorldLoadResponsePacket) {

				} else if (obj instanceof PingResponsePacket) {
					PingResponsePacket prp = (PingResponsePacket) obj;

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
			oos.writeObject(lp);
			oos.flush();
		} catch (Exception e) {
			System.err.println("Failed to send a packet: " + lp.getClass().getName());
			e.printStackTrace();
		}
	}
}
