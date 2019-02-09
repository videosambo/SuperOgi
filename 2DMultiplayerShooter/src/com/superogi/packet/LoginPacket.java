package com.superogi.packet;

public class LoginPacket {
	private final String userName;
	private final int cheatKey;

	public LoginPacket(String userName, int cheatKey) {
		this.userName = userName;
		this.cheatKey = cheatKey;
	}

	public String getUserName() {
		return userName;
	}

	public int getCheatKey() {
		return cheatKey;
	}
}
