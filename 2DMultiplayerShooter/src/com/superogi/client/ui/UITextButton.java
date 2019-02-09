package com.superogi.client.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UITextButton extends UIObject {

	private BufferedImage image;
	private ClickListener clicker;
	private Color color = Color.BLACK;
	private Color hoveringColor = Color.WHITE;
	private String text = "Template";
	private Font font = new Font("Impact", Font.PLAIN, 20);
	private int fontSize = 20;

	public UITextButton(float x, float y, int width, int height, BufferedImage image, ClickListener clicker) {
		super(x, y, width, height);
		this.image = image;
		this.clicker = clicker;
	}
	
	public UITextButton(float x, float y, int width, int height, BufferedImage image, String text, ClickListener clicker) {
		super(x, y, width, height);
		this.image = image;
		this.clicker = clicker;
		this.text = text;
	}

	public UITextButton(float x, float y, int width, int height, BufferedImage image, String text, Color color, ClickListener clicker) {
		super(x, y, width, height);
		this.image = image;
		this.clicker = clicker;
		this.text = text;
		this.color = color;
	}

	public UITextButton(float x, float y, int width, int height, BufferedImage image, String text, Color color, Color hoveringColor, ClickListener clicker) {
		super(x, y, width, height);
		this.image = image;
		this.clicker = clicker;
		this.text = text;
		this.color = color;
		this.hoveringColor = hoveringColor;
	}
	
	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int) x, (int) y, width, height, null);
		g.setFont(font);
		if (hovering) {
			g.setColor(hoveringColor);
			g.drawString(text,(int) x,(int) y);
		} else {
			g.setColor(color);
			g.drawString(text,(int) x,(int) y);
		}
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}
	
	//Getters and setters

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public ClickListener getClicker() {
		return clicker;
	}

	public void setClicker(ClickListener clicker) {
		this.clicker = clicker;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getHoveringColor() {
		return hoveringColor;
	}

	public void setHoveringColor(Color hoveringColor) {
		this.hoveringColor = hoveringColor;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

}
