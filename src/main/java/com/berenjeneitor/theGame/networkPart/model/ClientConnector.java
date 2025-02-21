package com.berenjeneitor.theGame.networkPart.model;

import java.io.IOException;
import java.net.Socket;

public class ClientConnector extends AbstractConnector implements Runnable{
    private Socket clientSocket;

    public ClientConnector() {
        super();
        try {
            // inicial el hilo
            new Thread(this).start();
            // crear el socket
            int port = super.serverPort == ServerConfiguration.PortIfLocal.PORT_8080 ? super.PORT1 : super.PORT2;
            this.clientSocket = new Socket(super.HOST, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        while(super.serverPort == null){
            try{
                Thread.sleep(1);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
