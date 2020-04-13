package controller;

import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener{

	ArrayList<Integer> keycode = new ArrayList<Integer>();		//Key being watched
	ArrayList<Boolean> isPressed = new ArrayList<Boolean>();	//Key is currently pressed
	public void keyPressed(KeyEvent e) {
		for(int i = 0; i < keycode.size(); i++){
			if(e.getKeyCode()==keycode.get(i)){
				isPressed.set(i,true);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		for(int i = 0; i < keycode.size(); i++){
			if(e.getKeyCode()==keycode.get(i)){
				isPressed.set(i,false);
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		//This doesn't have to do anything. 
		//It's only here to implement KeyListener 
	}
	public int addKeyWatch(int k){
		keycode.add(k);
		isPressed.add(false);
//		System.out.println(keycode.size() - 1);
//		System.out.println(k);
		return keycode.size() - 1; 
	}
	public boolean isPressed(int keyCode){//Use java.awt.event.KeyEvent.VK_"key"
//		System.out.print("Up: ");
//		System.out.print(isPressed.get(0));
//		System.out.print("\tLeft: ");
//		System.out.print(isPressed.get(1));
//		System.out.print("\tDown: ");
//		System.out.print(isPressed.get(2));
//		System.out.print("\tRight: ");
//		System.out.println(isPressed.get(3));
		
		return isPressed.get(keyCode);
	}
}
