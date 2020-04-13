package model;

import java.util.*;

public interface IControllerModel {
	public abstract void setUp(boolean upKey);
	public abstract void setLeft(boolean leftKey);
	public abstract void setDown(boolean downKey);
	public abstract void setRight(boolean rightKey);
	public abstract void setShooting(boolean shootingKey);
	public abstract void setPause(boolean pauseKey);
	public abstract void setEnter(boolean enter);
	public abstract ArrayList<Boolean> getSounds();
	public abstract void update();
}
