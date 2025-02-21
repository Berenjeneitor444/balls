package com.berenjeneitor.theGame.networkPart.model;

import java.io.IOException;
import java.net.Socket;

public class ClientConnector extends AbstractConnector implements Runnable {
    private Socket clientSocket;

    public ClientConnector() {
        super();

        // inicial el hilo
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (super.serverPort == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // crear el socket
        int port = super.serverPort == ServerConfiguration.PortIfLocal.PORT_8080 ? super.PORT1 : super.PORT2;
        try {
            this.clientSocket = new Socket(super.HOST, port);
            System.out.println("Client connected to port " + port);
            // enviar datos al server
            this.clientSocket.getOutputStream().write("Hello".getBytes());
            this.clientSocket.getOutputStream().write(super.STOP_STRING.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

