package audiosystem.converter;

/**
 * Converter Interface
 * Defines a generic interface for conversion operations, such as speech-to-text or text-to-speech.
 */
public interface Converter<T, R> {

    /**
     * Performs the conversion operation on the given input.
     * @param input The input data to convert.
     * @return The result of the conversion.
     */
    R convert(T input);
}
