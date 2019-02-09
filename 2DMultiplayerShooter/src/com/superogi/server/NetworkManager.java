package com.superogi.server;

public class NetworkManager {

	private Thread networkThread;

	public void NetworkManager() {
		this.networkThread = new Thread(() -> {
			loop();
		});
	}

	private void loop() {
		
	}

	public void startListening() {
		new Thread
	}
}
