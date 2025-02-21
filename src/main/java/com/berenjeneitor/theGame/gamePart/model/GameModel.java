package com.berenjeneitor.theGame.gamePart.model;

import com.berenjeneitor.theGame.gamePart.GameController;
import com.berenjeneitor.theGame.gamePart.GameState;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    private final List<Ball> balls;
    private GameState gameState = GameState.NOT_STARTED;
    private final GameController father;

    public void setWidth(int width) {
        this.width = width;
    }

    // dimensiones del viewer
    private int width;
    private int height;

    public GameModel(GameController father){
        this.father = father;
        balls = new ArrayList<>();

    }
    public void start(int initialBalls){
        if(gameState == GameState.NOT_STARTED){
            gameState = GameState.RUNNING;
            father.refreshViewerDimensions();
            for (int i = 0; i < initialBalls; i++){
                Ball ball = new Ball(this);
                balls.add(ball);
            }
            for(Ball b : balls){
                b.start();
            }
        }
    }

    public void pause(){
        if(gameState == GameState.RUNNING){
            gameState = GameState.PAUSED;
            for (Ball b : balls){
                b.pause();
            }
        }
    }
    public void play(){
        if(gameState == GameState.PAUSED){
            gameState = GameState.RUNNING;
            for (Ball b : balls){
                b.play();
            }
        }
    }

    public BallDTO[] getBalls() {
        BallDTO[] ballDTOList = new BallDTO[balls.size()];
        for (int i = 0; i < balls.size(); i++) {
            ballDTOList[i] = new BallDTO(balls.get(i));
        }
        return ballDTOList;
    }

}
