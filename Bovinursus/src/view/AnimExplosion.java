package view;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimExplosion implements Animated{
	private static ArrayList<BufferedImage> images;
	private int frame = -1;
	private int x,y;
	public AnimExplosion(){
		if(images==null){images = ImageLoader.biListMaker(ImageLoader.explosion, 10);}
		this.x=0;
		this.y=0;
	}
	public AnimExplosion(int x,int y){
		this.x=x;
		this.y=y;
		if(images==null){images = ImageLoader.biListMaker(ImageLoader.explosion, 10);}
	}
	
	@Override
	public BufferedImage getNextFrame() {
		frame++;
		if(frame>8){frame=9;}
		return images.get(frame);
	}

	@Override
	public boolean canRemove() {
		return frame>8;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	

}
