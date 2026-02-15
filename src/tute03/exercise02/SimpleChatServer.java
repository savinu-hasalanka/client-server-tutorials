package tute03.exercise02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class SimpleChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5001);
            System.out.println("Server is running and waiting for a client to connect...");

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Input stream to receive messages from the client
            InputStream inputStream = clientSocket.getInputStream();

            // Output stream to send messages to the client
            OutputStream outputStream = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read messages from the client and print them
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Client: " + message);
                System.out.println("Byte Array: " + Arrays.toString(buffer));

                // Send a response back to the client
                String responseMessage = "Server received your message: " + message;
                outputStream.write(responseMessage.getBytes());
            }

            // Close the sockets
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
