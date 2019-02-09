package com.superogi.packet;

public class WorldLoadResponsePacket extends ResponsePacket {
	private final int spawnX, spawnY;
	private final int dimX, dimY;

	private final int[][] mapData;

	public WorldLoadResponsePacket(int spawnX, int spawnY, int dimX, int dimY, int[][] mapData) {
		this.spawnX = spawnX;
		this.spawnY = spawnY;
		this.dimX = dimX;
		this.dimY = dimY;
		this.mapData = mapData;
	}

	public int[][] getMapData() {
		return mapData;
	}

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public int getDimX() {
		return dimX;
	}

	public int getDimY() {
		return dimY;
	}

}
