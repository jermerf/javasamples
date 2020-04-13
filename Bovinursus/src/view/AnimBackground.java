package view;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import model.GameState;
import model.Model;
import controller.Config;

public class AnimBackground implements Animated {
	private BufferedImage star,background;
	private ArrayList<Integer> starsX,starsY,starsSpeed;
	private Random rand = new Random();
	private double pausePhase=4.7123889;
	private GameState state;
	public AnimBackground() {
		starsX = new ArrayList<Integer>();
		starsY = new ArrayList<Integer>();
		starsSpeed = new ArrayList<Integer>();
		state = Model.getGameState();
		if(star==null){
			star = ImageLoader.biMaker(ImageLoader.star);
		}
		if(background==null){
			background = ImageLoader.biMaker(ImageLoader.background);
		}
		for(int i=0;i<80;i++){
			starsX.add(rand.nextInt(Config.cFrameWidth));
			starsY.add(rand.nextInt(Config.cFrameHeight));
			starsSpeed.add(1+rand.nextInt(3));
		}
	}
	
	public BufferedImage getNextFrame(){
		BufferedImage tmp = new BufferedImage(Config.cFrameWidth,Config.cFrameHeight,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = tmp.createGraphics();
		g2d.drawImage(background,0,0, null);
		if(state==GameState.PAUSE&&Model.getGameState()!=GameState.PAUSE){
			for(int i=0;i<starsX.size();i++){
				starsX.set(i, starsX.get(i)+(int)(8*starsSpeed.get(i)*Math.cos(pausePhase)));
				starsY.set(i,starsY.get(i)+(int)(8*starsSpeed.get(i)*(1+Math.sin(pausePhase))));
			}
		}
		state=Model.getGameState();
		if(Model.getGameState()==GameState.PAUSE){
			for(int i=0;i<starsX.size();i++)
				g2d.drawImage(star,starsX.get(i)+(int)(8*starsSpeed.get(i)*Math.cos(pausePhase)),starsY.get(i)+(int)(8*starsSpeed.get(i)*(1+Math.sin(pausePhase))), null);	
			pausePhase=pausePhase-0.1;
			if(pausePhase<-6.1){pausePhase=0;}
		}else{
			pausePhase=4.7123889;
			if(rand.nextInt(100)<20){
				starsX.add(Config.cFrameWidth+10);
				starsY.add(rand.nextInt(Config.cFrameWidth));
				starsSpeed.add(1+rand.nextInt(3));
			}
			for(int i=0;i<starsX.size();i++){
				g2d.drawImage(star,starsX.get(i),starsY.get(i), null);			
				starsX.set(i, starsX.get(i)-starsSpeed.get(i));
				if(starsX.get(i)<-5){
					starsX.remove(i);
					starsY.remove(i);
					starsSpeed.remove(i);
					i--;
				}
			}
		}
		g2d.dispose();
		return tmp;
	}

	public boolean canRemove(){
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
