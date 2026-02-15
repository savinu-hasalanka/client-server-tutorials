package tute03.multi_threaded;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleChatClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5001);

            System.out.println("Connected to the server.");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();

                outputStream.write(message.getBytes());

                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);

                String responseMessage = new String(buffer, 0, bytesRead);
                System.out.println("Server: " + responseMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
