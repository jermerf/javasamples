package view;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import controller.Config;

import model.GameState;
import model.Model;
import model.PlayerShip;

public class AnimPlayerShip implements Animated {
	private PlayerShip ship;
	private AnimExplosion explosion;
	private static ArrayList<BufferedImage> images;
	public AnimPlayerShip(PlayerShip ship) {
		if(images==null){images = ImageLoader.biListMaker(ImageLoader.playerShip, 19);}
		this.ship = ship;
		explosion = new AnimExplosion();
	}
	public BufferedImage getNextFrame() {
		if(Model.getGameState()!=GameState.LOSE_1_LIFE&&Model.getGameState()!=GameState.GAME_OVER){
			return images.get(9+ship.getImageOffset());
		}else{
			return explosion.getNextFrame();
		}
	}
	
	public boolean canRemove() {
		return false;
	}

	public int getX() {
		if(Model.getGameState()!=GameState.LOSE_1_LIFE&&Model.getGameState()!=GameState.GAME_OVER){
			return ship.getX();
		}else{
			return ship.getX()-Config.cShipCDCentreX;
		}
	}
	
	public int getY() {
		if(Model.getGameState()!=GameState.LOSE_1_LIFE&&Model.getGameState()!=GameState.GAME_OVER){
			return ship.getY();
		}else{
			return ship.getY()-Config.cShipCDCentreY;
		}
	}
}
