package com.superogi.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.superogi.server.network.ServerNetworkManager;
import com.superogi.server.network.SingleConnectionHandler;

public class MainServer {

	public static final int DEFAULT_PORT = 25560;

	public static void start() throws IOException {
		ServerNetworkManager nm = new ServerNetworkManager();
		System.out.println("Starting server on localhost:" + DEFAULT_PORT);

		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(DEFAULT_PORT);
		Thread tickerThread = new Thread(() -> {
			while (true) {
				nm.handleQueuedPackets();
				try {
					Thread.sleep(1000 / 60);
				} catch (InterruptedException e) {
				}
			}
		}, "tickerThread");
		tickerThread.start();
		System.out.println("Started and listening!");
		System.out.println("Starting tickthread.");
		Thread socketListener = new Thread(() -> {
			while (true) {
				// Blocking method
				System.out.println("Dab");
				try {
					Socket s = server.accept();
					System.out.println("Dab2");
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
