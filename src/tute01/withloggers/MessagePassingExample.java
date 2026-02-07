package tute01.withloggers;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

public class MessagePassingExample {
    public static void main(String[] args) {
        try {
            configureLogger();
            Sender sender = new Sender();
            Receiver receiver = new Receiver();
            String messageContent = "Hey, I'm in the CSA tutorial.";

            Message message = sender.createMessage(messageContent);
            sender.sendMessage(message, receiver);
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "Error occurred in main " + e.getMessage(), e);
        }
    }

    private static void configureLogger() {
        try {
            // Configure global logging level
            Logger globalLogger = Logger.getLogger("");
            Handler[] handlers = globalLogger.getHandlers();
            for (Handler handler : handlers) {
                globalLogger.removeHandler(handler);
            }
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            globalLogger.addHandler(consoleHandler);
            globalLogger.setLevel(Level.ALL);
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "Error configuring logger: " + e.getMessage(), e);
        }
    }
}
