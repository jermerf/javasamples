package view;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.Bullet;

public class AnimPlayerBullet implements Animated {
	private Bullet subject;
	private static ArrayList<BufferedImage> images;
	private int frame = 0;
	private int imageOffset = 0;
	
	public AnimPlayerBullet(Bullet subject, int type) {
		if(images==null){
			images = ImageLoader.biListMaker(ImageLoader.bulletPlayer, 5);
			ArrayList<BufferedImage> tmp = ImageLoader.biListMaker(ImageLoader.bulletEnemy,5);
			for(int i=0;i<5;i++){images.add(tmp.get(i));}
		}
		this.subject = subject;
		imageOffset = 5*type;
	}
	
	public BufferedImage getNextFrame() {
		frame++;
		if(frame>4)
			frame = 0;
		return images.get(imageOffset + frame);
	}
	
	public boolean canRemove() {
		return subject.isDestroyed;
	}

	public int getX() {
		return subject.getX();
	}
	
	public int getY() {
		return subject.getY();
	}
}
