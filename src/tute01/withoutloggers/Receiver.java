package tute01.withoutloggers;

public class Receiver {

    public void receiveMessage(Message message) {
        System.out.println("New message arrived!");
        System.out.println("Content: " + message.getContent());
    }
}
