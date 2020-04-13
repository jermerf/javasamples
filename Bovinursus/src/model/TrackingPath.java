package model;

import controller.Config;

class TrackingPath implements MotionPath{
		
	private double mSpeed;
	private double mAngle;
	private double mLastX;
	private double mLastY;
	private double xMomentum ,yMomentum;
	private MovableObject prey;
	
	public TrackingPath(int inSpeed, int inY, int inX, MovableObject inObject) {
		this.mSpeed = inSpeed*.75;
		this.prey = inObject;
		this.mLastX = inX;
		this.mLastY = inY;
		this.xMomentum = 0;
		this.yMomentum = 0;
	}

	public int nextX(int lastX){
		mAngle = Math.atan(Math.abs(prey.getY() + Config.cShipCDCentreY - mLastY) / Math.abs(prey.getX() + Config.cShipCDCentreX - mLastX));
		double xOffset = 0;
		if((prey.getX() + Config.cShipCDCentreX) > mLastX){
			xOffset = mSpeed*Math.cos(mAngle)/5;}
		if((prey.getX() + Config.cShipCDCentreX) < mLastX){
			xOffset = -mSpeed*Math.cos(mAngle)/5;}
		
		xMomentum += 0.5*xOffset;
		if(Config.difficulty == 0){
			if(xMomentum>5){xMomentum=5;}
			if(xMomentum<-5){xMomentum=-5;}}
		if(Config.difficulty == 1){
			if(xMomentum>8){xMomentum=8;}
			if(xMomentum<-8){xMomentum=-8;}}
		else{
			if(xMomentum>10){xMomentum=10;}
			if(xMomentum<-10){xMomentum=-10;}}
		xMomentum = xMomentum *0.99 ;
		if(Math.abs(xMomentum)<0.3) {xMomentum = 0;}
		int newX = (int)(mLastX + xMomentum);
		mLastX = newX;
		return newX;
	}
	
	public int nextY(int lastY){
		mAngle = Math.atan(Math.abs(prey.getY() + Config.cShipCDCentreY - mLastY) / Math.abs(prey.getX() + Config.cShipCDCentreX - mLastX));
		double yOffset = 0;
		if((prey.getY() + Config.cShipCDCentreY) > mLastY){
			yOffset = mSpeed*Math.sin(mAngle)/5;}
		if((prey.getY() + Config.cShipCDCentreY) < mLastY){
			yOffset = -mSpeed*Math.sin(mAngle)/5;}
		
		yMomentum += 0.5*yOffset;
		if(yMomentum>10){yMomentum=10;}
		if(yMomentum<-10){yMomentum=-10;}
		yMomentum = yMomentum *0.99;
		if(Math.abs(yMomentum)<0.3) {yMomentum = 0;}
		int newY = (int)(mLastY + yMomentum);
		mLastY = newY;
		return newY;
	}
}