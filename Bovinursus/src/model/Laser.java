package model;

import controller.Config;

public class Laser implements RectangularObject {
	
	private int top;
	private int bottom;
	private int height;
	
	// constructor
	Laser(int yTop){
		height = 100;
		top = yTop;
		bottom = yTop + height;

	}
	
	@Override
	public int getTop() {
		return top;
	}
	@Override
	public int getBottom() {
		return bottom;
	}
	@Override
	public int getLeft() {
		return 1;
	}
	@Override
	public int getRight() {
		return Config.cFrameWidth;
	}
	
}