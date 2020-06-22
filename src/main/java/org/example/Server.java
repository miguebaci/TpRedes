package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    int port;
    ServerSocket server = null;
    Socket client = null;
    ExecutorService pool = null;
    static int clientcount = 0;

    public static void main(String[] args) throws IOException {
        Server serverobj = new Server(3000);
        serverobj.startServer();
    }

    Server(int port) {
        this.port = port;
        //se crea un pool para que hasta 5 clientes puedan conectarse al servidor al mismo tiempo
        pool = Executors.newFixedThreadPool(5);
    }

    public void startServer() throws IOException {

        //se inicia el servidor
        server = new ServerSocket(this.port);
        System.out.println("Server Booted");
        while (true) {
            //este loop eterno hace que se este constantemente buscando nuevas conexiones al socket del servidor
            client = server.accept();
            clientcount++;
            //Se crea un hilo con el scocket del cliente y se lo añade al pool
            ServerThread runnable = new ServerThread(client, clientcount, this);
            pool.execute(runnable);
        }

    }

    private static class ServerThread implements Runnable {

        Server server = null;
        Socket client = null;
        BufferedReader cin;
        PrintStream cout;
        int id;
        String msg;

        ServerThread(Socket client, int count, Server server) throws IOException {

            this.client = client;
            this.server = server;
            this.id = count;
            System.out.println("Connection " + id + " established with client " + client.getInetAddress());

            cin = new BufferedReader(new InputStreamReader(client.getInputStream()));
            cout = new PrintStream(client.getOutputStream());

        }

        @Override
        public void run() {
            try {
                while (true) {
                    //lee el mensaje enviado por el cliente
                    msg = cin.readLine();
                    //lo muestra por pantalla
                    System.out.print("Client(" + id + ") :" + msg + "\n");
                    //si el mensaje del cliente es x se descuenta un cliente del contador de clientes, cuando llega a 0 el servidor se cierra
                    if (msg.equalsIgnoreCase("x")) {
                        cout.println("BYE");
                        clientcount--;
                        System.out.println("Connection ended by client " + id);
                        break;
                    }
                    //mensaje de confirmacion enviado por el servidor al cliente, este se mostrara en pantalla al cliente
                    cout.println("Message received by server");
                }
                //cuando llega a 0 el servidor se cierra
                if (clientcount == 0) {
                    System.out.println("Server cleaning up.");
                    //Se cierran los sockets y buffers
                    cin.close();
                    client.close();
                    cout.close();
                    System.exit(0);
                }

            } catch (IOException ex) {
                System.out.println("Error : " + ex);
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (NullPointerException ex) {
                System.out.println("Error : " + ex);
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

}
