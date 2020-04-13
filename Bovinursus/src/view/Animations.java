package view;
import java.util.ArrayList;

public class Animations {
	private static ArrayList<Animated> animations = new ArrayList<Animated>(); //NULL
	public static void add(Animated anim){
		animations.add(anim);
	}
	
	public static int getCount(){
		for(int i = 0; i < animations.size();i++){
			if(animations.get(i).canRemove()){
				animations.remove(i);
				//i--; 	//because there could be more than one thing to remove in a row
						//which would cause the size of 'animations' to change
			}
		}
		return animations.size();
	}
	
	public static Animated getAnimated(int i){
		return animations.get(i);
	}
	public static void clear(){
		animations.clear();
	}
}
