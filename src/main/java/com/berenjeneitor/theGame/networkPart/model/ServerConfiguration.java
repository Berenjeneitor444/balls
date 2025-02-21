package com.berenjeneitor.theGame.networkPart.model;

public enum ServerConfiguration {
    LOCAL, REMOTE;
    public enum PortIfLocal{
        PORT_8080, PORT_8081;

    }
    public PortIfLocal getPortIfLocal(int PORT){
        return PORT == 8080 ? PortIfLocal.PORT_8080 : PortIfLocal.PORT_8081;
    }
}
