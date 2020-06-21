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
			Socket socket = new Socket(host, port);
			BufferedReader dataIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream sout = new PrintStream(socket.getOutputStream());
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			String msg;
			System.out.print("Connected \n");
			while (true) {
				System.out.print("Client : ");
				msg = stdin.readLine();
				sout.println(msg);
				if (msg.equalsIgnoreCase("x")) {
					System.out.println("Connection ended by client");
					break;
				}
				msg = dataIn.readLine();
				System.out.print("Server : " + msg + "\n");

			}
			socket.close();
			dataIn.close();
			sout.close();
			stdin.close();
		}catch (IOException e){
			System.out.println("Error: can't connect to server");
		}
    }

}
