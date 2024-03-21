package audiosystem.pin;

/**
 * DataPin interface for components that act as endpoints for data flow in the system.
 * These components will be notified when new data is available in their subscribed channels.
 */
public interface DataPin {

    /**
     * Called by the ObservableChannel when new data is available.
     * Implementations of this method should handle the retrieval and processing of the data.
     */
    void notifyDataAvailable();
}
