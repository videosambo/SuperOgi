package com.superogi.packet;

public class WorldLoadResponsePacket extends ResponsePacket {
	private int spawnX, spawnY;
	private int dimX, dimY;

	private int[][] mapData;

	public WorldLoadResponsePacket(int spawnX, int spawnY, int dimX, int dimY, int[][] mapData) {
		this.spawnX = spawnX;
		this.spawnY = spawnY;
		this.dimX = dimX;
		this.dimY = dimY;
		this.mapData = mapData;
	}

	private int[][] getMapData() {
		return mapData;
	}
}
