package com.superogi.server;

import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ConnectionHandler extends Thread {
	private final Socket socket;
	private BufferedOutputStream bos;
	private ObjectInputStream br;

	public ConnectionHandler(final Socket soc) {
		this.socket = soc;
		try {
			this.bos = new BufferedOutputStream(soc.getOutputStream());
			this.br = new ObjectInputStream(soc.getInputStream());
		} catch (Exception e) {
			System.err.println("Failed to create I/O reading for a socket: " + soc.getInetAddress().toString());
			System.exit(2);
		}
	}

	@Override
	public void run() {
		while (true) {
			// Read incoming data
			try {
				Object obj = br.readObject();
				 
				
				
			} catch (Exception e) {
				System.err.println("Failed to read data from a socket.");
			}
		}
	}

}
