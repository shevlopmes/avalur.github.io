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
        assertTrue(outContent.toString().isEmpty()); // No output since image should not be loaded yet
        image.display();
        String output = outContent.toString();
        assertTrue(output.contains("Loading image from: http://example.com/image.jpg"));
        assertTrue(output.contains("Displaying http://example.com/image.jpg"));
    }
}
