package model;

import controller.Config;

public class PlayerPath implements MotionPath {
	
	int maxX = Config.cFrameWidth-90;
	int maxY = Config.cFrameHeight-90;
	int minX = -10;
	int minY = -38;	// this accounts for the border on the top of the ship image
	
	private double xMomentum ,yMomentum;
	private double xOffset ,yOffset;
	private int speed;
	
	public PlayerPath(int speed) {
		this.speed = speed;
		xMomentum = 0;
		yMomentum = 0;
		xOffset = 0;
		yOffset = 0;
	}
	
	//Opposite directions cancel hence the XOR-ing
	public void setMotion(boolean up, boolean down, boolean left, boolean right){
		xOffset = 0;
		yOffset = 0;
		if(up ^ down){		//XOR
			if (up){
				yOffset = -speed/5;
			}else{
				yOffset = speed/5;
			}
		}
		if(left ^ right){	//XOR
			if (left){
				xOffset = -speed/5;
			}else{
				xOffset = speed/5;
			}
		}
		//If there the offset for both is non-zero, the ship is moving diagonally
		//Multiply by ~0.7071 to get the same magnitude of speed
		//Otherwise the ship is moving faster when it's going diagonally
		if(xOffset!=0 && yOffset!=0){
			xOffset = (xOffset*7071) / 10000;
			yOffset = (yOffset*7071) / 10000;
		}	
	}
	
	public int nextX(int lastX){
		xMomentum += xOffset;
		xMomentum = xMomentum * 0.9;
		if(Math.abs(xMomentum)<0.3){
			xMomentum = 0;
		}
		//System.out.println(xMomentum);
		if (lastX + xMomentum >= maxX) {
			return maxX;
		}else if (lastX + xMomentum <= minX) {
			return minX;
		}else {
			return (int)(lastX + xMomentum);
		}
	}
	
	public int nextY(int lastY){
		yMomentum += yOffset;
		yMomentum = yMomentum * 0.9;
		if(Math.abs(yMomentum)<0.3){
			yMomentum = 0;
		}
		if (lastY + yMomentum >= maxY) {
			return maxY;
		}else if (lastY + yMomentum <= minY) {
			return minY;
		}else {
			return (int)(lastY + yMomentum);
		}
	}
	
}