package com.superogi.client.renderEngine.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadImage(String path) {
		
		File f = new File(path);
		if (!f.exists()) {
			System.err.println("Cannot found image at " + path);
			System.exit(1);
		}
		
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			System.err.println("Kuvaa ladatessa tapahtui virhe");
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}
