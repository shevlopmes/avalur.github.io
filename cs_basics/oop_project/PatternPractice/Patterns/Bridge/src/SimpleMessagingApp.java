abstract class SimpleMessage {
    abstract void send(String type);
}

class SimpleTextMessage extends SimpleMessage {
    private String content;

    public SimpleTextMessage(String content) {
        this.content = content;
    }

    void send(String type) {
        if (type.equals("email")) {
            System.out.println("Sending Email: " + this.content);
        } else {
            System.out.println("Sending SMS: " + this.content);
        }
    }
}

public class SimpleMessagingApp {
    public static void main(String[] args) {
        SimpleMessage message = new SimpleTextMessage("Hello, Bridge!");
        message.send("email");
    }
}
