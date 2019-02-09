package com.superogi.server;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.superogi.server.network.ServerNetworkManager;

public class MainServer {
	
	public static String ip = "localhost";
	public static int port = 25;
		
	public static void start() {
		
		String host = null;
		boolean bindet = false;
		
		try {
			host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.err.println("Cannot resolve local ip address");
			bindet = true;
			e.printStackTrace();
		}

		ServerNetworkManager nm = new ServerNetworkManager(ip, port);
		
		System.out.println("Started server on " + (bindet ? ip : host) + ":" + port);
		
		
		nm.startListening();

		System.out.println("Started and listening!");
	}
}
