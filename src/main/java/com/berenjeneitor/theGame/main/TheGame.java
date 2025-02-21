package com.berenjeneitor.theGame.main;

import com.berenjeneitor.theGame.gamePart.GameController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TheGame {
    private GameController gc;
    public TheGame() {
        this.gc = new GameController();
    }
    public static void main(String[] args) {
        TheGame game = new TheGame();
    }
}