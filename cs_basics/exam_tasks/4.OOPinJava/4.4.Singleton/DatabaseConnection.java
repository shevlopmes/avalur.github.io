// Create a Singleton class `DatabaseConnection` that ensures only one
// instance of the class is created and provides a method to get the instance.

// TODO: implement you solution here
class DatabaseConnection {
    private static DatabaseConnection instance;
    private String connectionString;

    public void connect() {
        System.out.println("Connecting to " + connectionString);
    }
}

public class Main {
    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstance("jdbc:mysql://localhost:3306/mydb");
        connection1.connect();  // Expected output: Connecting to jdbc:mysql://localhost:3306/mydb

        DatabaseConnection connection2 = DatabaseConnection.getInstance("jdbc:postgresql://localhost:5432/mydb");
        connection2.connect();  // Expected output: Connecting to jdbc:mysql://localhost:3306/mydb

        System.out.println(connection1 == connection2);  // Expected output: true
    }
}
