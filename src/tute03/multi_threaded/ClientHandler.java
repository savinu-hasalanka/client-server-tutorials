package tute03.multi_threaded;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Input stream to receive messages from the client
            InputStream inputStream = clientSocket.getInputStream();

            // Output stream to send messages to the client
            OutputStream outputStream = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read messages from the client and print them
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Client [" + clientSocket.getInetAddress() + "]: " + message);

                // Send a response back to the client
                // String responseMessage = "Server received: " + message;
                String responseMessage = message;
                outputStream.write(responseMessage.getBytes());
            }

            // Close the socket after client disconnects
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
