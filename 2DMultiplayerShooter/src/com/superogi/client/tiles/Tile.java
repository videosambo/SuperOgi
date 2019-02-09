package com.superogi.client.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.superogi.client.Game;

public class Tile {
	
	//tärkeät
	
	public static Tile[] tiles = new Tile[256];
	
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile stoneTile = new StoneTile(2);
	public static Tile sandTile = new SandTile(3);
	public static Tile oreCoalTile = new OreCoalTile(4);
	public static Tile oreIronTile = new OreIronTile(5);
	public static Tile oreGoldTile = new OreGoldTile(6);
	public static Tile oreDiamondTile = new OreDiamondTile(7);
	public static Tile oreRubyTile = new OreRubyTile(8);
	public static Tile orePurpleTile = new OrePurpleTile(9);
	public static Tile furnace = new FurnaceTile(10);
	public static Tile waterTile = new WaterTile(16);
	
	
	//luokat
	
	public static final int TILE_DIMENSION = Game.zoom; //100
	public static final int TILE_WIDTH = 100; //16
	public static final int TILE_HEIGHT = 100; //16
	public static final int TILE_HEALTH = 50; //50
	
	protected BufferedImage texture;
	protected final int id;
	protected final String name;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		this.name = null;
		
		tiles[id] = this;
	}
	
	public Tile(BufferedImage texture, int id, String name) {
		this.texture = texture;
		this.id = id;
		this.name = name;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_DIMENSION, TILE_DIMENSION, null);
	}
	
	public boolean isSolid() {
		return false;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

}
