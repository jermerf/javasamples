package controller;

public class Config {
	
/*************************** GAME PARAMETERS *****************************/
	
	// game speed
	public static final int cGameSpeed = 30; 			// frames per second
	public static final int cStationarySpeed = 5;
	// number of levels currently in existence
	public static final int cNumberOfLevels = 2;
	// frame size
	public static final int cFrameHeight = 600;
	public static final int cFrameWidth = 800;
	
	// 0=easy, 1=normal, 2=hard;
	public static int difficulty = 1;

/***************************** PLAYER SHIP *******************************/

	public static final int cShipSpeed = 10;			// pixels per update
	public static final int cShipShootDelay = 5;		// one bullet every 5 updates

	// Variables for collision detection
	public static final int cShipCDCentreX = 54;		// centre of ship relative to tl corner
	public static final int cShipCDCentreY = 45;		// of image
	public static final int cShipCollisionRadius = 22;
	
	// distance between top left corner of ship and where player's bullets are created
	public static final int cShipGun1X = 60;
	public static final int cShipGun1Y = 56;
	public static final int cShipGun2X = 66;
	public static final int cShipGun2Y = 48;
	public static final int cShipGun3X = 42;
	public static final int cShipGun3Y = 16;
	
	// player ship's bullets
	public static final int cShipBulletSpeed = 24;
	public static final int cBulletCDCentreX = 8;
	public static final int cBulletCDCentreY = 8;
	public static final int cBulletCDRadius = 3;
	

/****************************** ENEMIES **********************************/
	
	public static final int cEnemySpeedEasy = 7;
	public static final int cEnemySpeedNormal = 10;  // 10 pixels per update
	public static final int cEnemySpeedHard = 13;
	
	public static final int cEnemyExplosionLength = 10;
	
	// damage from enemy collision
	public static final int cEnemyHitDamageE = -15;
	public static final int cEnemyHitDamageN = -20;
	public static final int cEnemyHitDamageH = -25;
	
	// collision detection BEAR
	public static final int cBearCDCentreX = 50;
	public static final int cBearCDCentreY = 32;
	public static final int cBearCollisionRadius = 23;
	
	// collision detection ASTEROID
	public static final int cAsteroidCDCentreX = 29;
	public static final int cAsteroidCDCentreY = 30;
	public static final int cAsteroidCollisionRadius = 20;
	
	// collision detection COW
	public static final int cCowCDCentreX = 49;
	public static final int cCowCDCentreY = 41;
	public static final int cCowCollisionRadius = 20;
	
	// enemy bullets
	public static final int cEnemyBulletSpeedN = 10;
	// gun fire rate
	public static final int cEnemyShootDelayEasy = 65;
	public static final int cEnemyShootDelayNormal = 40;
	public static final int cEnemyShootDelayHard = 30;
	// damage from bullets
	public static final int cEnemyBulletDamageE = -5;
	public static final int cEnemyBulletDamageN = -10;
	public static final int cEnemyBulletDamageH = -15;
	// bullet collision detection
	public static final int EnemyBulletCDCentreX = 11;
	public static final int EnemyBulletCDCentreY = 11;
	public static final int EnemyBulletCDRadius = 6;
	
/****************************** Powerups **********************************/
	
	// Powerups
	public static final int cPowerupCDCentreX = 19;
	public static final int cPowerupCDCentreY = 17;
	public static final int cPowerupCDRadius = 10;
	public static final double cPowerupProbability = .1; // 1.0 = 100% chance of creation of a powerup being made
	
/******************** Image List Offsets **********************************/
	public static final int playerImageBase = 14;
	public static final int bulletImageBase = 24;
	public static final int enemyImageBase = 34;
	public static final int explosionImageBase = 54;
	public static final int powerupImageBase = 64;
	
/*********************** Miscellaneous **********************************/
	public static final int scoreX = 200;
	public static final int scoreY = 20;
}
