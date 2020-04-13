package view;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import controller.Config;
import model.AsteroidEnemy;
import model.BearEnemy;
import model.CowEnemy;

public class AnimEnemyObject implements Animated {
	private static ArrayList<BufferedImage> images;
	private AsteroidEnemy subjectA = null;
	private BearEnemy subjectB = null;
	private CowEnemy subjectC = null;
	private int x,y;
	private boolean isDestroyed = false;
	private int frame;
	private double astAngle;
	private AnimExplosion explosion;
	private int explodeOffsetX = Config.cCowCDCentreX + 10;
	private int explodeOffsetY = Config.cCowCDCentreY + 10;
	
	public AnimEnemyObject(AsteroidEnemy subject) {
		if(images==null){
			images = ImageLoader.biListMaker(ImageLoader.enemy1,10);
			ArrayList<BufferedImage> tmp = ImageLoader.biListMaker(ImageLoader.enemy2,10);
			for(int i=0;i<10;i++){
				images.add(tmp.get(i));
			}
			images.add(ImageLoader.biMaker(ImageLoader.asteroid));
		}
		explosion = new AnimExplosion();
		this.subjectA = subject;
		frame = 0;
		astAngle = Math.random()*3;
		explodeOffsetX += 10;
		explodeOffsetY += 10;
	}
	
	public AnimEnemyObject(BearEnemy subject) {
		if(images==null){
			images = ImageLoader.biListMaker(ImageLoader.enemy1,10);
			ArrayList<BufferedImage> tmp = ImageLoader.biListMaker(ImageLoader.enemy2,10);
			for(int i=0;i<10;i++){
				images.add(tmp.get(i));
			}
			images.add(ImageLoader.biMaker(ImageLoader.asteroid));
		}
		explosion = new AnimExplosion();
		this.subjectB = subject;
		frame = 0;
	}
	
	public AnimEnemyObject(CowEnemy subject) {
		if(images==null){
			images = ImageLoader.biListMaker(ImageLoader.enemy1,10);
			ArrayList<BufferedImage> tmp = ImageLoader.biListMaker(ImageLoader.enemy2,10);
			for(int i=0;i<10;i++){
				images.add(tmp.get(i));
			}
			images.add(ImageLoader.biMaker(ImageLoader.asteroid));
		}
		explosion = new AnimExplosion();
		this.subjectC = subject;
		frame = 10;
	}
	
	public BufferedImage getNextFrame() {
		if(!(subjectB==null)){
			isDestroyed=subjectB.isDestroyed();
			x=subjectB.getX();
			y=subjectB.getY();
			frame++;
			if(frame>9)
				frame=0;
		}else if(!(subjectC==null)){
			isDestroyed=subjectC.isDestroyed();
			x=subjectC.getX();
			y=subjectC.getY();
			frame++;
			if(frame>19)
				frame=10;
		}else{
			isDestroyed=subjectA.isDestroyed();
			x=subjectA.getX();
			y=subjectA.getY();
			frame = 20;
			astAngle+=0.01;
		}
		if(isDestroyed){
			return explosion.getNextFrame();
		}else if(subjectA==null){
			return images.get(frame);
		}else{
			BufferedImage tmp = new BufferedImage(images.get(frame).getWidth()+5,images.get(frame).getHeight()+5,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = tmp.createGraphics();
			g2d.drawImage(images.get(frame),AffineTransform.getRotateInstance(astAngle, tmp.getWidth()/2, tmp.getHeight()/2), null);
			g2d.dispose();
			return tmp;
		}
	}
	public boolean canRemove() {
		return explosion.canRemove();
	}

	@Override
	public int getX() {
		if(isDestroyed){
			return x-explodeOffsetX;
		}else{
			return x;
		}
	}

	@Override
	public int getY() {
		if(isDestroyed){
			return y-explodeOffsetY;
		}else{
			return y;
		}
	}
}
