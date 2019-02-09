package com.superogi.client.worlds;

import java.awt.Graphics;
import java.util.Random;

import com.superogi.client.GameHandler;
import com.superogi.client.entities.EntityManager;
import com.superogi.client.entities.creatures.Player;
import com.superogi.client.entities.statics.Tree;
import com.superogi.client.items.ItemManager;
import com.superogi.client.tiles.Tile;
import com.superogi.client.utils.SimplexNoise;
import com.superogi.client.utils.Utils;

public class World {

	private GameHandler handler;
	private Random random = new Random();
	private SimplexNoise noise = new SimplexNoise(0);
	private int width, height;
	public int spawnX, spawnY;
	private int[][] tiles;
	private EntityManager entityManager;
	private ItemManager itemManager;

	public World(GameHandler handler) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 0, 0));
		itemManager = new ItemManager(handler);
		entityManager.getPlayer().setX(spawnX * Tile.TILE_DIMENSION);
		entityManager.getPlayer().setY(spawnY * Tile.TILE_DIMENSION);
	}

	public World(GameHandler handler, String path) {
		this.handler = handler;
		itemManager = new ItemManager(handler);
		entityManager = new EntityManager(handler, new Player(handler, 0, 0));
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX * Tile.TILE_DIMENSION);
		entityManager.getPlayer().setY(spawnY * Tile.TILE_DIMENSION);
	}

	public World(GameHandler handler, int width, int height) {
		this.handler = handler;
		itemManager = new ItemManager(handler);
		entityManager = new EntityManager(handler, new Player(handler, 0, 0));
		generateWorld(width, height);
		
		entityManager.getPlayer().setX(spawnX * Tile.TILE_DIMENSION);
		entityManager.getPlayer().setY(spawnY * Tile.TILE_DIMENSION);
	}

	public void tick() {
		itemManager.tick();
		entityManager.tick();
	}

	public void render(Graphics g) {

		
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_DIMENSION);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_DIMENSION + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_DIMENSION);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_DIMENSION + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_DIMENSION - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_DIMENSION - handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.render(g);
		entityManager.render(g);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.dirtTile;
		return t;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
				// System.out.print(getTile(x, y).getId() + " ");
			}
			// System.out.println("");
		}

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private void generateWorld(int width, int height) {

		this.width = width;
		this.height = height;

		spawnX = width / 2;
		spawnY = height / 2;

		tiles = new int[width][height];
		double[][] elevation = new double[width][height];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				double nx = x / width - 0.5, ny = y / height - 0.5;
				/*
				 * double e = 1 * noise.noise(1 * x, 1 * y) + 0.5 * noise.noise(2 * x, 2 * y) +
				 * 0.25 * noise.noise(4 * x, 4 * y);
				 */

				// elevation[x][y] = Math.pow(e, 0.70);
				// elevation[x][y] = e;
				elevation[x][y] = noise.noise(0.06 * x, 0.06 * y);

				// random maaston palikat

				if (elevation[x][y] > 0.5) {
					tiles[x][y] = 16; // vesi
				} else if (elevation[x][y] > 0.3) {
					tiles[x][y] = 3; // sandi
				} else if (elevation[x][y] > -0.3) {
					tiles[x][y] = 0; // dirtti
				} else {
					tiles[x][y] = 2; // kivi
				}
				// System.out.print(elevation[x][y] + " ");
				// System.out.print(getTile(x, y).getId() + " ");
			}
			// System.out.println("");
		}

		// oret

		for (int i = 0; i < (height * width) / 10; i++) {
			int x = random.nextInt((int) width);
			int y = random.nextInt((int) height);
			if (getTile(x, y).equals(Tile.stoneTile)) {
				tiles[x][y] = 4;
			}
		}
		
		//puut
		
		for (int i = 0; i < (height * width) / 10; i++) {
			int x = random.nextInt((int) width);
			int y = random.nextInt((int) height);
			if (getTile(x, y).equals(Tile.grassTile)) {
				entityManager.addEntity(new Tree(handler, x * Tile.TILE_DIMENSION, y * Tile.TILE_DIMENSION));
			}
		}

		int xOffset = 0;
		
		while (getTile(width / 2 + xOffset, height / 2).isSolid() || getTile(width / 2 + xOffset, height / 2).equals(Tile.waterTile)) {
			xOffset += 1;
		}

		spawnX = (width / 2) + xOffset;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public GameHandler getHandler() {
		return handler;
	}

	public void setHandler(GameHandler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

}
