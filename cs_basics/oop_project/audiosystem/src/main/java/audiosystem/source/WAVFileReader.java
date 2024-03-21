package audiosystem.source;

import audiosystem.channel.Channel;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * WAVFileReader
 * Reads audio data from a WAV file and sends it to a specified Channel.
 */
public class WAVFileReader {

    private final File file;
    private final Channel channel;

    public WAVFileReader(File file, Channel channel) {
        this.file = file;
        this.channel = channel;
    }

    public void readAndSend() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file)) {
            AudioFormat format = audioInputStream.getFormat();
            byte[] buffer = new byte[4096]; // A buffer to hold read data.
            int bytesRead;

            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                // Assuming the channel can handle byte arrays directly.
                // In a real scenario, you might need to convert or process this data further.
                byte[] audioData = new byte[bytesRead];
                System.arraycopy(buffer, 0, audioData, 0, bytesRead);
                channel.addAudioData(audioData);
            }
        }
    }
}
