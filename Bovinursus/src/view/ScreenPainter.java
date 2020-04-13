package view;

import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

import controller.Config;

//The backBuffer is what all images are composited to.
//The background is added initially in the constructor
public class ScreenPainter {
	private JFrame frame = new JFrame("Bovinursus");
	private GamePanel panel;
	private BufferedImage background,backBuffer;

	//Constructor
	public ScreenPainter(controller.KeyboardInput keyWatcher) {
		frame.addKeyListener(keyWatcher);
		panel = new GamePanel();
		setFrameProperties();
		backBuffer = resetBuffer();
	}
	
	public void repaint() {
		panel.repaint();
		panel.setBuffer(backBuffer);
		backBuffer = resetBuffer();
	}


	
	public void addSprite(BufferedImage image, int x, int y) {
		Graphics2D g2d = backBuffer.createGraphics();
		g2d.drawImage(image,x,y,null);		
		g2d.dispose();
	}
	
	public void addSprite(Animated anim) {
		addSprite(anim.getNextFrame(), anim.getX(), anim.getY());
	}
	
	public void setBackground(BufferedImage background){
		this.background = background;
	}
	
	//Resets the backBuffer so it contains only the background
	private BufferedImage resetBuffer(){
		BufferedImage blankBI = new BufferedImage(Config.cFrameWidth,Config.cFrameHeight,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = blankBI.createGraphics();
		g2d.drawImage(background,0,0, null);
		g2d.dispose();
		return blankBI;
	}
	private void setFrameProperties(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Config.cFrameWidth,Config.cFrameHeight);
		frame.setResizable(false);
		frame.add(panel);
		frame.setVisible(true);
		try{
			frame.setIconImage(javax.imageio.ImageIO.read(new java.io.File("images/icon.png")));
		}catch(Exception e){
			System.out.println("ScreenPainter: "+ e.getMessage());
		}
	}
	
}
