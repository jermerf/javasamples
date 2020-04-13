package model;
import java.util.ArrayList;

public class CollisionDetection {
	
	public int getCollision(RectangularObject rect, ArrayList<MovableObject> others) {
		//If a collision is detected return the index of the movable object that collided with the subject
		for(int i=0; i < others.size(); i++){
			if(checkCollision(rect, others.get(i))){
				return i;
			}
		}
		return -1;
	}
	
	public int getCollision(MovableObject subject, ArrayList<MovableObject> others) {
		
		//If a collision is detected return the index of the movable object that collided with the subject
		for(int i=0; i < others.size(); i++){
			if(checkCollision(subject, others.get(i))){
				return i;
			}
		}
		return -1;
	}
	
	public boolean checkCollision(RectangularObject rect, MovableObject circ) {;
	//System.out.println(rect.getTop());
	if(!(rect.getLeft()-circ.getCollisionRadius()<(circ.getX() + circ.getCollisionX()))){return false;}
	if(!(rect.getRight()+circ.getCollisionRadius()>(circ.getX() + circ.getCollisionX()))){return false;}
	if(!(rect.getTop()-circ.getCollisionRadius()<(circ.getY() + circ.getCollisionY()))){return false;}
	if(!(rect.getBottom()+circ.getCollisionRadius()>(circ.getY() + circ.getCollisionY()))){return false;}
	return true;
}
	
	public boolean checkCollision(MovableObject object1, MovableObject object2){
		
		// calculate the minimum possible distance between objects before collision
		double minDistance = object1.getCollisionRadius() + object2.getCollisionRadius();
		
		// calculate the actual distance between the objects
		
		double xDiff = Math.abs(object1.getX() + object1.getCollisionX() - object2.getX() - object2.getCollisionX());
		double yDiff = Math.abs(object1.getY() + object1.getCollisionY() - object2.getY() - object2.getCollisionY());
		double distance = Math.sqrt( xDiff*xDiff + yDiff*yDiff );	// use Pythagorous
		
		// compare
		if (distance < minDistance) {return true;}
		else {return false;}
	}

}
