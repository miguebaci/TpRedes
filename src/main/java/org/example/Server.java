package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
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
        pool = Executors.newFixedThreadPool(5);
    }

    public void startServer() throws IOException {

        server = new ServerSocket(3000);
        System.out.println("Server Booted");
        while (true) {
            client = server.accept();
            clientcount++;
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
        String s;

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
                    s = cin.readLine();

                    System.out.print("Client(" + id + ") :" + s + "\n");

                    if (s.equalsIgnoreCase("x")) {
                        cout.println("BYE");
                        clientcount--;
                        System.out.println("Connection ended by client " + id);
                        break;
                    }
                    cout.println("Message received by server");
                }
                if (clientcount == 0) {
                    System.out.println("Server cleaning up.");
                    System.exit(0);
                }
                cin.close();
                client.close();
                cout.close();
            } catch (IOException ex) {
                System.out.println("Error : " + ex);
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }catch (NullPointerException ex){
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
