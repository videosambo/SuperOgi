package com.superogi.client.network;

public class ServerConnector {

	private String ip, port;

	private ClientConnectionHandler cch;

	public ServerConnector(ClientConnectionHandler cch, String ip, String port) {
		this.cch = cch;
		this.ip = ip;
		this.port = port;
	}

	public void sendLoginPacket(String name) {
		LoginPacket lp = new LoginPacket(name);
		cch.sendLogicPacket(lp);
	}

}
