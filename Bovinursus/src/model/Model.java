package model;

import controller.Config;
import java.util.*;
public class Model implements IControllerModel, IViewModel {
	
	private int mStateTimer;
	private int mPauseDelay;
	private int mCurrentLevel;
	
	private boolean mUp, mDown, mLeft, mRight;
	private boolean mPause, mShoot;
	private boolean mEnter;
	private boolean mEnterHold = true;
	private boolean upHold = false;
	private boolean downHold = false;
	
	private static int titleSelection = 0;
	private static int playerShield;
	private static int score;
	private static int lives;
	private static int gunLevel;
	
//	Sound list - to be reset each frème
//	--------
//	0-Title Jingle
//	1-Shoot effect
//	2-Explosion effect
//	3-Pause
//	4-Lose
//	5-Win
//  6-play level music
//	7-powerup get
//	8-switch to level2 music
//	9-switch to level1 music
//	10-switch to boss music
//	11-boss cow
//	12-Game End
//	13-boss laser
	private ArrayList<Boolean> sounds;
	
	private static GameState mGameState;
	private PlayObjects mLevelObjects;
	
	// PUBLIC METHODS
	
	//constructor
	public Model() {
		mGameState = GameState.TITLE;
		mCurrentLevel = 1;
		mStateTimer = 0;
		mPauseDelay = 0;
		mUp = false;
		mDown = false;
		mLeft = false;
		mRight = false;
		mPause = false;
		mShoot = false;
		sounds = new ArrayList<Boolean>();
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		sounds.add(false);
		score = 0;
		lives = 3;
		gunLevel = 0;
	}
	
