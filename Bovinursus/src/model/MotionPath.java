package model;

public interface MotionPath {
	public abstract int nextX(int lastX);
	public abstract int nextY(int lastY);
}
