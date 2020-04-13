package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.Boss2;

public class AnimBoss2 implements Animated{
	
	private ArrayList<BufferedImage> images;
	private Boss2 boss;
	private int frame;
	private boolean isDestroyed = false;
	private int x,y;
	private int explosionFrame = -1;
	private boolean explosionDone = false;
	private ArrayList<AnimExplosion> e = new ArrayList<AnimExplosion>();  
	private int explodeOffsetX = 132;
	private int explodeOffsetY = 108;
	
	public AnimBoss2(Boss2 boss) {
		if(images==null){
			images = ImageLoader.biListMaker(ImageLoader.boss2,10);
			ArrayList<BufferedImage> tmp = ImageLoader.biListMaker(ImageLoader.boss2,10);
			for(int i=0;i<10;i++){images.add(tmp.get(i));}
			e.add(new AnimExplosion(120,175));	//0 upper middle
			e.add(new AnimExplosion(135,52));	//1	Cow neck
			e.add(new AnimExplosion(55,80));	//2 polar bear neck
			e.add(new AnimExplosion(150,125));	//3 left middle
			e.add(new AnimExplosion(100,115));	//4 mid front
			e.add(new AnimExplosion(105,22));	//5	on cow head
			e.add(new AnimExplosion(15,60));	//6	on polar bear head
			e.add(new AnimExplosion(215,60));	//7 Upper back
			e.add(new AnimExplosion(165,100));	//8 right middle
			e.add(new AnimExplosion(225,150));	//9 Lower back
			e.add(new AnimExplosion(185,200));	//10 back legs
			e.add(new AnimExplosion(180,150));	//11 lower middle
		}

		frame = 0;
		this.boss=boss;
		x=boss.getX();
		y=boss.getY();
	}
	
	public BufferedImage getNextFrame() {
		isDestroyed=boss.isDestroyed();
		x=boss.getX();
		y=boss.getY();
		frame++;
		if(frame>9)
			frame=0;
		if(!isDestroyed){
			return images.get(frame);
		}
		else{
			BufferedImage tmp = new BufferedImage(images.get(frame).getWidth()+explodeOffsetX,images.get(frame).getHeight()+explodeOffsetY,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = tmp.createGraphics();
			if(explosionFrame<4)
				g2d.drawImage(images.get(frame),explodeOffsetX/2,explodeOffsetY/2, null);
			explosionFrame++;
			if(!e.get(5).canRemove()){
				g2d.drawImage(e.get(5).getNextFrame(),e.get(5).getX(),e.get(5).getY(), null);
				g2d.drawImage(e.get(6).getNextFrame(),e.get(6).getX(),e.get(6).getY(), null);
			}
			if(explosionFrame>0){
				if(!e.get(1).canRemove()){
					g2d.drawImage(e.get(1).getNextFrame(),e.get(1).getX(),e.get(1).getY(), null);
					g2d.drawImage(e.get(2).getNextFrame(),e.get(2).getX(),e.get(2).getY(), null);
					g2d.drawImage(e.get(4).getNextFrame(),e.get(4).getX(),e.get(4).getY(), null);
					g2d.drawImage(e.get(7).getNextFrame(),e.get(7).getX(),e.get(7).getY(), null);
					g2d.drawImage(e.get(9).getNextFrame(),e.get(9).getX(),e.get(9).getY(), null);
					g2d.drawImage(e.get(10).getNextFrame(),e.get(10).getX(),e.get(10).getY(), null);
				}
			}
			if(explosionFrame>1){
				if(!e.get(0).canRemove()){
					g2d.drawImage(e.get(0).getNextFrame(),e.get(0).getX(),e.get(0).getY(), null);
					g2d.drawImage(e.get(3).getNextFrame(),e.get(3).getX(),e.get(3).getY(), null);
					g2d.drawImage(e.get(8).getNextFrame(),e.get(8).getX(),e.get(8).getY(), null);
					g2d.drawImage(e.get(11).getNextFrame(),e.get(11).getX(),e.get(11).getY(), null);
				}else{
					explosionDone = true;
				}
			}
			g2d.dispose();
			return tmp;
		}
	}
	
	@Override
	public int getX() {
		if(isDestroyed){
			return x-explodeOffsetX/2;
		}else{
			return x;
		}
	}

	@Override
	public int getY() {
		if(isDestroyed){
			return y-explodeOffsetY/2;
		}else{
			return y;
		}
	}

	@Override
	public boolean canRemove() {
		return explosionDone;
	}
}