package controller;
import java.util.ArrayList;
import java.io.*;
import javax.sound.sampled.*;

public class SoundLoader {
	private ArrayList<Clip> sounds;
	
	public SoundLoader(){
		sounds = new ArrayList<Clip>();
	}
	
	public Clip getClip(int i) {
		return sounds.get(i);
	}
	
	public void addClip(File file) {
		try{
			Clip tmp = AudioSystem.getClip();
			tmp.open(AudioSystem.getAudioInputStream(file));
			sounds.add(tmp);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
}
