package com.superogi.client.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.superogi.packet.Packet;
import com.superogi.packet.ResponsePacket;

public class ClientConnectionHandler {
	private final ObjectOutputStream oos;
	private final ObjectInputStream ois;
	private final PacketHandler ph;

	public ClientConnectionHandler(PacketHandler ph, Socket s) throws IOException {
		this.ph = ph;
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
				if (obj instanceof ResponsePacket)
					continue;
			}
		} catch (Exception e) {
			System.err.println("Exception when listening to packets.");
			e.printStackTrace();
		}
	}
}
