 package model;

import java.util.ArrayList;
import java.util.Random;
import controller.Config;

public class PlayObjects {
	
	//size of the play area
	private final int mPlayHeight = Config.cFrameHeight;
	private final int mPlayWidth = Config.cFrameWidth;
	
	private int xNegRange = -300;
	private int yNegRange = -300;
	private int xPosRange = 500 + Config.cFrameWidth;
	private int yPosRange = 300 + Config.cFrameHeight;
	private int bulletXmax = 3 + Config.cFrameWidth;
	private int bulletXmin = -3;
	private Random powerupRand = new Random();
	private Random pTypeRand = new Random();
	private int playerShield;
	private int lives;
	private boolean setBossMusic = false;
	
	private ArrayList<MovableObject> mEnemies, mPlayerBullets, mPowerups, mEnemyBullets;
	private Boss1 laserBoss;
	private Boss2 cowBoss;
	
	private Level level;
	private int levelSearchIndex;
	private CollisionDetection mCollisionDetector;
	private PlayerShip mPlayerShip;
	private Laser mLaser;
	
	private int levelProgress;
	private int levelLength;
	private boolean atBoss;
	private boolean bossDead;
	private boolean laserExists;
	private int currentLevel;
	private Random rand;

	public PlayObjects(int inLevel) {
		
		// player ship starts in the middle of the screen
		int shipStartX = mPlayWidth/2 - 64;
		int shipStartY = mPlayHeight/2 - 55;
		mPlayerShip = new PlayerShip(shipStartX, shipStartY);
		mPlayerBullets = new ArrayList<MovableObject>();
		mEnemyBullets = new ArrayList<MovableObject>();
		mEnemies = new ArrayList<MovableObject>();
		mPowerups = new ArrayList<MovableObject>();
		
		// make the first level
		level = new Level(inLevel);
		levelProgress = -1;
		levelSearchIndex = 0;
		levelLength = level.getLength();
		mCollisionDetector = new CollisionDetection();
		playerShield = 100;
		lives = 0;
		atBoss = false;
		bossDead = false;
		laserExists = false;
		currentLevel = inLevel;
		rand = new Random();
	}
	
	// returns the shield level of the player
	public int checkShipCollision(){
		
		if(mCollisionDetector.getCollision(mPlayerShip, mEnemies) != -1){
			//Player collided with enemy
			int enemyIndex = mCollisionDetector.getCollision(mPlayerShip, mEnemies);
			mEnemies.get(enemyIndex).setDestroyed(true);
			mEnemies.remove(enemyIndex);
			// got hit by enemy, reduce shield
			if(Config.difficulty==0){playerShield = mPlayerShip.changeShield(Config.cEnemyHitDamageE);}
			else if(Config.difficulty==1){playerShield = mPlayerShip.changeShield(Config.cEnemyHitDamageN);}	
			else{playerShield = mPlayerShip.changeShield(Config.cEnemyHitDamageH);}	
		}
		if(mCollisionDetector.getCollision(mPlayerShip, mEnemyBullets) != -1){
			//Player collided with enemyBullet
			int bulletIndex = mCollisionDetector.getCollision(mPlayerShip, mEnemyBullets);
			((Bullet)mEnemyBullets.get(bulletIndex)).isDestroyed = true;
			mEnemyBullets.remove(bulletIndex);
			// got hit by bullet, reduce shield
			if(Config.difficulty==0){playerShield = mPlayerShip.changeShield(Config.cEnemyBulletDamageE);}
			else if(Config.difficulty==1){playerShield = mPlayerShip.changeShield(Config.cEnemyBulletDamageN);}	
			else{playerShield = mPlayerShip.changeShield(Config.cEnemyBulletDamageH);}
		}
		if(atBoss && currentLevel == 2){
			// check collision with cow head
			if(mCollisionDetector.checkCollision(cowBoss.cowHead, mPlayerShip)){
				playerShield = mPlayerShip.changeShield(-12);
			}
			// check collision with bear head
			if(mCollisionDetector.checkCollision(cowBoss.bearHead, mPlayerShip)){
				playerShield = mPlayerShip.changeShield(-12);
			}
			// check collision with body
			if(mCollisionDetector.checkCollision(cowBoss.body, mPlayerShip)){
				playerShield = mPlayerShip.changeShield(-12);
			}
		}
		if(atBoss && currentLevel == 1){
			if(mCollisionDetector.checkCollision(laserBoss, mPlayerShip)){
				playerShield = mPlayerShip.changeShield(-12);
			}
			if(laserExists && mCollisionDetector.checkCollision(mLaser, mPlayerShip)){
				playerShield = mPlayerShip.changeShield(-10);
			}
		}
		return playerShield;
	}
	
