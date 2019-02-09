package com.superogi.server;

import com.superogi.server.network.SingleConnectionHandler;

public class ServerPlayer {
	private SingleConnectionHandler sch;
	private String name;

	public ServerPlayer(SingleConnectionHandler sch) {
		this.sch = sch;
	}

	public SingleConnectionHandler getConnectionHandler() {
		return sch;
	}

	public String getName() {
		return name;
	}
}
