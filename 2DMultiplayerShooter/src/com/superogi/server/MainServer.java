package com.superogi.server;

import com.superogi.server.network.ServerNetworkManager;

public class MainServer {
	public static void start() {

		String ip = "localhost";
		int port = 25;
		
		ServerNetworkManager nm = new ServerNetworkManager(ip, port);
		
		System.out.println("Started server on " + ip + ":" + port);
		
		
		nm.startListening();

		System.out.println("Started and listening!");
	}
}
