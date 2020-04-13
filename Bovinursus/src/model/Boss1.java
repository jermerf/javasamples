package model;
import java.util.Random;
import controller.Config;

public class Boss1 implements RectangularObject {
	// position
	private int xPos;
	private int yPos;
	
	// movement
	private int xPosStatic;
	private int minY;
	private int maxY;
	private int direction;	// 0->up, 1->down
	private int xSpeed;
	private int ySpeed;
	
	// size
	int yTop = 20;
	int yBottom = 180;
	int xFront = 40;
	int xBack = 280;
	
	// laser start position
	int laserTop = 50;
	int laserBottom = 150;
	
	private int waitTimer;
	private int moveTimer;
	
	private int shield;
	
	// STATES
	public boolean openGate;
	public boolean startLaser;
	public boolean stopLaser;
	
	// actions:
	// e -> entering the play area
	// w -> waiting one second
	// m -> moving
	// h -> laser hesitate
	// o -> opening the gate
	// c -> closing the gate
	// l -> shooting laser
	
	public char action;
	
	//private int imageOffset = 0;
	private static Random rand;
	
	public Boss1(PlayerShip player) {
		
		this.xPos = Config.cFrameWidth -5;
		this.yPos = Config.cFrameHeight/2 - 100;
		xPosStatic = Config.cFrameWidth-325;
		minY = 0;
		maxY = Config.cFrameHeight-225;
		direction = 0;
		shield = 400;
		xSpeed = 7;
		if(Config.difficulty == 0){ySpeed = 8;}
		else if(Config.difficulty == 1){ySpeed = 10;}
		else {ySpeed = 12;}
		
		action = 'e';
		
		//Create this enemy's animation
		view.Animations.add(new view.AnimBoss1(this,player));
		rand = new Random();
	}
	
	public void update(){
		
		startLaser = false;	// playObjects needs to know about this
		stopLaser = false;	// playObjects needs to know about this
		
		switch (action){
		
		//******************* entering the play area *********************
		case 'e':
			if (xPos > xPosStatic){
				xPos = xPos - xSpeed;}
			else{
				waitTimer = 20;
				action = 'w';}
			break;
			
		//************ wait a second before staring to move *************
		case 'w':
			if(waitTimer <= 0){
				action = 'm';
				moveTimer = 60 + rand.nextInt(60);
			}
			else{waitTimer--;}
			break;
			
		//************************ moving ********************************
		case 'm':
			if(moveTimer <= 0){
				if(Config.difficulty == 0){waitTimer = 20;}	// hesitate time
				else if(Config.difficulty == 1){waitTimer = 14;}
				else{waitTimer = 7;}
				action = 'h';
			}
			else{
				if(direction == 0){	// moving up
					if(yPos + ySpeed > maxY){	// reached the top, thus turn around
						yPos = maxY;
						direction = 1;
					}
					else{yPos = yPos + ySpeed;}
				}
				else{				// moving down
					if(yPos - ySpeed < minY){	// reached the bottom, thus turn around
						yPos = minY;
						direction = 0;
					}
					else{yPos = yPos - ySpeed;}
				}
				// check to see if it will randomly change direction
				int range;
				if(Config.difficulty == 0){range = 60;}
				else if(Config.difficulty == 1){range = 45;}
				else {range = 30;}
				if (rand.nextInt(range) == 5 && (yPos != minY) && (yPos != maxY)){
					if(direction == 0){direction = 1;}
					if(direction == 1){direction = 0;}
				}
				moveTimer--;
			}
			break;
			
		//***************** hesitate before opening to shoot *************
			
		case 'h':
			if(waitTimer <= 0){
				waitTimer = 10;	// THIS IS THE TIME THAT IT TAKES FOR THE GATE TO OPEN AND LASER TO START
				action = 'o';
				openGate = true;
			}
			else{
				waitTimer--;
			}
			break;
			
		//*************************** opening ****************************	
		case 'o':
			if(waitTimer <= 0){
				waitTimer = 25 + rand.nextInt(20);	// random amount of time laser will be shooting
				action = 'l';
				startLaser = true;
			}
			else{waitTimer--;}
			break;
			
		//*********************** shooting laser ************************
			
		case 'l':
			if(waitTimer <= 0){
				waitTimer = 15;		// time between when the laser ends and when the boss starts to move again
				action = 'c';
				stopLaser = true;
				openGate = false;
			}
			else{
				waitTimer--;
			}
			break;
			
		//*********************** closing the gate ***********************
			
		case 'c':
			if(waitTimer <= 0){
				action = 'm';
				moveTimer = 60 + rand.nextInt(60);
			}
			else{
				waitTimer--;
			}
			break;
			
		}// switch case bracket
		
	}// update function bracket
	
	public int getX(){
		return xPos;
	}	
	public int getY(){
		return yPos;
	}

	public int getShield(){
		return shield;
	}
	public void changeShield(int amount){
		shield = shield + amount;
		if(shield < 0){shield = 0;}
	}

	public boolean isDestroyed() {
		if(this.shield<1){
			return true;
		}else{
			return false;
		}
		
	}
	
	@Override
	public int getTop() {
		return yPos + yTop;
	}

	@Override
	public int getBottom() {
		return yPos + yBottom;
	}

	@Override
	public int getLeft() {
		return xPos + xFront;
	}

	@Override
	public int getRight() {
		return xPos + xBack;
	}
}