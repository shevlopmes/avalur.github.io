package audiosystem.pin;

import audiosystem.channel.ObservableChannel;
import audiosystem.processing.AudioProcessingStrategy;

/**
 * AudioProcessorPin is a concrete implementation of DataPin, handling audio data processing.
 */
public class AudioProcessorPin implements DataPin {

    private ObservableChannel channel;
    private AudioProcessingStrategy strategy;

    public AudioProcessorPin(ObservableChannel channel, AudioProcessingStrategy strategy) {
        this.channel = channel;
        this.strategy = strategy;
        this.channel.subscribe(this); // Subscribe to the channel for data notifications.
    }

    @Override
    public void notifyDataAvailable() {
        try {
            byte[] rawData = channel.takeAudioData();
            byte[] processedData = strategy.processAudio(rawData);
            // Further processing or forwarding of processed data can be implemented here.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Handle exception, e.g., log or clean up resources.
        }
    }
}
