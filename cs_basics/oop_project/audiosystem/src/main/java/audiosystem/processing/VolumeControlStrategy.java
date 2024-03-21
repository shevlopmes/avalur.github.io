package audiosystem.processing;

/**
 * VolumeControlStrategy Class
 * Implements the AudioProcessingStrategy interface to adjust the volume of an audio stream.
 */
public class VolumeControlStrategy implements AudioProcessingStrategy {

    private double volumeFactor; // Factor to adjust volume, where 1.0 is unchanged, <1.0 is decrease, >1.0 is increase.

    /**
     * Constructor to set the volume adjustment factor.
     * @param volumeFactor The factor to adjust the volume by.
     */
    public VolumeControlStrategy(double volumeFactor) {
        this.volumeFactor = volumeFactor;
    }

    /**
     * Adjusts the volume of the provided audio data.
     * This simplistic implementation assumes the audio data is in a format where volume
     * adjustment can be performed by simply scaling the amplitude of the audio signal.
     *
     * @param inputData The raw audio data.
     * @return byte[] The volume-adjusted audio data.
     */
    @Override
    public byte[] processAudio(byte[] inputData) {
        byte[] outputData = new byte[inputData.length];
        for (int i = 0; i < inputData.length; i++) {
            // Simple example of volume adjustment by scaling byte values.
            // NOTE: This is a simplistic approach and not how real audio processing is done.
            outputData[i] = (byte)(inputData[i] * volumeFactor);
        }
        return outputData;
    }
}
