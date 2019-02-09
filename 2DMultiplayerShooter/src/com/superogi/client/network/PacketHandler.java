package com.superogi.client.network;

import java.net.InetAddress;
import java.net.Socket;

public class PacketHandler {
	public void login(String ip, int port) {
		try {
			Socket s = new Socket(InetAddress.getByName(ip), port);
			
		} catch (Exception e) {

		}
	}
}
