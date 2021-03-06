package com.superogi.server.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import com.superogi.client.network.LoginPacket;
import com.superogi.packet.LoginResponsePacket;
import com.superogi.packet.Packet;
import com.superogi.packet.ResponsePacket;
import com.superogi.packet.WorldLoadPacket;

public class SingleConnectionHandler extends Thread {
	private final Socket socket;
	private ObjectOutputStream bos;
	private ObjectInputStream br;

	public SingleConnectionHandler(ServerNetworkManager man, final Socket soc) throws IOException {
		this.socket = soc;
		this.bos = new ObjectOutputStream(soc.getOutputStream());
		this.br = new ObjectInputStream(soc.getInputStream());
		System.out.println("New connection from " + socket.getInetAddress().toString() + ":" + socket.getPort());
	}

	@Override
	public void run() {
		while (true) {
			// Read incoming data
			try {
				Object obj = br.readObject();

				if (obj instanceof LoginPacket) {
					long authID = (long) (Math.random() * Long.MAX_VALUE);
					String requestedName = ((LoginPacket) obj).getName();
					sendPacket(new LoginResponsePacket(authID));
					
				} else if (!(obj instanceof Packet)) {
					System.err.println("Invalid packet type: " + obj.getClass().getName());
					continue;
				} else if (obj instanceof WorldLoadPacket) {
					WorldLoadPacket wlp = (WorldLoadPacket) obj;
					String name = wlp.getWorldName();
					long key = wlp.getAuthID();
					
					
				}
			} catch (SocketException e) {
				System.err.println("Socket closed.");
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				return;
			} catch (Exception e) {
				System.err.println("Failed to read data from a socket.");
				return;
			}
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void sendPacket(ResponsePacket packet) {
		try {
			this.bos.writeObject(packet);
			this.bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
