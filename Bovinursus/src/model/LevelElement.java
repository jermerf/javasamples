package model;

public class LevelElement {
	
	public int Xpos;
	public int Ypos;
	public char type;
	public char path;
	public int pathParam1;
	public int pathParam2;
	
	public LevelElement(int x, int y, char type, char path, int param1, int param2){
		this.Xpos = x;
		this.Ypos = y;
		this.type = type;
		this.path = path;
		this.pathParam1 = param1;
		this.pathParam2 = param2;
	}
	
	public LevelElement(int x, int y, char type, char path, int param1){
		this.Xpos = x;
		this.Ypos = y;
		this.type = type;
		this.path = path;
		this.pathParam1 = param1;
		this.pathParam2 = 0;
	}
	
	public LevelElement(int x, int y, char type, char path){
		this.Xpos = x;
		this.Ypos = y;
		this.type = type;
		this.path = path;
		this.pathParam1 = 180;
		this.pathParam2 = 0;
	}
}
