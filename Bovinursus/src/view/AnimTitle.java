package view;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.Model;

public class AnimTitle implements Animated{
	private static BufferedImage titleBackground;
	private static ArrayList<BufferedImage> images;
	private int selection = 0;
	public AnimTitle(){
		if(titleBackground==null){titleBackground = ImageLoader.biMaker(ImageLoader.title);}
		if(images==null){images = ImageLoader.biListMaker(ImageLoader.menuItems, 3);}
	}
	
	@Override
	public BufferedImage getNextFrame() {
		BufferedImage tmp = ImageLoader.getCopy(titleBackground);
		Graphics2D g2d = tmp.createGraphics();
		selection = Model.getTitleSelection();
		switch(selection){
		case 0:
			g2d.drawImage(images.get(0),160,320,null);
			g2d.drawImage(ImageLoader.getTransparent(images.get(1), 0.5),160,370,null);
			g2d.drawImage(ImageLoader.getTransparent(images.get(2), 0.5),160,420,null);
			break;
		case 1:
			g2d.drawImage(ImageLoader.getTransparent(images.get(0), 0.5),160,320,null);
			g2d.drawImage(images.get(1),160,370,null);
			g2d.drawImage(ImageLoader.getTransparent(images.get(2), 0.5),160,420,null);
			break;
		case 2:
			g2d.drawImage(ImageLoader.getTransparent(images.get(0), 0.5),160,320,null);
			g2d.drawImage(ImageLoader.getTransparent(images.get(1), 0.5),160,370,null);
			g2d.drawImage(images.get(2),160,420,null);
			break;
		}
		g2d.dispose();
		return tmp;
	}

	@Override
	public boolean canRemove() {
		return false;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}
	

}