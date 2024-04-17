import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SimpleMediaPlayerTest {
  @Test
  public void testPlayMP3() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    SimpleMediaPlayer player = new SimpleMediaPlayer();
    player.play("mp3", "test.mp3");
    assertTrue(outContent.toString().contains("Playing mp3 file: test.mp3"));
  }

  @Test
  public void testUnsupportedMedia() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    SimpleMediaPlayer player = new SimpleMediaPlayer();
    player.play("avi", "test.avi");
    assertTrue(outContent.toString().contains("Invalid media. avi format not supported"));
  }
}
