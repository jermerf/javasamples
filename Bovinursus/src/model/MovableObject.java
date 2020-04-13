package model;

public interface MovableObject {
	public abstract void move();
	public abstract int getX();
	public abstract int getY();
	// remove this when 
	public abstract int getImageOffset();
	// get collision detection variables
	public boolean isDestroyed();
	public void setDestroyed(boolean inBool);
	public int getCollisionX();
	public int getCollisionY();
	public int getCollisionRadius();
	public boolean canShoot();
	public void shoot();
}