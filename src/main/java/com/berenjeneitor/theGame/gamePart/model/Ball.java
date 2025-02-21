package com.berenjeneitor.theGame.gamePart.model;

import com.berenjeneitor.theGame.gamePart.GameState;

import java.awt.*;
import java.util.Random;

public class Ball implements Runnable{

    private GameModel father;
    private int x, y, diametro;
    private Color color;
    private int v_x, v_y;
    private GameState gameState = GameState.NOT_STARTED;

    public Ball(GameModel father) {
        this.father = father;

        this.color = Color.RED;
        Random rnd = new Random();
        this.diametro = rnd.nextInt(20,50);
        this.x = (father.getWidth()/2) - (diametro/2);
        this.y = (father.getHeight()/2) - (diametro/2);
        do {
            this.v_x = rnd.nextInt(-5, 5);
            this.v_y = rnd.nextInt(-5, 5);
        }
        while (v_x == 0 || v_y == 0);
    }
    public Ball(GameModel father, BallDTO ballDTO) {
        this.father = father;

        this.x = ballDTO.getX();
        this.y = ballDTO.getY();
        this.diametro = ballDTO.getDiametro();
        this.color = ballDTO.getColor();
        this.v_x = ballDTO.getV_x();
        this.v_y = ballDTO.getV_y();
    }

    @Override
    public void run() {
        while(gameState == GameState.RUNNING || gameState == GameState.PAUSED){
            try {
                if(gameState == GameState.PAUSED){
                    Thread.sleep(1);
                    continue;
                }
                Thread.sleep(5);
                mover();
                rebotar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void mover(){
        x += v_x;
        y += v_y;

    }
    private void rebotar(){
        if(chocaHorizontalmente()){
            v_x = -v_x;
        }
        if (chocaVerticalmente()) {
            v_y = -v_y;
        }
    }
    private boolean chocaHorizontalmente(){
        return (x <= 0 || x + diametro >= father.getWidth());
    }
    private boolean chocaVerticalmente(){
        return (y <= 0 || y + diametro >= father.getHeight());
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public Color getColor(){
        return this.color;
    }
    public int getDiametro(){
        return this.diametro;
    }
    public int getV_x(){
        return this.v_x;
    }
    public int getV_y(){
        return this.v_y;
    }

    public void start() {
        if(gameState == GameState.NOT_STARTED){
            gameState = GameState.RUNNING;
            Thread thread = new Thread(this);
            thread.start();
        }
    }
    public void pause() {
        if(gameState == GameState.RUNNING){
            gameState = GameState.PAUSED;
        }
    }
    public void play() {
        if(gameState == GameState.PAUSED){
            gameState = GameState.RUNNING;
        }
    }
}
