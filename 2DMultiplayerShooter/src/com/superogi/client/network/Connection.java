package com.superogi.client.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {
	private final Socket socket;
	private final ObjectInputStream ois;
	private final ObjectOutputStream oos;

	public Connection(Socket s) throws IOException {
		this.socket = s;
		this.oos = new ObjectOutputStream(s.getOutputStream());
		this.ois = new ObjectInputStream(s.getInputStream());
	}

	public Socket getSocket() {
		return socket;
	}

	public ObjectOutputStream getOutput() {
		return oos;
	}

	public ObjectInputStream getInput() {
		return ois;
	}
}