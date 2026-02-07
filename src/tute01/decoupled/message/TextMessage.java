package tute01.decoupled.message;

public class TextMessage implements Message{
    private String content;

    public TextMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}