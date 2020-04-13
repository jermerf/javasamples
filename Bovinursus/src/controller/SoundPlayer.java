package controller;
import javax.sound.sampled.*;
import javax.sound.midi.*;

import java.io.*;

public class SoundPlayer {
	Sequencer music;
	public void playSoundEffect(Clip sound) {
		sound.setFramePosition(0);
		sound.start();
	}
	public void stopSoundEffect(Clip sound) {
		sound.stop();
	}
	public void setMusic(File song) {
		try{
			if(!(music==null))
					stopMusic();
			music = MidiSystem.getSequencer();
			music.open();
			music.setSequence(MidiSystem.getSequence(song));
			music.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		}catch(Exception e){
			
		}
	}
	public void pauseMusic(){
		if(music.isRunning()){
			music.stop();
		}else{
			music.start();
		}
	}
	
	public void stopMusic(){music.stop();}
	
	public void startMusic(){
		music.setTickPosition(0);
		music.start();
	}
	public void LoopSoundEffect(Clip sound) {
		sound.setFramePosition(0);
		sound.loop(Clip.LOOP_CONTINUOUSLY);
	}
}