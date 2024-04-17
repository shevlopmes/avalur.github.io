import java.util.Stack;

public class TextEditor {
    private String content = "";

    public void write(String text) {
        Caretaker.saveState(this);
        content += text;
    }

    public void restoreToState(Memento memento) {
        this.content = memento.getState();
    }

    public String getContent() {
        return content;
    }

    public Memento createMemento() {
        return new Memento(content);
    }

    public static class Memento {
        private final String state;

        private Memento(String state) {
            this.state = state;
        }

        private String getState() {
            return state;
        }
    }

    public static class Caretaker {
        private static final Stack<Memento> history = new Stack<>();

        public static void saveState(TextEditor editor) {
            history.push(editor.createMemento());
        }

        public static void undo(TextEditor editor) {
            if (!history.isEmpty()) {
                editor.restoreToState(history.pop());
            }
        }
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
