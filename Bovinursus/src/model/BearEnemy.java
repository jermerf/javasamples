package model;

import java.util.Random;
import controller.Config;

public class BearEnemy implements MovableObject {
	private int xPos;
	private int yPos;
	private MotionPath path;
	private int gunTimer;
	private int imageOffset = 0;
	private boolean isDestroyed = false;
	private static Random rand;
	
	// variables for collision detection
	private int collisionX = Config.cBearCDCentreX;
	private int collisionY = Config.cBearCDCentreY;
	private int collisionRadius = Config.cBearCollisionRadius;
	
	public BearEnemy(int xPos, int yPos, MotionPath path) {
		this.xPos = xPos;
		this.yPos = yPos;
		//this.shootDelay = shootDelay;
		this.path = path;
		//Create this enemy's animation
		view.Animations.add(new view.AnimEnemyObject(this));
		rand = new Random();
		if(Config.difficulty==0){gunTimer = rand.nextInt(40) + Config.cEnemyShootDelayEasy;}
		else if(Config.difficulty==1){gunTimer = rand.nextInt(40) + Config.cEnemyShootDelayNormal;}
		else {gunTimer = rand.nextInt(40) + Config.cEnemyShootDelayHard;}
	}
	
	public boolean canShoot() {
		if(gunTimer >0){
			gunTimer--;
			return false;
		}
		else{return true;}
	}
	
	public void move(){
		xPos = path.nextX(xPos);
		yPos = path.nextY(yPos);
	}
	
	public int getX(){
		return xPos;
	}
	
	public int getY(){
		return yPos;
	}
	
	public int getImageOffset(){
		return imageOffset;
		
	}

	public void shoot() {
		if(Config.difficulty==0){gunTimer = rand.nextInt(40) + Config.cEnemyShootDelayEasy;}
		else if(Config.difficulty==1){gunTimer = rand.nextInt(40) + Config.cEnemyShootDelayNormal;}
		else {gunTimer = rand.nextInt(40) + Config.cEnemyShootDelayHard;}
	}

	// get collision detection variables
	public int getCollisionX(){
		return collisionX;
	}
	public int getCollisionY(){
		return collisionY;
	}
	public int getCollisionRadius(){
		return collisionRadius;
	}
	public boolean isDestroyed() {
		return isDestroyed;
	}
	public void setDestroyed(boolean inBool) {
		isDestroyed = inBool;
	}
}