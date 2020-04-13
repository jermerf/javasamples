package model;

public class Component implements MovableObject{

	int xPos;
	int yPos;
	
	int collisionX;
	int collisionY;
	int collisionRadius;
	
	public Component(int inX, int inY, int colX, int colY, int radius){
		xPos = inX;
		yPos = inY;
		collisionX = colX;
		collisionY = colY;
		collisionRadius = radius;
	}
	
	public void move() {
		// do nuttin
	}

	public int getX() {
		return xPos;
	}
	public int getY() {
		return yPos;
	}

	public int getImageOffset() {
		return 0;
	}
	public boolean isDestroyed() {
		return false;
	}
	public void setDestroyed(boolean inBool) {
		// do nuttin
	}

	public int getCollisionX() {
		return collisionX;
	}
	public int getCollisionY() {
		return collisionY;
	}
	public int getCollisionRadius() {
		return collisionRadius;
	}

	public boolean canShoot() {
		return false;
	}
	public void shoot() {
		// do nuttin
	}

	public void setX(int inX){
		xPos = inX;
	}
	public void setY(int inY){
		yPos = inY;
	}
}
