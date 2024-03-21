package audiosystem.util;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * SystemLogger
 * Provides logging capabilities for the system.
 */
public class SystemLogger {

    private static final Logger LOGGER = Logger.getLogger(SystemLogger.class.getName());

    public static void logInfo(String message) {
        LOGGER.log(Level.INFO, message);
    }

    public static void logError(String message, Throwable thrown) {
        LOGGER.log(Level.SEVERE, message, thrown);
    }
}
