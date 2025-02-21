package com.berenjeneitor.theGame.gamePart.view;

import com.berenjeneitor.theGame.gamePart.model.BallDTO;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Viewer extends Canvas {
    private final GameView father;
    public Viewer(GameView father){
        this.father = father;
        this.setBackground(Color.WHITE);
    }
    public void paint(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            System.out.println("kagada");
            return;
        }

        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
        g2d.clearRect(0, 0, getWidth(), getHeight());
        for(BallDTO ballDTO : father.getBalls()) {
            g2d.setColor(ballDTO.getColor());
            g2d.fillOval(ballDTO.getX(), ballDTO.getY(), ballDTO.getDiametro(), ballDTO.getDiametro());
        }
        bs.show();
        g2d.dispose();
    }

}
