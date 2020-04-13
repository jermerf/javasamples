package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import controller.Config;

import model.GameState;
import model.Model;

public class AnimHUD implements Animated {
	private double currShield = 0;
	private BufferedImage start,pause,level,win,gameover;
	private int messageFade = 30;
	private int credits = 0;
	
	public AnimHUD(){
		pause = ImageLoader.biMaker(ImageLoader.pause);
		level = ImageLoader.biMaker(ImageLoader.levelClear);
		win = ImageLoader.biMaker(ImageLoader.win);
		gameover = ImageLoader.biMaker(ImageLoader.lose);
		start = ImageLoader.biMaker(ImageLoader.start);
	}
	@Override
	public BufferedImage getNextFrame() {
		BufferedImage tmp = new BufferedImage(Config.cFrameWidth,Config.cFrameHeight,BufferedImage.TYPE_INT_ARGB);
		currShield = currShield + (Model.getPlayerShield()-currShield-1)/10.;
		Graphics2D g2d = tmp.createGraphics();
		if(Model.getPlayerShield()==0){currShield=0;}
		if(!(Model.getGameState()==GameState.TITLE)){
			g2d.setFont(new Font("Dialog.plain",0,20));
			// Fill the shield bar
			g2d.setColor(new Color((int)(255-(currShield)*2.5),0,(int)(currShield*2.5)));
			g2d.fillRect(276, 2, (int)(currShield*3.11), 18);
			// Draw Shield Outer Box
			g2d.setColor(Color.LIGHT_GRAY);
			g2d.drawRect(275, 1, 310, 20);
			g2d.setColor(Color.GRAY);
			g2d.drawRect(276, 2, 308, 18);
			g2d.setColor(Color.WHITE);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.drawString("Score: " + String.valueOf(Model.getGameScore()), 20, 20);
			g2d.drawString("Shield: ",190, 20);
			g2d.drawString("Lives:  " + String.valueOf(Model.getLives()), 640, 20);
		}
		if(Model.getGameState()==GameState.PAUSE){
			g2d.drawImage(pause,(Config.cFrameWidth-pause.getWidth())/2, (Config.cFrameHeight-pause.getHeight())/2, null);
		}else if(Model.getGameState()==GameState.LEVEL_COMPLETE){
			g2d.drawImage(level,(Config.cFrameWidth-level.getWidth())/2, (Config.cFrameHeight-level.getHeight())/2, null);
			messageFade=30;
			credits = 0;
		}else if(Model.getGameState()==GameState.LOSE_1_LIFE){
			messageFade=30;
		}else if(Model.getGameState()==GameState.WIN){
			credits++;
			g2d.drawImage(win,(Config.cFrameWidth-win.getWidth())/2, (Config.cFrameHeight-win.getHeight())/2, null);
			g2d.setFont(new Font("Dialog.plain",0,50));
			// Draw credits
			g2d.setColor(Color.WHITE);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			int c = 0;
			g2d.drawString("Created by", 290, Config.cFrameHeight-(credits*4-50*c+++25));
			g2d.drawString("Leanne Brockerville", 200, Config.cFrameHeight-(credits*4-50*c++));
			g2d.drawString("Jermaine Francoeur", 197, Config.cFrameHeight-(credits*4-50*c++));
			c++;
			c++;
			c++;
			g2d.drawString("Graphics by", 280, Config.cFrameHeight-(credits*4-50*c+++25));
			g2d.drawString("Trevor Johnson", 240, Config.cFrameHeight-(credits*4-50*c++));
			g2d.drawString("Jermaine Francoeur", 197, Config.cFrameHeight-(credits*4-50*c++));
			c++;
			c++;
			c++;
			g2d.drawString("Special Thanks", 240, Config.cFrameHeight-(credits*4-50*c+++25));
			g2d.drawString("Andrew Vardy", 260, Config.cFrameHeight-(credits*4-50*c++));
			g2d.drawString("For the idea of Cows and Polar", 50, Config.cFrameHeight-(credits*4-50*c++));
			g2d.drawString("Bears as Enemies :)", 50, Config.cFrameHeight-(credits*4-50*c++));
			c++;
			c++;
			c++;
			c++;
			g2d.drawString("Press 'Enter'", 260, Config.cFrameHeight-(credits*4-50*c++));
			c++;
			g2d.drawString("To Return to the Title Screen", 65, Config.cFrameHeight-(credits*4-50*c++));
			if(credits>350){credits=350;}
		}else if(Model.getGameState()==GameState.GAME_OVER){
			g2d.drawImage(gameover,(Config.cFrameWidth-gameover.getWidth())/2, (Config.cFrameHeight-gameover.getHeight())/2, null);
		}else if(Model.getGameState()==GameState.GAMEPLAY&&(messageFade>0)){
			g2d.drawImage(ImageLoader.getTransparent(start, 0.03*messageFade),(Config.cFrameWidth-start.getWidth())/2, (Config.cFrameHeight-start.getHeight())/2, null);
			messageFade--;
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
//		return Config.scoreX;
	}
	
	@Override
	public int getY() {
		return 2;
//		return Config.scoreY;
	}
}