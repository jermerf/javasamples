package engine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import app.Config;

public class MainWindow extends JFrame{

    private PaintPanel painter;
    private BufferedImage buffer;
    File asteroid = new File("asteroid.png");

    public MainWindow(){
        setTitle(Config.GAME_TITLE);
        buffer = freshBuffer();
        painter = new PaintPanel();
        setContentPane(painter);
        setSize(Config.GAME_WIDTH,Config.GAME_HEIGHT);
        setVisible(true);

        JButton btn = new JButton("Redraw");
        btn.addActionListener(btnClicked);
        painter.add(btn);
    }

    ActionListener btnClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                painter.setBuffer(buffer);
                BufferedImage asteroidImg = ImageIO.read(asteroid);
                Graphics2D g2d = buffer.createGraphics();
                g2d.drawImage(asteroidImg, 100, 100, null);
                g2d.dispose();
            }catch(Exception ex) {
                //TODO Handle this better
            }
        }
    };

    private BufferedImage freshBuffer(){
        BufferedImage blankBI = new BufferedImage(Config.GAME_WIDTH,Config.GAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        return blankBI;
    }

}
