package com.superogi.client.renderEngine.graphics;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Assets {

	// spritesheet1
	// texturet
	public static BufferedImage playerIdle, playerMove1, playerMove2, playerDamage, playerBackIdle, playerBackMove1,
			playerBackMove2, playerBackDamage, playerSideIdle, playerSideMove, playerSideDamage, playerBoat,
			playerBackBoat, playerLeftBoat, playerRightBoat, fullHeart, halfHeart, heart, head, body, leggins, headArmor, bodyArmor,
			legginsArmor, inventorySlot, itemDebug, sword, bow, itemStoneAxe, itemStoneShowel, itemStonePickaxe,
			itemStoneSword, itemStoneClub, itemGoldSword, itemBrokenGoldSword1, itemBrokenGoldSword2, itemTriden,
			itemIronAxe, itemIronShowel, itemIronPickaxe, itemIronSword, itemIronClub, itemBetterAxe, itemStick,
			itemTorch, itemBurnedTorch, itemBomb, itemFish, mobTest, itemOreIron, itemOreGold, itemOreCoal,
			itemOreDiamond, itemOreRuby, itemOrePurple, itemBetterGoldSword, itemBow, itemPurpleBow, headGoldArmor,
			bodyGoldArmor, legginsGoldArmor, blockStone, blockOreIron, blockOreGold, blockOreCoal, blockOreDiamond,
			blockOreRuby, blockOrePurple, blockStoneBricks, blockSmoothStone, blockFurnace, blockChest, blockRandomizer,
			blockGrass, blockDirt, blockDebug, blockLanter, blockWater, blockWood, blockCarvedWood, blockWoodPanels,
			blockStonePanels, blockFurnaceBurning, blockChestOpen, blockCraftingTable, blockBaseStone, blockCave,
			blockLadders, blockSand, blockGlass, itemLightHelmet, itemLightBody, itemLightLeggins, tree;

	// animaatiot
	public static BufferedImage[] player_walkDown, player_walkUp, player_walkLeft, player_walkRight;

	// spritesheet2
	// texturet
	public static BufferedImage box1, box2, box3, button1, button2, button3, button1hovered, button2hovered, button3hovered, switchOn, switchOff;
	
	//animaatiot
	public static BufferedImage[] button1anim, button2anim, button3anim;
	
	// spritesheet3
	//texturet
	public static BufferedImage tree1, tree2;

	public static void init() {

		// Spritesheet1.png
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet1.png"));

		player_walkDown = new BufferedImage[2];
		player_walkDown[0] = sheet.crop16(1, 0);
		player_walkDown[1] = sheet.crop16(2, 0);

		player_walkUp = new BufferedImage[2];
		player_walkUp[0] = sheet.crop16(5, 0);
		player_walkUp[1] = sheet.crop16(6, 0);

		player_walkLeft = new BufferedImage[2];
		player_walkLeft[0] = sheet.crop16(8, 0);
		player_walkLeft[1] = sheet.crop16(9, 0);

		player_walkRight = new BufferedImage[2];

		BufferedImage temp1walkRight = sheet.crop16(8, 0);
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-temp1walkRight.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

		BufferedImage temp2walkRight = sheet.crop16(9, 0);
		AffineTransform tx1 = AffineTransform.getScaleInstance(-1, 1);
		tx1.translate(-temp2walkRight.getWidth(null), 0);
		AffineTransformOp op1 = new AffineTransformOp(tx1, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		
		BufferedImage temp1swimRight = sheet.crop16(1, 1);
		AffineTransform tx2 = AffineTransform.getScaleInstance(-1, 1);
		tx2.translate(-temp1swimRight.getWidth(null), 0);
		AffineTransformOp op2 = new AffineTransformOp(tx2, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

		player_walkRight[0] = op.filter(temp1walkRight, null);
		player_walkRight[1] = op1.filter(temp2walkRight, null);

		playerLeftBoat = sheet.crop16(1, 1);
		playerRightBoat = op2.filter(temp1swimRight, null);

		playerIdle = sheet.crop16(0, 0);
		playerMove1 = sheet.crop16(1, 0);
		playerMove2 = sheet.crop16(2, 0);
		playerDamage = sheet.crop16(3, 0);
		playerBackIdle = sheet.crop16(4, 0);
		playerBackMove1 = sheet.crop16(5, 0);
		playerBackMove2 = sheet.crop16(6, 0);
		playerBackDamage = sheet.crop16(7, 0);
		playerSideIdle = sheet.crop16(8, 0);
		playerSideMove = sheet.crop16(9, 0);
		playerSideDamage = sheet.crop16(10, 0);
		playerBoat = sheet.crop16(11, 0);
		playerBackBoat = sheet.crop16(0, 1);
		fullHeart = sheet.crop16(2, 1);
		halfHeart = sheet.crop16(3, 1);
		heart = sheet.crop16(4, 1);
		head = sheet.crop16(5, 1);
		body = sheet.crop16(6, 1);
		leggins = sheet.crop16(7, 1);
		headArmor = sheet.crop16(8, 1);
		bodyArmor = sheet.crop16(9, 1);
		legginsArmor = sheet.crop16(10, 1);
		inventorySlot = sheet.crop16(11, 1);
		itemDebug = sheet.crop16(0, 2);
		sword = sheet.crop16(1, 2);
		bow = sheet.crop16(2, 2);
		itemStoneAxe = sheet.crop16(3, 2);
		itemStoneShowel = sheet.crop16(4, 2);
		itemStonePickaxe = sheet.crop16(5, 2);
		itemStoneSword = sheet.crop16(6, 2);
		itemStoneClub = sheet.crop16(7, 2);
		itemGoldSword = sheet.crop16(8, 2);
		itemBrokenGoldSword1 = sheet.crop16(9, 2);
		itemBrokenGoldSword2 = sheet.crop16(10, 2);
		itemTriden = sheet.crop16(11, 2);
		itemIronAxe = sheet.crop16(0, 3);
		itemIronShowel = sheet.crop16(1, 3);
		itemIronPickaxe = sheet.crop16(2, 3);
		itemIronSword = sheet.crop16(3, 3);
		itemIronClub = sheet.crop16(4, 3);
		itemBetterAxe = sheet.crop16(5, 3);
		itemStick = sheet.crop16(6, 3);
		itemTorch = sheet.crop16(7, 3);
		itemBurnedTorch = sheet.crop16(8, 3);
		itemBomb = sheet.crop16(9, 3);
		itemFish = sheet.crop16(10, 3);
		mobTest = sheet.crop16(11, 3);
		itemOreIron = sheet.crop16(0, 4);
		itemOreGold = sheet.crop16(1, 4);
		itemOreCoal = sheet.crop16(2, 4);
		itemOreDiamond = sheet.crop16(3, 4);
		itemOreRuby = sheet.crop16(4, 4);
		itemOrePurple = sheet.crop16(5, 4);
		itemBetterGoldSword = sheet.crop16(6, 4);
		itemBow = sheet.crop16(7, 4);
		itemPurpleBow = sheet.crop16(8, 4);
		headGoldArmor = sheet.crop16(9, 4);
		bodyGoldArmor = sheet.crop16(10, 4);
		legginsGoldArmor = sheet.crop16(11, 4);
		blockStone = sheet.crop16(0, 5);
		blockOreIron = sheet.crop16(1, 5);
		blockOreGold = sheet.crop16(2, 5);
		blockOreCoal = sheet.crop16(3, 5);
		blockOreDiamond = sheet.crop16(4, 5);
		blockOreRuby = sheet.crop16(5, 5);
		blockOrePurple = sheet.crop16(6, 5);
		blockStoneBricks = sheet.crop16(7, 5);
		blockSmoothStone = sheet.crop16(8, 5);
		blockFurnace = sheet.crop16(9, 5);
		blockChest = sheet.crop16(10, 5);
		blockRandomizer = sheet.crop16(11, 5);
		blockGrass = sheet.crop16(0, 6);
		blockDirt = sheet.crop16(1, 6);
		blockDebug = sheet.crop16(2, 6);
		blockLanter = sheet.crop16(3, 6);
		blockWater = sheet.crop16(4, 6);
		blockWood = sheet.crop16(5, 6);
		blockCarvedWood = sheet.crop16(6, 6);
		blockWoodPanels = sheet.crop16(7, 6);
		blockStonePanels = sheet.crop16(8, 6);
		blockFurnaceBurning = sheet.crop16(9, 6);
		blockChestOpen = sheet.crop16(10, 6);
		blockCraftingTable = sheet.crop16(11, 6);
		blockBaseStone = sheet.crop16(0, 7);
		blockCave = sheet.crop16(1, 7);
		blockLadders = sheet.crop16(2, 7);
		blockSand = sheet.crop16(3, 7);
		blockGlass = sheet.crop16(0, 8);
		itemLightHelmet = sheet.crop16(0, 9);
		itemLightBody = sheet.crop16(1, 9);
		itemLightLeggins = sheet.crop16(2, 9);
		tree = sheet.crop(0, 169, 16, 17);
		
		// Spritesheet2.png
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet2.png"));
		
		button1anim = new BufferedImage[2];
		button1anim[0] = sheet2.crop(2, 65, 60, 10);
		button1anim[1] = sheet2.crop(38, 89, 60, 10);
		
		button2anim = new BufferedImage[2];
		button2anim[0] = sheet2.crop(2, 77, 43, 10);
		button2anim[1] = sheet2.crop(2, 53, 43, 10);
		
		button3anim = new BufferedImage[2];
		button3anim[0] = sheet2.crop(2, 89, 24, 10);
		button3anim[1] = sheet2.crop(74, 77, 24, 10);
		
		box1 = sheet2.crop(3, 3, 19, 19);
		box2 = sheet2.crop(25, 3, 29, 34);
		box3 = sheet2.crop(56, 3, 42, 53);
		button1 = sheet2.crop(2, 65, 60, 10);
		button2 = sheet2.crop(2, 77, 43, 10);
		button3 = sheet2.crop(2, 89, 24, 10);
		button1hovered = sheet2.crop(38, 89, 60, 10);
		button2hovered = sheet2.crop(2, 53, 43, 10);
		button3hovered = sheet2.crop(74, 77, 24, 10);
		switchOn = sheet2.crop(3, 23, 16, 10);
		switchOff = sheet2.crop(3, 36, 16, 10);

		
		//spritesheet3.png
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet3.png"));
		
		tree1 = sheet3.crop(0, 0, 16, 48);
		tree2 = sheet3.crop(18, 0, 16, 32);
	}

}
