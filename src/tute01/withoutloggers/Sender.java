package tute01.withoutloggers;

public class Sender {

    public Message createMessage(String content) {
        Message message = new Message(content);
        System.out.println("New message has been created!");
        return message;
    }

    public void sendMessage(Message message, Receiver receiver) {
        System.out.println("tute01.withoutloggers.TextMessage is being sent to the receiver.");
        receiver.receiveMessage(message);
    }
}
