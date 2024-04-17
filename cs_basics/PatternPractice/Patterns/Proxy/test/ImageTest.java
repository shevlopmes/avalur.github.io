import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ImageTest {
  @Test
  public void testImageLoading() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Image image = new Image("http://example.com/image.jpg");
    image.display();
    String output = outContent.toString();
    assertTrue(output.contains("Loading image from: http://example.com/image.jpg"));
    assertTrue(output.contains("Displaying http://example.com/image.jpg"));
  }
}