	public boolean playerGetPowerup(){
		lives = 0;
		if(mCollisionDetector.getCollision(mPlayerShip, mPowerups) != -1){
			//Player Collided with powerup
			int powerupIndex = mCollisionDetector.getCollision(mPlayerShip, mPowerups);
			Powerup powerup = (Powerup)mPowerups.get(powerupIndex);
			
			// blue powerup makes your gun better
			if(powerup.getType() == 0){
				mPlayerShip.upgradeGun();
			}
			
			// red powerup gives you 10% more shield
			if(powerup.getType() == 1){
				playerShield = mPlayerShip.changeShield(10);
			}
			
			// yellow powerup gives you a free life
			if(powerup.getType() == 2){
				lives = 1;
			}
			powerup.isDestroyed = true;
			mPowerups.remove(powerupIndex);
			return true;
		}
		else return false;
	}
	
	public int collideEnemies(){
		int collisionsFound = 0;
		for(int i=0; i < mEnemies.size(); i++){	//Check each enemy for collisions
			int index = mCollisionDetector.getCollision(mEnemies.get(i), mPlayerBullets);
			if(index != -1){
				mEnemies.get(i).setDestroyed(true);
				//Check to see if a powerup is getting made
				int powerupNum = pTypeRand.nextInt(10);
				if(powerupRand.nextDouble()<Config.cPowerupProbability){
					if(powerupNum == 0){							//yellow => 1/10
						mPowerups.add(new Powerup(mEnemies.get(i).getX(),mEnemies.get(i).getY(),2));}
					else if (powerupNum == 1 || powerupNum == 2){	//blue => 2/10
						mPowerups.add(new Powerup(mEnemies.get(i).getX(),mEnemies.get(i).getY(),0));}
					else {mPowerups.add(new Powerup(mEnemies.get(i).getX(),mEnemies.get(i).getY(),1));}
				}													//red => 7/10
				mEnemies.remove(i);
				((Bullet)mPlayerBullets.get(index)).isDestroyed = true;
				mPlayerBullets.remove(index);
				collisionsFound ++;
			}
		}
		return collisionsFound;
	}
	
	public void moveObjects(boolean up, boolean down, boolean left, boolean right) {
		
		// int sum = 0;
		
		// move ship
		mPlayerShip.move(up, down, left, right);
		
		// move player bullets
		for(int i=0; i < mPlayerBullets.size(); i++){
			mPlayerBullets.get(i).move();
			if(mPlayerBullets.get(i).getX() > bulletXmax || mPlayerBullets.get(i).getX() < bulletXmin ||
			   mPlayerBullets.get(i).getY() > yPosRange || mPlayerBullets.get(i).getY() < yNegRange){
				mPlayerBullets.remove(i);
			}
		}
		
		// move enemy bullets
		for(int i=0; i < mEnemyBullets.size(); i++){
			mEnemyBullets.get(i).move();
			if(mEnemyBullets.get(i).getX() > bulletXmax || mEnemyBullets.get(i).getX() < xNegRange ||
			   mEnemyBullets.get(i).getY() > yPosRange || mEnemyBullets.get(i).getY() < yNegRange){
				mEnemyBullets.remove(i);
			}
		}
		
		// move enemies
		for(int i = 0; i<mEnemies.size();i++){
			mEnemies.get(i).move();
			if(mEnemies.get(i).getX() > xPosRange || mEnemies.get(i).getX() < xNegRange ||
					mEnemies.get(i).getY() > yPosRange || mEnemies.get(i).getY() < yNegRange){
				mEnemies.remove(i);
			}
		}
		
		// move powerups
		for(int i=0; i<mPowerups.size();i++){
			mPowerups.get(i).move();
			if(mPowerups.get(i).getX() > xPosRange || mPowerups.get(i).getX() < xNegRange ||
					mPowerups.get(i).getY() > yPosRange || mPowerups.get(i).getY() < yNegRange){
				mPowerups.remove(i);
			}
		}
//		sum = sum+mPlayerBullets.size();
//		sum = sum+mEnemyBullets.size();
//		sum = sum+mEnemies.size();
//		sum = sum+mPowerups.size();
//		System.out.println("Total Sprites: " + sum);
	}
	
