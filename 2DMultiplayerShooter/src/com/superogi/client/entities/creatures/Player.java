package com.superogi.client.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.superogi.client.Handler;
import com.superogi.client.entities.Entity;
import com.superogi.client.inventory.Inventory;
import com.superogi.client.renderEngine.graphics.Animation;
import com.superogi.client.renderEngine.graphics.Assets;

public class Player extends Creature {

	private Animation walkRight, walkUp, walkDown, walkLeft;
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	private Inventory inventory;

	float speed = Creature.DEFAULT_SPEED;
	int animSpeed = 300;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 38;
		bounds.y = 38;
		bounds.width = 30;
		bounds.height = 50;

		walkRight = new Animation(animSpeed, Assets.player_walkRight);
		walkLeft = new Animation(animSpeed, Assets.player_walkLeft);
		walkUp = new Animation(animSpeed, Assets.player_walkUp);
		walkDown = new Animation(animSpeed, Assets.player_walkDown);
		
		inventory = new Inventory(handler);

	}

	@Override
	public void tick() {
		// animatiot
		walkUp.tick();
		walkDown.tick();
		walkRight.tick();
		walkLeft.tick();
		// liikkuminen
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		//tappaminen
		checkAttacks();
		
		inventory.tick();
	}
	
	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
		
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 30;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		} else if(handler.getKeyManager().aDown) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		} else if(handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if(handler.getKeyManager().aRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else {
			return;
		}
		
		attackTimer = 0;
		
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(2);
				return;
			}
		}
	}

	@Override
	public void die() {
		System.out.println("Pelaaja kuoli");
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().shift && !(swimming((int) getX(), (int) getY()))) {
			speed = 7.0f;
		} else if (swimming((int) getX(), (int) getY())) {
			speed = 1.25f;
		} else {
			speed = 5.0f;
		}

		if (handler.getKeyManager().right)
			xMove += speed;
		if (handler.getKeyManager().left)
			xMove -= speed;
		if (handler.getKeyManager().up)
			yMove -= speed;
		if (handler.getKeyManager().down)
			yMove += speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), Creature.DEFAULT_CREATURE_WIDTH,
				Creature.DEFAULT_CREATURE_HEIGHT, null);
		inventory.render(g);
	}

	private BufferedImage getCurrentAnimationFrame() {

		if (swimming((int) getX(), (int) getY())) {

			if (xMove < 0) {
				return Assets.playerLeftBoat; // vasen
			} else if (xMove > 0) {
				return Assets.playerRightBoat; // oikea
			} else if (yMove > 0) {
				return Assets.playerBoat; // alas
			} else if (yMove < 0) {
				return Assets.playerBackBoat;
			} else {
				return Assets.playerBoat;
			}

		} else {

			if (xMove < 0) {
				return walkLeft.getCurrentImage();
			} else if (xMove > 0) {
				return walkRight.getCurrentImage();
			} else if (yMove > 0) {
				return walkDown.getCurrentImage();
			} else if (yMove < 0) {
				return walkUp.getCurrentImage();
			} else {
				return Assets.playerIdle;
			}

		}
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public float getCurrentSpeed() {
		return speed;
	}

}
