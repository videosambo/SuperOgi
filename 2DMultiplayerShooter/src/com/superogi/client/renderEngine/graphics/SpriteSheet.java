package com.superogi.client.renderEngine.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int leveys, int korkeus) {
		return sheet.getSubimage(x, y, leveys, korkeus); 
	}
	
	public BufferedImage crop(int x, int y, int leveys, int korkeus, BufferedImage sheet) {
		return sheet.getSubimage(x, y, leveys, korkeus); 
	}
	
	public BufferedImage crop16(int idX, int idY) {
		return sheet.getSubimage(idX * 16 + idX, idY * 16 + idY, 16, 16);
	}
	
	public BufferedImage crop16(int idX, int idY, BufferedImage sheet) {
		return sheet.getSubimage(idX * 16 + idX, idY * 16 + idY, 16, 16);
	}
	
	public int getImageHeight() {
		int korkeus = sheet.getHeight();
		return korkeus;
	}
	
	public int getImageWidth() {
		int leveys = sheet.getWidth();
		return leveys;
	}

}
