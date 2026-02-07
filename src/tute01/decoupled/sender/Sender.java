package tute01.decoupled.sender;

import tute01.decoupled.message.Message;
import tute01.decoupled.message.TextMessage;
import tute01.decoupled.receiver.Receivable;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Sender {

    private static final Logger logger = Logger.getLogger(Sender.class.getName());

    public Message createMessage(String content) {
        try {
            Message message = new TextMessage(content);
            logger.log(Level.INFO, "TextMessage created");
            return message;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred creating a message. " + e.getMessage());
            return null;
        }
    }


    public void sendMessage(Message message, Receivable receiver) {
        try {
            logger.log(Level.INFO, "TextMessage is being sent to the receiver.");
            receiver.receiveMessage(message);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error sending the message. " + e.getMessage(), e);
        }
    }

}
