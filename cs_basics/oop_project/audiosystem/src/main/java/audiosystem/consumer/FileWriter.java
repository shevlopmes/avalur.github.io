package audiosystem.consumer;

import audiosystem.channel.Channel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileWriter
 * Writes audio data received from a Channel to a file.
 */
public class FileWriter {

    private final File file;
    private final Channel channel;

    public FileWriter(File file, Channel channel) {
        this.file = file;
        this.channel = channel;
    }

    public void receiveAndWrite() throws IOException, InterruptedException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            while (true) {
                // This loop assumes an external condition will terminate it.
                // In practice, you might listen for a specific event or data value to break.
                byte[] data = channel.takeAudioData();
                fileOutputStream.write(data);
            }
        }
    }
}
