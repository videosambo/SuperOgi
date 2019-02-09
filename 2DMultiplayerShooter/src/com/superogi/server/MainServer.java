package com.superogi.server;

import com.superogi.server.network.ServerNetworkManager;

public class MainServer {
	public static void main(String[] args) {
		ServerNetworkManager nm = new ServerNetworkManager("localhost", 1245);
		nm.startListening();
	}
}
