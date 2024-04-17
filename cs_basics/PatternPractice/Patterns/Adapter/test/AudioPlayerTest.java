import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AudioPlayerTest {
    @Test
    public void testPlayMP3() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "test.mp3");
        assertTrue(outContent.toString().contains("Playing mp3 file: test.mp3"));
    }

    @Test
    public void testPlayMP4ThroughAdapter() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AudioPlayer player = new AudioPlayer();
        player.play("mp4", "test.mp4");
        assertTrue(outContent.toString().contains("Playing mp4 file: test.mp4"));
    }

    @Test
    public void testPlayVLCThroughAdapter() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AudioPlayer player = new AudioPlayer();
        player.play("vlc", "test.vlc");
        assertTrue(outContent.toString().contains("Playing vlc file: test.vlc"));
    }
}
