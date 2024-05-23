import java.util.Stack;

// TODO: implement you solution here
public class TextEditor {

    public Memento createMemento() {
        return new Memento(content);
    }

    public static class Caretaker {
        private static final Stack<Memento> history = new Stack<>();

    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.write("Hello");
        editor.write(" World");
        System.out.println(editor.getContent());  // Output: Hello World
        Caretaker.undo(editor);
        System.out.println(editor.getContent());  // Output: Hello
    }
}
