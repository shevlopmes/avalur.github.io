// Task:
// Define an abstract class `Employee` with fields for name and salary and an abstract method calculateBonus().
// Implement concrete subclasses `Manager` and `Developer` that provide implementations for calculateBonus().

// TODO: implement you solution here
abstract class Employee {

    public abstract double calculateBonus();

    public void displayInfo() {
        System.out.println("Name: " + name + ", Salary: " + salary + ", Bonus: " + calculateBonus());
    }
}

class Manager extends Employee {

}

class Developer extends Employee {

}

public class Main {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 80000);
        Employee developer = new Developer("Bob", 60000);

        manager.displayInfo();  // Expected output: Name: Alice, Salary: 80000.0, Bonus: 8000.0
        developer.displayInfo();  // Expected output: Name: Bob, Salary: 60000.0, Bonus: 3000.0
    }
}
