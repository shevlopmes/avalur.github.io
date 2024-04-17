import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MessagingAppTest {
    @Test
    public void testEmailTextMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Message message = new TextMessage("Hello, World!", new EmailSender());
        message.send();
        assertEquals("Email sent: Hello, World!", outContent.toString().strip());
    }

    @Test
    public void testSmsHtmlMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Message message = new HtmlMessage("<p>Hello, Bridge!</p>", new SmsSender());
        message.send();
        assertEquals("SMS sent: <p>Hello, Bridge!</p>", outContent.toString().strip());
    }
}
