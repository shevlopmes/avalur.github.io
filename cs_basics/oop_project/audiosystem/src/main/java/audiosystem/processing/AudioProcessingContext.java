package audiosystem.processing;

/**
 * AudioProcessingContext Class
 * Utilizes a strategy for audio processing. This allows for dynamic changes in the processing
 * algorithm being applied to audio data.
 */
public class AudioProcessingContext {

    private AudioProcessingStrategy strategy;

    /**
     * Sets the audio processing strategy to be used.
     * @param strategy The audio processing strategy.
     */
    public void setStrategy(AudioProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Applies the current audio processing strategy to the given audio data.
     * @param inputData The raw audio data to be processed.
     * @return byte[] The processed audio data.
     */
    public byte[] processAudio(byte[] inputData) {
        if (strategy == null) {
            throw new IllegalStateException("AudioProcessingStrategy has not been set.");
        }
        return strategy.processAudio(inputData);
    }
}