	// model's own method
	public void update() {
		
		for(int i = 0; i < sounds.size();i++)
			sounds.set(i,false);
		
		switch (mGameState){
		
			//******************** TITLE ********************************************
		
			case TITLE:
				if(mUp && !upHold && titleSelection>0){
					titleSelection--;
				}
				if(mDown && !downHold && titleSelection<2){
					titleSelection++;
				}

				if(mEnter&&!mEnterHold) {
					this.startGameplay(mCurrentLevel);
					mStateTimer = 0;
					Config.difficulty = titleSelection;
					if(Config.difficulty == 0){lives=4;}
					else if(Config.difficulty == 1){lives=3;}
					else{lives=1;}
					mGameState = GameState.GAMEPLAY;
					sounds.set(9, true);
					sounds.set(6, true);
				}
				mEnterHold = mEnter;
				upHold = mUp;
				downHold = mDown;
				break;
			
			//******************** GAMEPLAY *******************************************
				
			case GAMEPLAY:
				
				// check if the player has collided with an enemy
				int tmpShield = playerShield;
				playerShield = mLevelObjects.checkShipCollision();
				if(tmpShield!=playerShield&&playerShield!=100){sounds.set(2, true);}
				if(playerShield <= 0){
					if(lives == 0){
						mStateTimer = 0;
						mGameState = GameState.GAME_OVER;
						sounds.set(4, true);
					}
					else{
						mStateTimer = 0;
						mGameState = GameState.LOSE_1_LIFE;
						sounds.set(4, true);
						if(mCurrentLevel ==2) sounds.set(8, true);
						if(mCurrentLevel ==1) sounds.set(9, true);
					}
				}
				// check collisions
				int enemiesKilled = mLevelObjects.collideEnemies();
				if(enemiesKilled >0){
					sounds.set(2, true);
					score = score + enemiesKilled*100;
				}
				
				if(mLevelObjects.playerGetPowerup()){
					playerShield = mLevelObjects.getShield();
					lives = lives + mLevelObjects.getLives();
					gunLevel = mLevelObjects.getGun();
					sounds.set(7, true);
				}
				
				// move objects
				mLevelObjects.moveObjects(mUp, mDown, mLeft, mRight);
				
				// player fires bullet
				if(mShoot) {
					if(mLevelObjects.playerFire()) {sounds.set(1,true);}
				}
				
				// enemies fire bullets
				mLevelObjects.enemiesFire();
				
				// check for pause
				if(mPauseDelay == 0 && mPause){
					mGameState = GameState.PAUSE;
					mPauseDelay = Config.cGameSpeed/3;
					sounds.set(3, true);
				}
				//Play boss music
				if(mLevelObjects.playBossMusic()){
					//System.out.println("BOSSIFY");
					if(mCurrentLevel == 1){sounds.set(13, true);}
					else{sounds.set(10, true);}
				}
				
				// update the boss
				if(mLevelObjects.updateBoss()){
					sounds.set(11, true);
				}
				
				// advance the level
				if(mLevelObjects.advanceLevel()){;
					// we have reached the end of the current level
					mStateTimer = 0;
					mGameState = GameState.LEVEL_COMPLETE;
					sounds.set(5, true);
				}
				break;
			
			//******************** LOSE 1 LIFE *********************************************
				
			case LOSE_1_LIFE:
				// stay in this state for 5 seconds then go to TITLE state
				if(mStateTimer < Config.cGameSpeed*5) {mStateTimer++;}
				else {
					mStateTimer = 0;
					mGameState = GameState.GAMEPLAY;
					sounds.set(6, true);
					view.Animations.clear();
					this.startGameplay(mCurrentLevel);
					lives--;
				}
				break;
				
			//******************** GAME OVER *********************************************
				
			case GAME_OVER:
				// stay in this state for 5 seconds then go to TITLE state
				if(mStateTimer < Config.cGameSpeed*5) {mStateTimer++;}
				else {
					mStateTimer = 0;
					mGameState = GameState.TITLE;
					sounds.set(0, true);
					score = 0;
					gunLevel = 0;
					mCurrentLevel = 1;
				}
				break;
			
			//******************** LEVEL COMPLETE ******************************************
				
			case LEVEL_COMPLETE:
				// stay in this state for 5 seconds then go to TITLE state
				if(mStateTimer < Config.cGameSpeed*5) {mStateTimer++;}
				else{
					
					if(mCurrentLevel == Config.cNumberOfLevels){
						mStateTimer = 0;
						mGameState = GameState.WIN;
						sounds.set(12, true);
					}
					else{
						mCurrentLevel++;
						view.Animations.clear();
						this.startGameplay(mCurrentLevel);
						mLevelObjects.setGun(gunLevel);
						mStateTimer = 0;
						mGameState = GameState.GAMEPLAY;
						sounds.set(6, true);
						sounds.set(8, true);
					}
				}
				mLevelObjects.moveObjects(mUp, mDown, mLeft, mRight);
				if(mShoot) {
					if(mLevelObjects.playerFire()) {sounds.set(1,true);}
				}
				break;
			
			//******************** WIN ******************************************
				
			case WIN:
				// stay in this state for 5 seconds then wait for enter to be pressed
				if(mStateTimer < Config.cGameSpeed*5) {mStateTimer++;}
				else {
					if(mEnter){
						mStateTimer = 0;
						mGameState = GameState.TITLE;
						sounds.set(0, true);
						sounds.set(9, true);
						score = 0;
						gunLevel = 0;
						mCurrentLevel = 1;
					}
				}
				break;
				
			//******************** PAUSE ***************************************************
				
			case PAUSE:
				// stay in this state until pause is pressed
				if(mPauseDelay == 0 && mPause){
					mGameState = GameState.GAMEPLAY;
					mPauseDelay = Config.cGameSpeed/3;
					sounds.set(3, true);
				}
				break;
			
			default:
				System.out.println("Invalid state");
				break;
		}
		
		if (mPauseDelay > 0) {mPauseDelay--;}

		mUp = false;
		mDown = false;
		mLeft = false;
		mRight = false;
		mPause = false;
		mShoot = false;
		mEnter = false;
	}
		
	// methods from IViewModel
	public GameState getState() {
		return mGameState;
	}
	public static GameState getGameState() {
		return mGameState;
	}
	
	public int getScore(){
		return score;
	}
	
	public static int getGameScore(){
		return score;
	}
	
	public static int getTitleSelection(){
		return titleSelection;
	}
	
	public static int getPlayerShield(){
		return playerShield;
	}
	
	public static int getLives(){
		return lives;
	}
	
	// methods from IControllerModel
	public void setUp(boolean upKey) {
		mUp = upKey;
	}

	public void setLeft(boolean leftKey) {
		mLeft = leftKey;
	}

	public void setDown(boolean downKey) {
		mDown = downKey;
	}

	public void setRight(boolean rightKey) {
		mRight = rightKey;
	}

	public void setShooting(boolean jKey) {
		mShoot = jKey;
	}

	public void setPause(boolean paused) {
		mPause = paused;
	}
	
	public void setEnter(boolean enter) {
		mEnter = enter;
	}
	
	@Override
	public ArrayList<Boolean> getSounds() {
		return sounds;
	}
	
	// PRIVATE METHODS
	
	// when more levels are added, pass an int representing level index to this method's parameters
	private void startGameplay(int level) {
		mLevelObjects = new PlayObjects(level);
	}

}

