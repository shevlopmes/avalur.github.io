package audiosystem.channel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Channel Class
 * Manages the flow of audio data and associated metadata between sources, processors, and consumers.
 * It supports subchannels for different types of data, such as metadata and checksums, and provides
 * buffering capabilities to handle data flow asynchronously.
 */
public class Channel {

    // Main data buffer for audio data.
    private BlockingQueue<byte[]> audioDataBuffer;

    // Map of subchannels, identified by a string key, each with its own data buffer.
    private Map<String, BlockingQueue<Object>> subchannels;

    /**
     * Constructor for the Channel class.
     * Initializes the main audio data buffer and the subchannel map.
     * @param bufferSize The size of the main audio data buffer.
     */
    public Channel(int bufferSize) {
        this.audioDataBuffer = new ArrayBlockingQueue<>(bufferSize);
        this.subchannels = new HashMap<>();
    }

    /**
     * Adds audio data to the main buffer.
     * @param data The audio data to add.
     * @throws InterruptedException If interrupted while waiting to add data to the buffer.
     */
    public void addAudioData(byte[] data) throws InterruptedException {
        audioDataBuffer.put(data);
    }

    /**
     * Retrieves and removes audio data from the main buffer, waiting if necessary
     * until data becomes available.
     * @return The audio data from the buffer.
     * @throws InterruptedException If interrupted while waiting for data.
     */
    public byte[] takeAudioData() throws InterruptedException {
        return audioDataBuffer.take();
    }

    /**
     * Adds a subchannel for specific types of data, such as metadata or checksums.
     * @param key The key identifying the subchannel.
     * @param bufferSize The size of the subchannel buffer.
     */
    public void addSubchannel(String key, int bufferSize) {
        subchannels.put(key, new ArrayBlockingQueue<>(bufferSize));
    }

    /**
     * Adds data to a specified subchannel.
     * @param key The key identifying the subchannel.
     * @param data The data to add to the subchannel.
     * @throws InterruptedException If interrupted while waiting to add data to the subchannel buffer.
     */
    public void addSubchannelData(String key, Object data) throws InterruptedException {
        BlockingQueue<Object> subchannel = subchannels.get(key);
        if (subchannel != null) {
            subchannel.put(data);
        } else {
            throw new IllegalArgumentException("Subchannel with key " + key + " does not exist.");
        }
    }

    /**
     * Retrieves and removes data from a specified subchannel, waiting if necessary
     * until data becomes available.
     * @param key The key identifying the subchannel.
     * @return The data from the subchannel buffer.
     * @throws InterruptedException If interrupted while waiting for data.
     */
    public Object takeSubchannelData(String key) throws InterruptedException {
        BlockingQueue<Object> subchannel = subchannels.get(key);
        if (subchannel != null) {
            return subchannel.take();
        } else {
            throw new IllegalArgumentException("Subchannel with key " + key + " does not exist.");
        }
    }
}
