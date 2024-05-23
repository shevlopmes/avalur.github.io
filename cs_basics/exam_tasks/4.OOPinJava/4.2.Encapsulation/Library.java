// Task:
// Create a class `Library` with an inner class `Book`. The `Library` class should manage a collection of `Book` objects,
// providing methods to add, remove, and display books.

import java.util.ArrayList;
import java.util.List;

// TODO: implement you solution here
class Library {
    private List<Book> books = new ArrayList<>();

}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("1984", "George Orwell");
        library.addBook("To Kill a Mockingbird", "Harper Lee");

        System.out.println("Books in the library:");
        library.displayBooks();
        // Expected output:
        // Title: 1984, Author: George Orwell
        // Title: To Kill a Mockingbird, Author: Harper Lee

        library.removeBook("1984");

        System.out.println("\nBooks in the library after removal:");
        library.displayBooks();
        // Expected output:
        // Title: To Kill a Mockingbird, Author: Harper Lee
    }
}
