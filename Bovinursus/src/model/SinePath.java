package model;

public class SinePath implements MotionPath {
	private double speed;
	private double angle = 0;
	private double amplitude;
	private double period;
	private double phase;
	private int yBase;
	
	public SinePath(int yPos, int inSpeed, int amp, int inPeriod) {
		this.period = (double)inPeriod;
		this.speed = inSpeed;
		this.amplitude = amp;
		this.phase = 1/period;
		this.yBase = yPos;
	}
	
	public int nextX(int lastX){
		int xPos = lastX - (int)speed;
		return xPos;
	}
	
	public int nextY(int lastY){
		angle = angle + (speed);
		int yPos = yBase + (int)(amplitude*Math.sin(angle*phase));
		return yPos;
	}

}