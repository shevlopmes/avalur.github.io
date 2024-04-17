import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MessageTest {
  @Test
  public void testEmailMessageSending() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    SimpleMessage message = new SimpleTextMessage("Test Message");
    message.send("email");
    assertEquals("Sending Email: Test Message", outContent.toString().strip());
  }

  @Test
  public void testSmsMessageSending() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    SimpleMessage message = new SimpleTextMessage("Test Message");
    message.send("sms");
    assertEquals("Sending SMS: Test Message", outContent.toString().strip());
  }
}
