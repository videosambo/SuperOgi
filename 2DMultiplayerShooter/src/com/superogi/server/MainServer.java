package com.superogi.server;

import com.superogi.server.network.ServerNetworkManager;

public class MainServer {
	public static void start() {
		System.out.println("Starting server on localhost:25...");

		ServerNetworkManager nm = new ServerNetworkManager("localhost", 1245);
		nm.startListening();

		System.out.println("Started and listening!");
	}
}
