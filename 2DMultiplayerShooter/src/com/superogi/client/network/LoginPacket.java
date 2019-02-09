package com.superogi.client.network;

import java.io.Serializable;

public class LoginPacket implements Serializable {
	private static final long serialVersionUID = 8662019730581869936L;
	private String name;
	private long cheatId;

	public LoginPacket(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCheatId() {
		return cheatId;
	}

	public void setCheatId(long cheatId) {
		this.cheatId = cheatId;
	}

}
