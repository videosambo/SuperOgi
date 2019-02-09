package com.superogi.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.superogi.server.network.ServerNetworkManager;
import com.superogi.server.network.SingleConnectionHandler;

public class MainServer {
	
	public static int port = 25560;
	
	public static void start() throws IOException {
		
		boolean resolved = false;
		
		String host = InetAddress.getLocalHost().getHostAddress();
		
		ServerNetworkManager nm = new ServerNetworkManager();
		System.out.println("Starting server on " + host +":" + port);
		
		
		

		try (ServerSocket server = new ServerSocket(port)) {
			Thread tickerThread = new Thread(() -> {
				while (true) {
					nm.handleQueuedPackets();
					try {
						Thread.sleep(1000 / 60);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, "tickerThread");
			tickerThread.start();
			System.out.println("Started and listening!");
			System.out.println("Starting tickthread.");
			Thread socketListener = new Thread(() -> {
				while (!server.isClosed() && server.isBound()) {
					// Blocking method
					try {
						Socket s = server.accept();
						nm.addSocketHandler(new SingleConnectionHandler(nm, s));
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(4);
					}
				}
			}, "socketListener");
			socketListener.start();
			System.out.println("Started!");
		}
	}
}
