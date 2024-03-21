package audiosystem.audiostream;

import java.io.IOException;

/**
 * AudioStream Interface
 * Represents a generic interface for an audio stream, which could be sourced from a file,
 * a microphone, over the network, or other type of source.
 * This abstraction allows for the flexibility of implementing
 * various input and output sources while maintaining a consistent interface for reading, writing,
 * and closing the stream.
 */
public interface AudioStream {

    /**
     * Reads data from the audio stream.
     * This method should return audio data in a byte array format, which allows for a generic
     * representation of audio data. The implementation of this method will vary based on the
     * source (e.g., file, microphone, network).
     *
     * @return byte[] The audio data read from the stream. The size of the array depends on the
     *                implementation and the amount of data available to read.
     * @throws IOException If an input or output exception occurred.
     */
    byte[] read() throws IOException;

    /**
     * Writes data to the audio stream.
     * This method takes audio data in the form of a byte array and writes it to the stream.
     * The specifics of how and where the data is written will depend on the implementation
     * (e.g., to a file, through the network, or to an audio output device).
     *
     * @param data The audio data to write to the stream.
     * @throws IOException If an input or output exception occurred.
     */
    void write(byte[] data) throws IOException;

    /**
     * Closes the audio stream.
     * This method is responsible for releasing any resources associated with the stream.
     * Once a stream is closed, it cannot be read from or written to until it is opened again
     * by another initialization.
     *
     * @throws IOException If an input or output exception occurred during stream closure.
     */
    void close() throws IOException;
}
