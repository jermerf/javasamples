package model;

import controller.Config;

public class Bullet implements MovableObject {
	private int x;
	private int y;
	private int imageOffset = 0;
	private MotionPath path;
	private int speed;
	public boolean isDestroyed = false;
	
	// variables for collision detection
	private int collisionX = Config.cBulletCDCentreX;
	private int collisionY = Config.cBulletCDCentreY;
	private int collisionRadius = Config.cBulletCDRadius;
	
	public Bullet(int xPos, int yPos, int type, int angle) {
		this.x = xPos;
		this.y = yPos;
		if(type == 0){this.speed = Config.cShipBulletSpeed;}
		if(type == 1){this.speed = Config.cEnemyBulletSpeedN;}
		path = new UnidirectionalPath(speed, angle);
		view.Animations.add(new view.AnimPlayerBullet(this, type));
		if(type == 0){
			this.collisionX = Config.cBulletCDCentreX;
			this.collisionY = Config.cBulletCDCentreY;
			this.collisionRadius = Config.cBulletCDRadius;
			}
		if(type == 1){
			this.collisionX = Config.EnemyBulletCDCentreX;
			this.collisionY = Config.EnemyBulletCDCentreY;
			this.collisionRadius = Config.EnemyBulletCDRadius;
			}
	}
	
	public Bullet(int xPos, int yPos, int type) {
		this.x = xPos;
		this.y = yPos;
		if(type == 0){this.speed = Config.cShipBulletSpeed;}
		if(type == 1){this.speed = Config.cEnemyBulletSpeedN;}
		path = new UnidirectionalPath(speed);
		view.Animations.add(new view.AnimPlayerBullet(this, type));
	}
	
	public void move(){
		x = path.nextX(x);
		y = path.nextY(y);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
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
	public boolean canShoot() {
		return false;
	}

	@Override
	public void shoot() {
		//do nuttin
	}
	public boolean isDestroyed() {
		return false;
	}
	public void setDestroyed(boolean inBool) {

	}
}
