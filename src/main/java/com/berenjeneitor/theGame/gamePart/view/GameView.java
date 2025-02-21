package com.berenjeneitor.theGame.gamePart.view;

import com.berenjeneitor.theGame.gamePart.GameState;
import com.berenjeneitor.theGame.gamePart.model.Ball;
import com.berenjeneitor.theGame.gamePart.GameController;
import com.berenjeneitor.theGame.gamePart.model.BallDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import static java.lang.Thread.sleep;

public class GameView extends JFrame implements ActionListener, Runnable{

    private GameState gameState = GameState.NOT_STARTED;
    private Viewer vw;
    private ControlPanel cp;
    private final GameController father;
    public GameView(GameController father){
        vw = new Viewer(this);
        cp = new ControlPanel(this);
        this.father = father;
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.add(vw, gbc);
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(cp, gbc);
        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addComponentListener(new ResizeDetector());
        vw.createBufferStrategy(2);

    }

    @Override
    public void run() {
        while(gameState == GameState.RUNNING || gameState == GameState.PAUSED) {
            try {
                if(gameState == GameState.PAUSED){
                    Thread.sleep(1);
                    continue;
                }
                Thread.sleep(1);
                vw.paint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void start(){
        if(gameState == GameState.NOT_STARTED){
            gameState = GameState.RUNNING;
            new Thread(this).start();
        }
    }

    public void play(){
        if(gameState == GameState.PAUSED){
            gameState = GameState.RUNNING;
        }
    }

    public void pause(){
        if(gameState == GameState.RUNNING){
            gameState = GameState.PAUSED;
        }
    }
    public BallDTO[] getBalls(){
        return father.getBalls();
    }
    public int[] getViewerDimensions(){
        return new int[]{
                vw.getWidth(),
                vw.getHeight()
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var button = e.getSource();
        if(button instanceof JButton){
            String nombreBoton = ((JButton) button).getText();
            switch (nombreBoton) {
                case "Start":
                    father.start(cp.getSliderValue());
                    ((JButton) button).setText("Play");
                    break;
                case "Play":
                    father.play();
                    break;
                case "Pause":
                    father.pause();
                    break;
            }
        }
    }
    private final class ResizeDetector extends ComponentAdapter {
        @Override
        public void componentResized(ComponentEvent e) {
            father.refreshViewerDimensions();
        }
    }
}
