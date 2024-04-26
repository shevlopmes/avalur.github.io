import java.util.Stack;

public class DummyTextEditor {
    private String content = "";
    private final Stack<String> history = new Stack<>();

    public void write(String text) {
        history.push(content);
        content += text;
    }

    public void undo() {
        if (!history.isEmpty()) {
            content = history.pop();
        }
    }

    public String getContent() {
        return content;
    }

    public static void main(String[] args) {
        DummyTextEditor editor = new DummyTextEditor();
        editor.write("Hello");
        editor.write(" World");
        System.out.println(editor.getContent());  // Output: Hello World
        editor.undo();
        System.out.println(editor.getContent());  // Output: Hello
    }
}
