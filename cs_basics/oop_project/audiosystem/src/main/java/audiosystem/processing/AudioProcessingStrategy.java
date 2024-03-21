package audiosystem.processing;

/**
 * AudioProcessingStrategy Interface
 * Defines a common interface for audio processing algorithms. This allows for the implementation
 * of different audio processing behaviors (e.g., volume adjustment, speed modification,
 * noise removal) that can be applied to audio streams.
 */
public interface AudioProcessingStrategy {

    /**
     * Processes audio data.
     * This method takes an array of bytes representing the raw audio data to be processed.
     * The implementation of this method in concrete classes will apply specific processing
     * algorithms to the audio data (e.g., changing volume, converting mono to stereo).
     *
     * @param inputData The raw audio data as a byte array.
     * @return byte[] The processed audio data.
     */
    byte[] processAudio(byte[] inputData);
}
