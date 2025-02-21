package com.berenjeneitor.theGame.networkPart.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnector extends AbstractConnector implements Runnable {
    ServerSocket serverSocket;
    public ServerConnector() {
        super();
        try {
            serverSocket = new ServerSocket(super.PORT1);
            System.out.println("Server started on port " + super.PORT1);
            // configuracion de puerto, para que el cliente sepa a quien atacar
            super.serverPort = super.CONFIG.getPortIfLocal(super.PORT1);
        } catch (IOException e) {
            // si da error, significa que ya tengo este programa corriendo en este puerto, asi que ocupo el secundario
            serverSocket = null;
            try {
                serverSocket = new ServerSocket(super.PORT2);
                System.out.println("Server started on port " + super.PORT2);
                // configuracion de puerto
                super.serverPort = super.CONFIG.getPortIfLocal(super.PORT2);
            } catch (IOException ioe) {
                //TODO: crear manejo de errores para asegurar que la conexion se reconecta
                throw new RuntimeException(ioe);
            }
        }
        finally {
            // iniciar hilo
            new Thread(this).start();
        }
    }
    @Override
    public void run() {
        try {
            //TODO esto ira al channel
            Socket connection = serverSocket.accept();
            // si se conecta, enviar mensaje de inicio
            System.out.println("Client connected");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
