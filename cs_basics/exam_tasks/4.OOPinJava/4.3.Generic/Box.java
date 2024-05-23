// Implement a generic class `Box` that can hold any type of object
// and provide methods to set and get the value.

// TODO: implement you solution here
class Box<T> {

}

public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello, World!");
        System.out.println("String value: " + stringBox.getValue());  // Expected output: String value: Hello, World!

        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(123);
        System.out.println("Integer value: " + integerBox.getValue());  // Expected output: Integer value: 123
    }
}
