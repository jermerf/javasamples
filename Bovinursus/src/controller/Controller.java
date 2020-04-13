/*
 * @author: Leanne
 */

package controller;

import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import model.*;
import view.*;

public class Controller{
	int kup;
	int kleft;
	int kdown;
	int kright;
	int kshoot;
	int kpause;
	int kenter;
	
	IControllerModel mModel;
	IControllerView mView;
	KeyboardInput mKeyWatcher;
	
	SoundLoader mSoundLoader;
	SoundPlayer mSoundPlayer;
	
	// constructor
	public Controller(IControllerModel inModel, IControllerView inView, KeyboardInput inKeyWatcher) {
		this.mModel = inModel;
		this.mView = inView;
		mKeyWatcher = inKeyWatcher;
		kup = mKeyWatcher.addKeyWatch(KeyEvent.VK_W);
		kleft = mKeyWatcher.addKeyWatch(KeyEvent.VK_A);
		kdown = mKeyWatcher.addKeyWatch(KeyEvent.VK_S);
		kright = mKeyWatcher.addKeyWatch(KeyEvent.VK_D);
		kshoot = mKeyWatcher.addKeyWatch(KeyEvent.VK_J);
		kpause = mKeyWatcher.addKeyWatch(KeyEvent.VK_P);
		kenter = mKeyWatcher.addKeyWatch(KeyEvent.VK_ENTER);
				
		// represent folder names		
		this.mSoundLoader = new SoundLoader();
		this.mSoundPlayer = new SoundPlayer();
		
		//Load sounds
//		Sound list
//		--------
//		0-Title Jingle
//		1-Shoot effect
//		2-Explosion effect
//		3-Pause
//		4-Lose
//		5-Win
	//  6-play level music
//		7-powerup get
//		8-switch to level2 music
//		9-switch to level1 music
//		10-switch to boss music
//		11-boss laser
//		12-end game song
		//this.mSoundLoader.addClip(new File("sounds/background.aiff"));
		//this.mSoundLoader.addClip(new File("sounds/shoot.aiff"));
		this.mSoundLoader.addClip(new File("sounds/music_title.aiff"));
		this.mSoundLoader.addClip(new File("sounds/shoot.aiff"));
		this.mSoundLoader.addClip(new File("sounds/explosion.aiff"));
		this.mSoundLoader.addClip(new File("sounds/pause.aiff"));
		this.mSoundLoader.addClip(new File("sounds/lose.aiff"));
		this.mSoundLoader.addClip(new File("sounds/win.aiff"));
		this.mSoundLoader.addClip(new File("sounds/powerup_get.wav"));
		this.mSoundLoader.addClip(new File("sounds/boss_laser.wav"));
		this.mSoundLoader.addClip(new File("sounds/game_end.wav"));
		mSoundPlayer.setMusic(new File("sounds/music_level1.mid"));
		mSoundPlayer.playSoundEffect(mSoundLoader.getClip(0));
		
	}

	public void run() {
		// timer
		int timerValue = 1000/Config.cGameSpeed;
		Timer timer = new Timer(timerValue, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Set the Keys Pressed
				if(mKeyWatcher.isPressed(kup)){mModel.setUp(true);}
				if(mKeyWatcher.isPressed(kleft)){mModel.setLeft(true);};
				if(mKeyWatcher.isPressed(kdown)){mModel.setDown(true);};
				if(mKeyWatcher.isPressed(kright)){mModel.setRight(true);};
				if(mKeyWatcher.isPressed(kshoot)){mModel.setShooting(true);};
				if(mKeyWatcher.isPressed(kpause)){mModel.setPause(true);};
				if(mKeyWatcher.isPressed(kenter)){mModel.setEnter(true);};
				// Update the model
				mModel.update();
				
				// Play Sounds
				ArrayList<Boolean> soundCommands = mModel.getSounds();
				
				if(soundCommands.get(0)){
					mSoundPlayer.stopSoundEffect(mSoundLoader.getClip(8));
				}
				if(soundCommands.get(8)){
					mSoundPlayer.setMusic(new File("sounds/music_level2.mid"));
				//	System.out.println("Setting Music");
				}
				if(soundCommands.get(9)){
					mSoundPlayer.setMusic(new File("sounds/music_level1.mid"));
				//	System.out.println("Setting Music");
				}
				if(soundCommands.get(10)){
					mSoundPlayer.setMusic(new File("sounds/boss1.mid"));
					mSoundPlayer.startMusic();
				}
				if(soundCommands.get(13)){
					mSoundPlayer.setMusic(new File("sounds/eye_boss.mid"));
					mSoundPlayer.startMusic();
				}
				if(soundCommands.get(11)){
					mSoundPlayer.playSoundEffect(mSoundLoader.getClip(7));
				}
				if(soundCommands.get(12)){
					mSoundPlayer.LoopSoundEffect(mSoundLoader.getClip(8));
				}
				for(int i = 0;i<6;i++){
					if(soundCommands.get(i)){
						mSoundPlayer.playSoundEffect(mSoundLoader.getClip(i));
					}
				}
				if(soundCommands.get(3))
					mSoundPlayer.pauseMusic();
				if(soundCommands.get(5)||soundCommands.get(4)||
						soundCommands.get(0)){
					mSoundPlayer.stopMusic();
				}
				if(soundCommands.get(6)){
					mSoundPlayer.startMusic();
					mSoundLoader.getClip(0).stop();
				}
				if(soundCommands.get(7))
					mSoundPlayer.playSoundEffect(mSoundLoader.getClip(6));
				
				// Redraw the View
				mView.repaint();
			}
		});
		timer.start();
	}
}