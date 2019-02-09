package com.superogi.client;

import com.superogi.client.input.KeyManager;
import com.superogi.client.input.MouseManager;
import com.superogi.client.network.ClientConnectionHandler;
import com.superogi.client.renderEngine.graphics.GameCamera;
import com.superogi.client.worlds.World;
import com.superogi.server.network.PacketHandler;

public class GameHandler {

	private Game game;
	private World world;
	private PingHandler pingHandler;
	private long authID;
	private ClientConnectionHandler cch;

	public long getAuthID() {
		return authID;
	}

	public GameHandler(Game game, ClientConnectionHandler cch) {
		this.cch = cch;
		this.game = game;
	}

	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	public int getWidth() {
		return game.getLeveys();
	}

	public int getHeight() {
		return game.getKorkeus();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public PingHandler getPingHandler() {
		return pingHandler;
	}

	public ClientConnectionHandler getClientConnectionHandler() {
		return cch;
	}

	public void setAuthID(long authID) {
		this.authID = authID;
	}

}
