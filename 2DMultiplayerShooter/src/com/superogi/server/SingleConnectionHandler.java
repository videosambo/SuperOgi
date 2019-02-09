package com.superogi.server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.superogi.packet.Packet;

public class SingleConnectionHandler extends Thread {
	private final Socket socket;
	private final NetworkManager man;
	private BufferedOutputStream bos;
	private ObjectInputStream br;

	public SingleConnectionHandler(NetworkManager man, final Socket soc) throws IOException {
		this.socket = soc;
		this.bos = new BufferedOutputStream(soc.getOutputStream());
		this.br = new ObjectInputStream(soc.getInputStream());
		this.man = man;
	}

	@Override
	public void run() {
		while (true) {
			// Read incoming data
			try {
				Object obj = br.readObject();
				if (!(obj instanceof Packet)) {
					System.err.println("Invalid packet type: " + obj.getClass().getName());
					continue;
				}

			} catch (Exception e) {
				System.err.println("Failed to read data from a socket.");
			}
		}
	}

	public Socket getSocket() {
		return socket;
	}

}
