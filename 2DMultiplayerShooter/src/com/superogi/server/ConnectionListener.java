package com.superogi.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionListener {
	private final NetworkManager man;
	private final ServerSocket server;

	public ConnectionListener(NetworkManager man) throws IOException {
		this.man = man;
		server = new ServerSocket();
		server.bind(new InetSocketAddress(man.bindAddress, man.port));
	}

	public void listenForConnections() {
		while (!server.isClosed() && server.isBound()) {
			// Blocking method
			try {
				Socket s = server.accept();
				man.addSocketHandler(new SingleConnectionHandler(man, s));
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(4);
			}
		}
	}
}
