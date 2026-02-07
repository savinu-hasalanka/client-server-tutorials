package tute01.withloggers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Sender {

    private static final Logger logger = Logger.getLogger(Sender.class.getName());

    public Message createMessage(String content) {
        try {
            Message message = new Message(content);
            logger.log(Level.INFO, "TextMessage created");
            return message;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred creating a message. " + e.getMessage());
            return null;
        }
    }


    public void sendMessage(Message message, Receiver receiver) {
        try {
            logger.log(Level.INFO, "TextMessage is being sent to the receiver.");
            receiver.receiveMessage(message);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error sending the message. " + e.getMessage(), e);
        }
    }

}
