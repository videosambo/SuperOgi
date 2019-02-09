package com.superogi.packet;

public class LoginResponsePacket extends ResponsePacket {
	private final long authID;

	public LoginResponsePacket(long authID) {
		this.authID = authID;
	}

	public long getAuthID() {
		return authID;
	}
}
