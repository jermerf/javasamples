package game;

import engine.PaintPanel;
import game.enemies.Asteroid;
import game.enemies.Dragon;

import java.awt.*;
import java.util.Random;


public class Game {
    private static ImageLoader loader;
    private PaintPanel painter;

    private Sprite[] sprites;

    public Game(PaintPanel painter){
        this.painter = painter;
        loader = new ImageLoader();
        sprites = new Sprite[100];
        for(int i=0; i<sprites.length; i++) {
            if(i%2==0){
                sprites[i] = new Asteroid();
            }else {
                sprites[i] = new Dragon();
            }
        }
    }

    public static ImageLoader getLoader() {
        return loader;
    }

    public void nextFrame(double time) {
        Graphics2D g = painter.refreshBuffer();
        Random rnd = new Random();
        for(int i=0; i<sprites.length; i++) {
            Sprite s = sprites[i];
            g.drawImage(s.getImg(), s.getX(), s.getY(), s.getW(), s.getH(), null);
            s.setX(s.getX() + rnd.nextInt(10)-4);
            s.setY(s.getY() + rnd.nextInt(10)-4);
        }

        g.dispose();
        painter.repaint();
    }
}
