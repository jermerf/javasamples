package engine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Config;
import game.Game;

public class MainWindow extends JFrame{
    private PaintPanel painter;
    private Game game;

    public MainWindow(){
        painter = new PaintPanel();
        game = new Game(painter);
        setTitle(Config.GAME_TITLE);
        setContentPane(painter);
        setSize(Config.GAME_WIDTH,Config.GAME_HEIGHT);
        // Exits program when window closes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frameTimer.start();
        setVisible(true);
    }

    Timer frameTimer = new Timer(Config.FRAMETIME, (ActionEvent ev) -> {
        game.nextFrame(Config.FRAMETIME);
    });



}