	// this method creates player bullets
	public boolean playerFire() {
		if(mPlayerShip.canShoot()){
			mPlayerShip.shoot();
			// ALTERNATE
			if(mPlayerShip.getGunLevel() == 0 || mPlayerShip.getGunLevel() == 3){
				// Gun 1 (outside)
				if (mPlayerShip.alternateGun()){
					mPlayerBullets.add(new Bullet(mPlayerShip.getGun1X(), mPlayerShip.getGun1Y(), 0));}
				// Gun 2 (inside)
				else{
					mPlayerBullets.add(new Bullet(mPlayerShip.getGun2X(), mPlayerShip.getGun2Y(), 0));}
			}
			// DOUBLE
			if(mPlayerShip.getGunLevel() == 1 || mPlayerShip.getGunLevel() == 2 || mPlayerShip.getGunLevel() == 4){
				mPlayerBullets.add(new Bullet(mPlayerShip.getGun1X(), mPlayerShip.getGun1Y(), 0));
				mPlayerBullets.add(new Bullet(mPlayerShip.getGun2X(), mPlayerShip.getGun2Y(), 0));
			}
			// SPREAD
			if(mPlayerShip.getGunLevel() == 3 || mPlayerShip.getGunLevel() == 4){
				mPlayerBullets.add(new Bullet(mPlayerShip.getGun1X(), mPlayerShip.getGun1Y(), 0, 5));
				mPlayerBullets.add(new Bullet(mPlayerShip.getGun2X(), mPlayerShip.getGun2Y(), 0, -5));
			}
			// TOP
			if(mPlayerShip.getGunLevel() == 2 || mPlayerShip.getGunLevel() == 3 || mPlayerShip.getGunLevel() == 4){
				mPlayerBullets.add(new Bullet(mPlayerShip.getGun3X(), mPlayerShip.getGun3Y(), 0));
			}
			return true;
		}
		else return false;
	}
	
	public void enemiesFire() {
		for(int i=0; i<mEnemies.size(); i++){
			MovableObject enemy = mEnemies.get(i);
			if(enemy.canShoot() && enemy.getX()>0){
				enemy.shoot();
				mEnemyBullets.add(new Bullet(enemy.getX()+Config.cCowCDCentreX, 
						enemy.getY()+Config.cCowCDCentreY, 1, getAngle(enemy)));
			}
		}
	}

	boolean advanceLevel(){
		if(levelProgress != levelLength){
			levelProgress++;
			while (levelSearchIndex<level.size() && level.getElement(levelSearchIndex).Xpos == levelProgress){
				this.createElement(level.getElement(levelSearchIndex));
				levelSearchIndex++;
			}
			return false;
		}
		
		else if(levelProgress == levelLength && !atBoss && currentLevel == 2){
			cowBoss = new Boss2();
			atBoss = true;
			setBossMusic = true;
			return false;
		}
		
		else if(levelProgress == levelLength && !atBoss && currentLevel == 1){
			laserBoss = new Boss1(mPlayerShip);
			atBoss = true;
			setBossMusic = true;
			return false;
		}
		else if(levelProgress == levelLength && !bossDead){
			return false;
		}
		else{
			return true;
		}
	}
	public boolean playBossMusic(){
		if(setBossMusic){
			setBossMusic = false;
			return true;
		}else{
		return false;
		}
	}
	
