package model;
import java.util.Random;
import controller.Config;

public class Boss2 {
	// position
	private int xPos;
	private int yPos;
	
	// movement
	private int xEnterSpeed;
	private double xSpeed;
	private double ySpeed;
	private double xAngle;
	private double yAngle;
	private int xCentre;
	private int yCentre;
	private double xAmplitude;
	private double yAmplitude;
	
	// collision detection
	private int cowHeadCentreX = 139;
	private int cowHeadCentreY = 59;
	private int cowHeadRadius = 44;
	private int bearHeadCentreX = 53;
	private int bearHeadCentreY = 109;
	private int bearHeadRadius = 44;
	private int bodyCentreX = 210;
	private int bodyCentreY = 190;
	private int bodyRadius = 70;
	
	// cow spawn position
	private int cowX = 110;
	private int cowY = 210;
	
	private int cowTimer;
	private int waitTimer;
	private int bulletTimer;
	private boolean canMakeEnemy;
	private boolean canShoot;
	
	private int shield;
	
	// actions:
	// e -> entering the play area
	// w -> waiting one second
	// f -> fighting
	
	Component cowHead;
	Component bearHead;
	Component body;
	private char action;
	
	private static Random rand;
	
	public Boss2() {
		
		xCentre = Config.cFrameWidth-375;
		yCentre = Config.cFrameHeight/2 - 170;
		xPos = Config.cFrameWidth -5;
		yPos = (int)yCentre;
		xEnterSpeed = 4;
		// xSpeed
		if(Config.difficulty == 0){xSpeed = 0.02;}
		else if(Config.difficulty == 1){xSpeed = 0.04;}
		else{xSpeed = 0.06;}
		// ySpeed
		if(Config.difficulty == 0){ySpeed = 0.01;}
		else if(Config.difficulty == 1){ySpeed = 0.02;}
		else{ySpeed = 0.03;}
		xAngle = 0;
		yAngle = 0;
		xAmplitude = 100;
		yAmplitude = 150;
		shield = 400;
		
		cowTimer = 30;
		waitTimer = 20;
		bulletTimer = 30;
		canMakeEnemy = false;
		canShoot = false;
		action = 'd';
		
		//Create this enemy's animation
		view.Animations.add(new view.AnimBoss2(this));
		rand = new Random();
		
		cowHead = new Component(xPos, yPos, cowHeadCentreX, cowHeadCentreY, cowHeadRadius);
		bearHead = new Component(xPos, yPos, bearHeadCentreX, bearHeadCentreY, bearHeadRadius);
		body = new Component(xPos, yPos, bodyCentreX, bodyCentreY, bodyRadius);
	}
	
	public void update(){
		
		canMakeEnemy = false;	// playObjects needs to know about this
		canShoot = false;
		
		switch (action){
		
		//************ wait a second before entering *************
		case 'd':
			if(waitTimer <= 0){
				action = 'e';
				waitTimer = 20;
			}
			else{waitTimer--;}
			break;
		
		//******************* entering the play area *********************
		case 'e':
			if (xPos > xCentre){
				xPos = xPos - xEnterSpeed;}
			else{
				action = 'w';}
			break;
			
		//************ wait a second before staring to fight *************
		case 'w':
			if(waitTimer <= 0){
				action = 'f';
			}
			else{waitTimer--;}
			break;
			
		//************************ fighting ********************************
		case 'f':
			
			// maybe shoot an enemy
			if(cowTimer == 0){
				canMakeEnemy = true;
				if(Config.difficulty == 0){cowTimer = 45 + rand.nextInt(30);}
				else if(Config.difficulty == 1){cowTimer = 30 + rand.nextInt(30);}
				else {cowTimer = 15 + rand.nextInt(30);}
				}
			else{cowTimer--;}
			
			// maybe shoot a bullet
			if(bulletTimer == 0){
				canShoot = true;
				if(Config.difficulty == 0){bulletTimer = 30 + rand.nextInt(30);}
				else if(Config.difficulty == 1){bulletTimer = 15 + rand.nextInt(30);}
				else {bulletTimer = 5 + rand.nextInt(30);}
				}
			else{bulletTimer--;}
			
			// move
			xAngle = xAngle + xSpeed;
			if(xAngle > (2*Math.PI)){xAngle = xAngle - (2*Math.PI);}
			xPos = xCentre + (int)(xAmplitude*Math.sin(xAngle));
			
			yAngle = yAngle + ySpeed;
			if(yAngle > (2*Math.PI)){yAngle = yAngle - (2*Math.PI);}
			yPos = yCentre + (int)(yAmplitude*Math.sin(yAngle));
			
			break;
			
		}// switch case bracket
		
		// update components
		cowHead.setX(xPos);
		cowHead.setY(yPos);
		bearHead.setX(xPos);
		bearHead.setY(yPos);
		body.setX(xPos);
		body.setY(yPos);
		
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
	
	public int getSpawnX(){
		return xPos + cowX;
	}	
	public int getSpawnY(){
		return yPos + cowY;
	}
	
	public boolean canShoot(){
		return canShoot;
	}
	
	public boolean canMakeEnemy(){
		return canMakeEnemy;
	}
	
	public boolean isDestroyed() {
		if(this.shield<1){
			return true;
		}else{
			return false;
		}
		
	}
}