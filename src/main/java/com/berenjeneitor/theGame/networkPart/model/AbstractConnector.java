package com.berenjeneitor.theGame.networkPart.model;

import java.io.IOException;
import java.net.ServerSocket;

public abstract class AbstractConnector {
    protected final String HOST;
    protected final int PORT1 = 8080;
    protected final int PORT2 = 8081;
    protected final ServerConfiguration CONFIG;
    protected ServerConfiguration.PortIfLocal serverPort;
    protected final String STOP_STRING = "##";

    public AbstractConnector(){
        CONFIG = ServerConfiguration.LOCAL;
        HOST = "localhost";
    }

}
