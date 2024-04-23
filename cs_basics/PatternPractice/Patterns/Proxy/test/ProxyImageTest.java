import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ProxyImageTest {
    private ByteArrayOutputStream outContent;

    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testLazyImageLoading() {
        setUp();
        ProxyImage image = new ProxyImage("http://example.com/image.jpg");
        assertTrue("Image should not be loaded yet during the creation of object",
                outContent.toString().isEmpty());
        image.display();
        String output = outContent.toString();
        assertTrue("Error during Loading image",
                output.contains("Loading image from: http://example.com/image.jpg"));
        assertTrue("Error during Displaying image",
                output.contains("Displaying http://example.com/image.jpg"));
    }
}
