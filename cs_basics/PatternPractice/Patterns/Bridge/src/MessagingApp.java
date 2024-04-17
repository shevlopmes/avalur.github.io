interface MessageSender {
    void send(String message);
}

class EmailSender implements MessageSender {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SmsSender implements MessageSender {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

interface Message {
    void send();
}

class TextMessage implements Message {
    private String content;
    private MessageSender sender;

    public TextMessage(String content, MessageSender sender) {
        this.content = content;
        this.sender = sender;
    }

    public void send() {
        sender.send(content);
    }
}

class HtmlMessage implements Message {
    private String content;
    private MessageSender sender;

    public HtmlMessage(String content, MessageSender sender) {
        this.content = content;
        this.sender = sender;
    }

    public void send() {
        sender.send(content);
    }
}

public class MessagingApp {
    public static void main(String[] args) {
        Message textMessage = new TextMessage("Hello, World!", new EmailSender());
        textMessage.send();
        Message htmlMessage = new HtmlMessage("<p>Hello, Bridge!</p>", new SmsSender());
        htmlMessage.send();
    }
}
