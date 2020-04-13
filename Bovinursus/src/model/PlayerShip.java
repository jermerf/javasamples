package model;

import controller.Config;

public class PlayerShip implements MovableObject {
	
	private int mXPos;
	private int mYPos;
	private final int speed = Config.cShipSpeed;
	private int shield;
	private int gunLevel;
	
	private final int mShootDelay = Config.cShipShootDelay;
	private int mGunTimer;
	private boolean mGunAlternate;
	private int mGun1X;
	private int mGun1Y;
	private int mGun2X;
	private int mGun2Y;
	private int mGun3X;
	private int mGun3Y;
	
	private int mImageOffset;
	private PlayerPath mPath;
	
	// variables for collision detection
	private int collisionX = Config.cShipCDCentreX;
	private int collisionY = Config.cShipCDCentreY;
	private int collisionRadius = Config.cShipCollisionRadius;
	
	public PlayerShip(int xPos, int yPos) {
		this.mXPos = xPos;
		this.mYPos = yPos;
		mGunTimer = 0;
		mImageOffset = 0;
		mPath = new PlayerPath(speed);
		mGunAlternate = false;
		view.Animations.add(new view.AnimPlayerShip(this));
		this.shield = 100;
		this.gunLevel = 0;
	}
	
	public void move(){
		// friday mulligan
	}
	
	public void move(boolean up, boolean down, boolean left, boolean right) {
		
		// JERMAINE: DO NOT GET RID OF THIS CODE WHEN MOVING ANIMATION INTO
		// THE VIEW. IT IS NEEDED TO CALCULATE THE POSITION OF THE GUNS
		// update image offset
		if(mImageOffset==0){
			if(up&&!down){
				mImageOffset--;
			}else if(!up&&down){
				mImageOffset++;
			}
		}else{
			if(!up&&!down||up&&down){
				if(mImageOffset < 0){
					mImageOffset++;
				}else{
					mImageOffset--;
				}
			}else if(up&&!down){
				mImageOffset--;
			}else if(!up&&down){
				mImageOffset++;
			}
			if(mImageOffset>9){mImageOffset=9;}
			if(mImageOffset<-9){mImageOffset=-9;}
		}
		// move the ship
		mPath.setMotion(up,down,left,right);
		mXPos = mPath.nextX(mXPos);
		mYPos = mPath.nextY(mYPos);
		
		// update the Shoot Timer
		if (mGunTimer > 0) {mGunTimer--;}
		
		// calculate the position of the guns
		mGun1X = mXPos + Config.cShipGun1X;
		if(mImageOffset > 0){
			mGun1Y = mYPos + Config.cShipGun1Y + mImageOffset +1;}
		else if(mImageOffset < 0){
			mGun1Y = mYPos + Config.cShipGun1Y + mImageOffset*3;}
		else{mGun1Y = mYPos + Config.cShipGun1Y;}
		
		mGun2X = mXPos + Config.cShipGun2X;
		mGun2Y = mYPos + Config.cShipGun2Y;
		if(mImageOffset > 0){
			mGun2Y = mYPos + Config.cShipGun2Y + mImageOffset*(-3) +3;}
		else if(mImageOffset < 0){
			mGun2Y = mYPos + Config.cShipGun2Y + mImageOffset*(-2);}
		else{mGun2Y = mYPos + Config.cShipGun2Y;}
		
		mGun3X = mXPos + Config.cShipGun3X;
		mGun3Y = mYPos + Config.cShipGun3Y;
		if(mImageOffset > 0){
			mGun3Y = mYPos + Config.cShipGun3Y + mImageOffset/2 +2;}
		else if(mImageOffset < 0){
			mGun3Y = mYPos + Config.cShipGun2Y + mImageOffset -20;}
		else{mGun3Y = mYPos + Config.cShipGun3Y;}
	}
	
	public int getX(){
		return mXPos;
	}
	public int getY(){
		return mYPos;
	}
	
	public int getImageOffset() {
		return mImageOffset;
	}
	
	public boolean canShoot(){
		if(mGunTimer > 0){
			return false;
		}else{
			return true;
		}
	}
	public boolean alternateGun(){
		if (mGunAlternate){ mGunAlternate = false;}
		else {mGunAlternate = true;}
		return mGunAlternate;
	}
	public void shoot(){
		if(gunLevel == 0){mGunTimer = mShootDelay;}
		else if(gunLevel == 1){mGunTimer = mShootDelay;}
		else{mGunTimer = mShootDelay +1;}
	}
	public void upgradeGun(){
		if(gunLevel<4){gunLevel++;}
	}
	public int getGunLevel(){
		return gunLevel;
	}
	public void setGunLevel(int level){
		gunLevel = level;
	}
	
	public int changeShield(int amount){
		shield = shield + amount;
		if(shield <= 0){
			shield = 0;
			return 0;
		}
		else if(shield > 100){
			shield = 100;
			return 100;
		}
		else {return shield;}
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
	
	public int getGun1X(){
		return mGun1X;
	}
	public int getGun1Y(){
		return mGun1Y;
	}
	public int getGun2X(){
		return mGun2X;
	}
	public int getGun2Y(){
		return mGun2Y;
	}
	public int getGun3X(){
		return mGun3X;
	}
	public int getGun3Y(){
		return mGun3Y;
	}
	public boolean isDestroyed() {
		return false;
	}
	public void setDestroyed(boolean inBool) {
	}
}
