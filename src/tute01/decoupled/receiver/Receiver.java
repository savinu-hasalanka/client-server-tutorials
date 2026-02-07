package tute01.decoupled.receiver;

import tute01.decoupled.message.Message;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receiver implements Receivable {

    private static final Logger logger = Logger.getLogger(Receiver.class.getName());

    public void receiveMessage(Message message) {
        try {
            logger.log(Level.INFO, "New message arrived!\nContent: " + message.getContent());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error receiving the message. " +e.getMessage(), e);
        }
    }
}
