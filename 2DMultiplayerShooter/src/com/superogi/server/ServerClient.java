package com.superogi.server;

import com.superogi.server.network.SingleConnectionHandler;

public class ServerClient {
	private SingleConnectionHandler connectionHandler;

	public ServerClient(SingleConnectionHandler sch) {

	}

	public SingleConnectionHandler getConnectionHandler() {
		return connectionHandler;
	}
}
