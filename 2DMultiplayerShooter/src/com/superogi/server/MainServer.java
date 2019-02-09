package com.superogi.server;

public class MainServer {
	public static void main(String[] args) {
		NetworkManager nm = new NetworkManager();
		
		nm.startListening("localhost", 1245);
	}
}
