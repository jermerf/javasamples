/*
Classes implementing Animated can be very complex and highly specialized.
For that reason Animated objects may draw from almost anywhere in the program.
*/
package view;
import java.awt.image.BufferedImage;

public interface Animated {
	public BufferedImage getNextFrame();
	public boolean canRemove();
	public int getX();
	public int getY();
	
}
