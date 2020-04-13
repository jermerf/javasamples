package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import controller.Config;

import model.Boss1;
import model.PlayerShip;

public class AnimBoss1 implements Animated{
	private ArrayList<BufferedImage> images;
	private Boss1 boss;
	private PlayerShip player;
	private int laser = 0;
	private int explosionFrame = -1;
	private ArrayList<AnimExplosion> e = new ArrayList<AnimExplosion>();  
	
	public AnimBoss1(Boss1 boss,PlayerShip player){
		if(images==null){images = ImageLoader.biListMaker(ImageLoader.boss1, 10);}
		this.boss=boss;
		this.player=player;
		e.add(new AnimExplosion(0,5));		//0
		e.add(new AnimExplosion(76,20));	//1
		e.add(new AnimExplosion(130,25));	//2
		e.add(new AnimExplosion(225,10));	//3
		e.add(new AnimExplosion(20,85));	//4
		e.add(new AnimExplosion(70,70));	//5
		e.add(new AnimExplosion(140,75));	//6
		e.add(new AnimExplosion(215,60));	//7
		e.add(new AnimExplosion(5,115));	//8
		e.add(new AnimExplosion(70,120));	//9
		e.add(new AnimExplosion(135,115));	//10
		e.add(new AnimExplosion(235,110));	//11
	}
	@Override
	public BufferedImage getNextFrame() {
		if(boss.isDestroyed()){
			BufferedImage tmp = new BufferedImage(images.get(laser).getWidth()+200,images.get(laser).getHeight()+200,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = tmp.createGraphics();
			g2d.drawImage(images.get(laser),boss.getX(),0, null);
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
				}
			}
			g2d.dispose();
			return tmp;
		}
		BufferedImage tmp = new BufferedImage(Config.cFrameWidth,images.get(laser).getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = tmp.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		if(boss.openGate){
			laser++;
		}else{
			laser--;
		}
		if(laser<0){laser=0;}
		if(laser>9){
			laser=9;
			BufferedImage bossLaserTile = ImageLoader.biMaker(ImageLoader.bossLaser);
			double randTrans = 0.9+0.1*Math.random();
			for(int i = 0;i<((tmp.getWidth()-150)/bossLaserTile.getWidth());i++)
				g2d.drawImage(ImageLoader.getTransparent(bossLaserTile,randTrans),i*bossLaserTile.getWidth(),1, null);
		}
		g2d.drawImage(images.get(laser),boss.getX(),0, null);
		double angle = eyeAngle();
		g2d.setColor(Color.WHITE);
		g2d.fillOval(boss.getX()+147, 88, 27,27);
		g2d.setColor(Color.RED);
		g2d.fillOval(boss.getX()+153-(int)(7*Math.cos(angle)), 94-(int)(7*Math.sin(angle)), 15,15);
		g2d.setColor(Color.BLACK);
		g2d.fillOval(boss.getX()+157-(int)(9*Math.cos(angle)), 98-(int)(9*Math.sin(angle)), 7,7);
		g2d.dispose();
		return tmp;
	}
	@Override
	public boolean canRemove() {
		return false;
	}

	private double eyeAngle(){
		return Math.atan2(boss.getY()-player.getY(), boss.getX()-player.getX());
	}
	public int getX() {
		if(boss.isDestroyed()){
			return boss.getX()-40;
		}else{
			return 0;
		}
	}
	public int getY() {
		if(boss.isDestroyed()){
			return boss.getY()-60;
		}else{
			return boss.getY();
		}
	}
}
