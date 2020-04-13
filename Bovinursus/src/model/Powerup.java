package model;

import controller.Config;

public class Powerup implements MovableObject{
	private int xPos;
	private int yPos;
	private int type;
	private MotionPath path;
	private int imageOffset = 0;
	public boolean isDestroyed = false;
	
	public Powerup(int xPos, int yPos,int type){
		this.xPos=xPos+Config.cPowerupCDCentreX;
		this.yPos=yPos+Config.cPowerupCDCentreY;
		this.type=type;
		view.Animations.add(new view.AnimPowerup(this,type));
		//Replace this with a stationary path
		path = new UnidirectionalPath(Config.cStationarySpeed,-180);
	}
	@Override
	public void move() {
		xPos = path.nextX(xPos);
		yPos = path.nextY(yPos);
	}

	@Override
	public int getX() {
		return xPos;
	}

	@Override
	public int getY() {
		return yPos;
	}

	@Override
	public int getImageOffset() {
		return imageOffset;
	}

	@Override
	public int getCollisionX() {
		return Config.cPowerupCDCentreX;
	}

	@Override
	public int getCollisionY() {
		return Config.cPowerupCDCentreY;
	}

	@Override
	public int getCollisionRadius() {
		return Config.cPowerupCDRadius;
	}
	public int getType() {
		return type;
	}
	@Override
	public boolean canShoot() {
		return false;
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
