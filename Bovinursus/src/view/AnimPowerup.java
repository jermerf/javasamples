package view;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.Powerup;;

public class AnimPowerup implements Animated {
	private static ArrayList<BufferedImage> images;
	private Powerup subject;
	private int type;
	private int frame;
	public AnimPowerup(Powerup subject,int type) {
		if(images==null){
			images = ImageLoader.biListMaker(ImageLoader.powerup_blue,6);
			ArrayList<BufferedImage> tmp = ImageLoader.biListMaker(ImageLoader.powerup_red,6);
			for(int i=0;i<6;i++){images.add(tmp.get(i));}
			tmp = ImageLoader.biListMaker(ImageLoader.powerup_yellow,6);
			for(int i=0;i<6;i++){images.add(tmp.get(i));}
		}
		this.subject = subject;
		this.type = type;
		frame = 0;
	}

	public BufferedImage getNextFrame() {
		frame++;
		if(frame>5){frame=0;}
	
		return images.get(subject.getImageOffset() + frame + 6*type);
	}
	
	public boolean canRemove() {
		return subject.isDestroyed;
	}

	@Override
	public int getX() {
		return subject.getX();
	}

	@Override
	public int getY() {

		return subject.getY();
	}
}
