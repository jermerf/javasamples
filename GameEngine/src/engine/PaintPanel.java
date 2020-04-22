package engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PaintPanel extends JPanel {

    private BufferedImage buffer;

    public void setBuffer(BufferedImage buffer){
        this.buffer = buffer;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(buffer,0,0, null);
        g2d.dispose();
    }
}
