package game.enemies;

import game.Game;
import game.ImageLoader;

import java.awt.image.BufferedImage;

public class Sprite {
    private BufferedImage img;
    private int x = 0;
    private int y = 0;
    private int w = 20;
    private int h = 20;


    public Sprite(String name, int w, int h) {
        this.img = Game.getLoader().getImage(name);
        this.w = w;
        this.h = h;
    }

    public BufferedImage getImg() {
        return img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
