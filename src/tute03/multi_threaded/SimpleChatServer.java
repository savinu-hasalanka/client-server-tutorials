package tute03.multi_threaded;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5001);
            System.out.println("Server is running and waiting for a client to connect...");

            // Read messages from the client and print them
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress() + " : " + clientSocket.getPort());

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
