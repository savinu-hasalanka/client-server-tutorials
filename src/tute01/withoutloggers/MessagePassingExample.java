package tute01.withoutloggers;

public class MessagePassingExample {
    public static void main(String[] args) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();
        String messageContent = "Hey, I'm in the CSA tutorial.";

        Message message = sender.createMessage(messageContent);
        sender.sendMessage(message, receiver);
    }
}
