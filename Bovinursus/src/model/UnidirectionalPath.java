package model;

public class UnidirectionalPath implements MotionPath {
	
	private int speed;
	private int angle;
	
	public UnidirectionalPath(int inSpeed) {
		this.speed = inSpeed;
		this.angle = 0;
	}
	
	public UnidirectionalPath(int inSpeed, int angle) {
		this.speed = inSpeed;
		this.angle = angle;
	}
	
	public int nextX(int lastX){
		return (int) (lastX + speed * Math.cos(angle *-0.01745329251994329576923690768489));// convert to radians pi/180 
	}
	
	public int nextY(int lastY){
		return (int)(lastY + speed * Math.sin(angle *-0.01745329251994329576923690768489));// convert to radians pi/180 
	}

}