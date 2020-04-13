package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	private BufferedImage buffer;
	
	public GamePanel(){
		
	}
	
	public void setBuffer(BufferedImage buffer){
		this.buffer = buffer;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(buffer,0,0, null);
		g2d.dispose();
		
	}

}
