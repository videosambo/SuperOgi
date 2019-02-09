package com.superogi.client;

/*
 * @author videosambo
 * Yes, I know, this is very copied CodeNMore's tutorial series. 
 * But I have to use something as a engine, I do have skill to make own engine,
 * but I'm too lazy to do that. Forgive me, if you are reading from github.
 * Even if I had to code this game, it's not mine, idea is my friends and I'm helping him.
 * Fun fact, I do know how to make 3D game engines with OpenGL but I didn't know how to make 1D engine like this.
 */


public class Launcher {

	public static void main(String[] args) {
		
		Game game = new Game(1280, 720, "1D Game test");
		game.start();
		
	}

}
