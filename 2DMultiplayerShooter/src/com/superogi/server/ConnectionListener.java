package com.superogi.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionListener {
	private final NetworkManager man;
	private final ServerSocket server;

	public ConnectionListener(NetworkManager man) {
		this.man = man;
		try {
			server = new ServerSocket();
			server.bind(new InetSocketAddress(man.bindAddress, man.port));
		} catch (Exception e) {
			this.server = null;
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void listenForConnections() {
		while (!server.isClosed() && server.isBound()) {
			// Blocking method
			Socket s = server.accept();
			man.addSocketListener(s);
		}
	}
}
