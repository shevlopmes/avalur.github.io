public class DatabaseConnector {
   // Volatile keyword to ensure visibility of changes across threads.
   private static volatile DatabaseConnector instance;

   // Private constructor to prevent instantiation from outside the class.
   private DatabaseConnector() {
      // Initialize your database connection here
      // Example: this.connection = setupDatabaseConnection();
   }

   // Public method to get the instance of the class.
   public static DatabaseConnector getInstance() {
      // First check without synchronization for better performance.
      if (instance == null) {
         // Synchronize on the class to ensure only one thread can execute this block at one time.
         synchronized (DatabaseConnector.class) {
            // Double check if instance is still null to avoid creating multiple instances.
            if (instance == null) {
               instance = new DatabaseConnector();
            }
         }
      }
      return instance;
   }

   // Method to interact with the database
   public void connect() {
      // Implementation for connecting to the database
      System.out.println("Connecting to the database...");
      // Actual connection logic here
   }

   // Example usage inside the same Java program
   public static void main(String[] args) {
      DatabaseConnector dbConnector = DatabaseConnector.getInstance();
      dbConnector.connect();
   }
}
