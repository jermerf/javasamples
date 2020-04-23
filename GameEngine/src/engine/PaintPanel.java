package engine;

import app.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PaintPanel extends JPanel {
    private BufferedImage buffer;

    public Graphics2D refreshBuffer(){
        buffer = new BufferedImage(Config.GAME_WIDTH,Config.GAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        return buffer.createGraphics();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(buffer,0,0, null);
        g2d.dispose();
    }
}
