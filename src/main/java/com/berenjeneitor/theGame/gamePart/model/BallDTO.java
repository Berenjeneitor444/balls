package com.berenjeneitor.theGame.gamePart.model;

import java.awt.Color;
import java.io.Serializable;

public class BallDTO implements Serializable {
        private int x, y, diametro;
        private Color color;
        private int v_x, v_y;

    public BallDTO(Ball ball) {
        this.x = ball.getX();
        this.y = ball.getY();
        this.diametro = ball.getDiametro();
        this.color = ball.getColor();
        this.v_x = ball.getV_x();
        this.v_y = ball.getV_y();
    }

    public BallDTO() {}
    public void setX(int i) {
        this.x = i;
    }
    public int getV_x() {
        return v_x;
    }

    public int getV_y() {
        return v_y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDiametro() {
        return diametro;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int i) {
        this.y = i;
    }

    public void setV_y(int v_y) {
        this.v_y = v_y;
    }

    public void setV_x(int v_x) {
        this.v_x = v_x;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }
}