	// returns true if a laser is being shot, thus play the laser sound
	public boolean updateBoss(){
		
		if(atBoss && currentLevel == 2){
			cowBoss.update();
			
			// check if boss is dead
			if (cowBoss.getShield() == 0){
				bossDead = true;
				return false;
			}
			
			// check for collisions with player bullets and bear head
			if(mCollisionDetector.getCollision(cowBoss.bearHead, mPlayerBullets) != -1){
				int bulletIndex = mCollisionDetector.getCollision(cowBoss.bearHead, mPlayerBullets);
				((Bullet)mPlayerBullets.get(bulletIndex)).isDestroyed = true;
				mPlayerBullets.remove(bulletIndex);
				if(Config.difficulty==0){cowBoss.changeShield(-4);}
				else if(Config.difficulty==1){cowBoss.changeShield(-3);}	
				else{cowBoss.changeShield(-2);}
			}
			
			// check for collisions with player bullets and cow head
			if(mCollisionDetector.getCollision(cowBoss.cowHead, mPlayerBullets) != -1){
				int bulletIndex = mCollisionDetector.getCollision(cowBoss.cowHead, mPlayerBullets);
				((Bullet)mPlayerBullets.get(bulletIndex)).isDestroyed = true;
				mPlayerBullets.remove(bulletIndex);
				if(Config.difficulty==0){cowBoss.changeShield(-4);}
				else if(Config.difficulty==1){cowBoss.changeShield(-3);}	
				else{cowBoss.changeShield(-2);}
			}
			
			// check if we want to make an enemy
			if(cowBoss.canMakeEnemy()){
				MotionPath ePath = null;
				MovableObject eMovable = null;
				int cowOrBear = rand.nextInt(2);
				// make path
				if(cowOrBear == 0){	// tracking path
					if(Config.difficulty==0)	  {ePath = new TrackingPath(Config.cEnemySpeedEasy, cowBoss.getSpawnY(), cowBoss.getSpawnX(), mPlayerShip);}
					else if(Config.difficulty==1) {ePath = new TrackingPath(Config.cEnemySpeedNormal, cowBoss.getSpawnY(), cowBoss.getSpawnX(), mPlayerShip);}
					else						  {ePath = new TrackingPath(Config.cEnemySpeedHard, cowBoss.getSpawnY(), cowBoss.getSpawnX(), mPlayerShip);}
				}
				else{	// sine path
					if(Config.difficulty==0)	  {ePath = new SinePath(cowBoss.getSpawnY(), Config.cEnemySpeedEasy, 75, 150);}
					else if(Config.difficulty==1) {ePath = new SinePath(cowBoss.getSpawnY(), Config.cEnemySpeedNormal, 75, 100);}
					else						  {ePath = new SinePath(cowBoss.getSpawnY(), Config.cEnemySpeedHard, 100, 100);}
				}
				// make cow or bear
				if(cowOrBear == 0){
					eMovable = new BearEnemy(cowBoss.getSpawnX(), cowBoss.getSpawnY(), ePath);
				}
				else{
					eMovable = new CowEnemy(cowBoss.getSpawnX(), cowBoss.getSpawnY(), ePath);
				}
				mEnemies.add(eMovable);
			}
			
			// check if we want to shoot a bullet
			if(cowBoss.canShoot()){
				int cowOrBear = rand.nextInt(2);
				if(cowOrBear == 0){		//shoot from cow head
					mEnemyBullets.add(new Bullet(cowBoss.getX() + cowBoss.cowHead.collisionX, 
												 cowBoss.getY() + cowBoss.cowHead.collisionY, 1, getAngle(cowBoss.cowHead)));}
				else{		// shoot from bear head
					mEnemyBullets.add(new Bullet(cowBoss.getX() + cowBoss.bearHead.collisionX, 
							 					 cowBoss.getY() + cowBoss.bearHead.collisionY, 1, getAngle(cowBoss.bearHead)));}
			}
		}
		
		if(atBoss && currentLevel == 1){
			laserBoss.update();
			
			// check if boss is dead
			if (laserBoss.getShield() == 0){
				bossDead = true;
				return false;
			}
			
			// check for collisions with player bullets
			if(mCollisionDetector.getCollision(laserBoss, mPlayerBullets) != -1){
				//player bulled collided with boss
				int bulletIndex = mCollisionDetector.getCollision(laserBoss, mPlayerBullets);
				((Bullet)mPlayerBullets.get(bulletIndex)).isDestroyed = true;
				mPlayerBullets.remove(bulletIndex);
				// boss got hit by bullet, reduce shield
				if(Config.difficulty==0){laserBoss.changeShield(-4);}
				else if(Config.difficulty==1){laserBoss.changeShield(-3);}	
				else{laserBoss.changeShield(-2);}
			}
			
			// check if we want to make a laser
			if(laserBoss.startLaser){
				mLaser = new Laser(laserBoss.laserTop + laserBoss.getY());
				laserExists = true;
				return true;
			}
			
			// check if we want to delete the laser
			if(laserBoss.stopLaser){
				mLaser = null;
				laserExists = false;
			}
		}
		return false;
	}
	
