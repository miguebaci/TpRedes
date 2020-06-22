package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String args[]) throws Exception {

        try {
            String host;
            Integer port;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please insert the host IP: ");
            host = scanner.nextLine();
            System.out.print("Please insert the port number: ");
            port = scanner.nextInt();
            //con los datos ingresados se instancia un socket
            Socket socket = new Socket(host, port);
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream sout = new PrintStream(socket.getOutputStream());
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            String msg;
            System.out.print("Connected \n");
            while (true) {
                //si se puede conectar espera a que el cliente ingrese un mensaje
                System.out.print("Client : ");
                msg = stdin.readLine();
                sout.println(msg);
                //si el mensaje enviado por el cliente es x se rompe el loop y se cierran los sockets
                if (msg.equalsIgnoreCase("x")) {
                    System.out.println("Connection ended by client");
                    break;
                }
                //se lee el mensaje enviado por el servidor
                msg = dataIn.readLine();
                System.out.print("Server : " + msg + "\n");

            }
            //se cierra el socket y los buffers
            socket.close();
            dataIn.close();
            sout.close();
            stdin.close();
        } catch (IOException e) {
            System.out.println("Error: can't connect to server, restart the application and insert a valid IP and port number");
        }
    }

}
