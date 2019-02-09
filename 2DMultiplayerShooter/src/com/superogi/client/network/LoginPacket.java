package com.superogi.client.network;

public class LoginPacket {
	
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
