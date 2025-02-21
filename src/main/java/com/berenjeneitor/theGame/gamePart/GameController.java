package com.berenjeneitor.theGame.gamePart;

import com.berenjeneitor.theGame.gamePart.model.Ball;
import com.berenjeneitor.theGame.gamePart.model.BallDTO;
import com.berenjeneitor.theGame.gamePart.model.GameModel;
import com.berenjeneitor.theGame.gamePart.view.GameView;

import java.util.List;

public class GameController {
    private GameModel gm;
    private GameView gv;
    private GameState gameState = GameState.NOT_STARTED;

    public GameController(){
        this.gv = new GameView(this);
        this.gm = new GameModel(this);
    }
    public void start(int initialBalls){
        if(gameState == GameState.NOT_STARTED){
            gameState = GameState.RUNNING;
            gm.start(initialBalls);
            gv.start();
        }
    }

    public void play(){
        if(gameState == GameState.PAUSED){
            gameState = GameState.RUNNING;
            gm.play();
            gv.play();
        }
    }

    public void pause(){
        if(gameState == GameState.RUNNING){
            gameState = GameState.PAUSED;
            gm.pause();
            gv.pause();
        }
    }
    public BallDTO[] getBalls(){
        return gm.getBalls();
    }
    public void refreshViewerDimensions(){
        int[] dimensions = gv.getViewerDimensions();
        gm.setWidth(dimensions[0]);
        gm.setHeight(dimensions[1]);
    }
}
