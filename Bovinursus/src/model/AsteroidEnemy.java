package model;

import controller.Config;

public class AsteroidEnemy implements MovableObject {
	private int xPos;
	private int yPos;
	private MotionPath path;
	private int imageOffset = 0;
	public boolean isDestroyed = false;
	
	// variables for collision detection
	private int collisionX = Config.cAsteroidCDCentreX;
	private int collisionY = Config.cAsteroidCDCentreY;
	private int collisionRadius = Config.cAsteroidCollisionRadius;
	
	public AsteroidEnemy(int xPos, int yPos, MotionPath path) {
		this.xPos = xPos;
		this.yPos = yPos;
		//this.shootDelay = shootDelay;
		this.path = path;
		//Create this enemy's animation
		view.Animations.add(new view.AnimEnemyObject(this));
	}
	
	public boolean canShoot() {
		return false;
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


	@Override
	public void shoot() {
		// do nuttin
		
	}
	public boolean isDestroyed() {
		return isDestroyed;
	}
	public void setDestroyed(boolean inBool) {
		isDestroyed = inBool;
	}
}