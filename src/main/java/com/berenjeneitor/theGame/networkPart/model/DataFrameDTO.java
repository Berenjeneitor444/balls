package com.berenjeneitor.theGame.networkPart.model;

import com.berenjeneitor.theGame.gamePart.model.BallDTO;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class DataFrameDTO implements Serializable {

    // mi enum para saber tipo de dto
    private DTOType type;
    private Serializable data;

    public DataFrameDTO(@NotNull Serializable data) {
        if (data instanceof BallDTO){
            this.type = DTOType.BALL_DTO;
        }
        else if (data instanceof ControlDTO){
            this.type = DTOType.CONTROL_DTO;
        }
        else{
            throw new IllegalArgumentException("Invalid data type" + data.getClass().getName() + " in DataFrameDTO");
        }
        this.data = data;

    }

    public DTOType getType() {
        return type;
    }

    public void setType(DTOType type) {
        this.type = type;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }
}
