package view;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageLoader {
	public static final String menuItems = "images/menu.png";
	public static final String title = "images/title.png";
	public static final String star = "images/back_star.png";
	public static final String background = "images/background.png";
	public static final String start = "images/start.png";
	public static final String pause = "images/pause.png";
	public static final String lose = "images/lose.png";
	public static final String win = "images/win.png";
	public static final String playerShip = "images/player.png";
	public static final String bulletPlayer = "images/bulletPlayer.png";
	public static final String bulletEnemy = "images/bulletEnemy.png";
	public static final String enemy1 = "images/enemy1.png";
	public static final String enemy2 = "images/enemy2.png";
	public static final String asteroid = "images/asteroid.png";
	public static final String explosion = "images/explosion.png";
	public static final String powerup_blue = "images/powerup_blue.png";
	public static final String powerup_yellow = "images/powerup_yellow.png";
	public static final String powerup_red = "images/powerup_red.png";
	public static final String boss1 = "images/boss1.png";
	public static final String boss2 = "images/dragon.png";
	public static final String bossLaser = "images/bosslasertile.png";
	public static final String levelClear = "images/levelend.png";
	
	public static BufferedImage biMaker(String filename){
		BufferedImage biTemp;
        try {
            biTemp = ImageIO.read(new File(filename));
        } catch (Exception e) {
        	System.out.println("ImageLoader: "+e.getMessage());
        	System.out.println(filename);
        	return null;
        }
        return biTemp;
	}
	public static ArrayList<BufferedImage> biListMaker(String filename,int frames){
		ArrayList<BufferedImage> alTemp = new ArrayList<BufferedImage>();
		BufferedImage biTemp;
        try {
            biTemp = ImageIO.read(new File(filename));
        } catch (Exception e) {
        	System.out.println("ImageLoader: "+e.getMessage());
        	System.out.println(filename);
        	return null;
        }
		int w,h; //Width and height of each frame;
        w = biTemp.getWidth();
        h = biTemp.getHeight() / frames;
        for(int i = 0; i<frames;i++)
        	alTemp.add(biTemp.getSubimage(0, i*h, w, h));
        return alTemp;
	}
	public static BufferedImage biOverlay(BufferedImage base,BufferedImage overlay,int x, int y){
		int w,h;
		if(base.getWidth()>overlay.getWidth()){
			w = base.getWidth()+x;
		}else{
			w = overlay.getWidth()+x;
		}
		if(base.getHeight()>overlay.getHeight()){
			h = base.getHeight()+y;
		}else{
			h = overlay.getHeight()+y;
		}
		BufferedImage tmp = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = tmp.createGraphics();
		g2d.drawImage(base,0,0, null);
		g2d.drawImage(overlay,x,y, null);
		g2d.dispose();
		return tmp;
	}
	public static BufferedImage getCopy(BufferedImage base){
		BufferedImage tmp = new BufferedImage(base.getWidth(),base.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = tmp.createGraphics();
		g2d.drawImage(base,0,0, null);
		g2d.dispose();
		return tmp;
	}
	public static BufferedImage getTransparent(BufferedImage base,double trans){
		BufferedImage tmp = new BufferedImage(base.getWidth(),base.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = tmp.createGraphics();
		g2d.setComposite (AlphaComposite.getInstance (AlphaComposite.SRC_OVER,(float)trans));
		g2d.drawImage(base,0,0, null);
		g2d.dispose();
		return tmp;
	}

}