	int getLives(){
		return lives;
	}		
	int getShield(){
		return playerShield;
	}
	void setGun(int level){
		mPlayerShip.setGunLevel(level);
	}
	int getGun(){
		return mPlayerShip.getGunLevel();
	}
	
	private void createElement(LevelElement inElement){
		MotionPath ePath = null;
		MovableObject eMovable = null;
		
		switch(inElement.path){
		// create the motion path
		case 'u':
			if(Config.difficulty==0)	  {ePath = new UnidirectionalPath(Config.cEnemySpeedEasy, inElement.pathParam1);}
			else if(Config.difficulty==1) {ePath = new UnidirectionalPath(Config.cEnemySpeedNormal, inElement.pathParam1);}
			else 						  {ePath = new UnidirectionalPath(Config.cEnemySpeedHard, inElement.pathParam1);}
			break;
		case 's':
			if(Config.difficulty==0)	  {ePath = new SinePath(inElement.Ypos, Config.cEnemySpeedEasy, inElement.pathParam1, inElement.pathParam2);}
			else if(Config.difficulty==1) {ePath = new SinePath(inElement.Ypos, Config.cEnemySpeedNormal, inElement.pathParam1, inElement.pathParam2);}
			else						  {ePath = new SinePath(inElement.Ypos, Config.cEnemySpeedHard, inElement.pathParam1, inElement.pathParam2);}
			break;
		case 't':
			if(Config.difficulty==0)	  {ePath = new TrackingPath(Config.cEnemySpeedEasy, inElement.Ypos, Config.cFrameWidth+60, mPlayerShip);}
			else if(Config.difficulty==1) {ePath = new TrackingPath(Config.cEnemySpeedNormal, inElement.Ypos, Config.cFrameWidth+60, mPlayerShip);}
			else						  {ePath = new TrackingPath(Config.cEnemySpeedHard, inElement.Ypos, Config.cFrameWidth+60, mPlayerShip);}
			break;
			
		default:
			System.out.print("invalid path in level file: ");
			System.out.println(inElement.path);
		}
		// create the element and set it's motion path
		switch(inElement.type){
		case 'c':
			eMovable = new CowEnemy(Config.cFrameWidth +100, inElement.Ypos, ePath);
			break;
		case 'b':
			eMovable = new BearEnemy(Config.cFrameWidth +100, inElement.Ypos, ePath);
			break;
		case 'a':
			eMovable = new AsteroidEnemy(Config.cFrameWidth +100, inElement.Ypos, ePath);
			break;
		
		default:
			System.out.print("invalid type in level file: ");
			System.out.println(inElement.type);
		}
		
		mEnemies.add(eMovable);
	}

	private int getAngle(MovableObject shooter){
		// first check if x positions are the same (will cause divide by zero
		// error if it happens in the arctan calculation)
		if(mPlayerShip.getX() == shooter.getX()){
			if(mPlayerShip.getY() >= shooter.getY()){return -90;}
			else{return 90;}
		}
		double angleR = Math.atan(Math.abs(mPlayerShip.getY()-shooter.getY()) 
				/ Math.abs(mPlayerShip.getX()-shooter.getX()));
		int angleD = (int)(angleR/0.01745329251994329576923690768489);
		if(mPlayerShip.getX() > shooter.getX()){
			if(mPlayerShip.getY() <= shooter.getY()){return angleD;}	// first quadrant
			else{return -angleD;}										// fourth quadrant
		}
		else{
			if(mPlayerShip.getY() <= shooter.getY()){return 180-angleD;}// second quadrant
			else{return 180 + angleD;}									// third quadrant
		}
	}
}
