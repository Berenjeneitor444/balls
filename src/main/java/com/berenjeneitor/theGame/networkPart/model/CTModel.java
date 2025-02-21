package com.berenjeneitor.theGame.networkPart.model;

public class CTModel {
    private final ServerConnector sc;
    private final ClientConnector cc;
    public CTModel() {
        sc = new ServerConnector();
        cc = new ClientConnector();
    }
}
