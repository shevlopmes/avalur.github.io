import static org.junit.Assert.*;
import org.junit.Test;

public class TextEditorMementoTest {
    private TextEditor editor;

    public void setUp() {
        editor = new TextEditor();
    }

    @Test
    public void whenWritten_thenCorrectContent() {
        this.setUp();
        editor.write("Hello");
        assertEquals("Hello", editor.getContent());
    }

    @Test
    public void whenUndoWithMemento_thenUndoLastWrite() {
        this.setUp();
        editor.write("Hello");
        editor.write(" World");
        TextEditor.Caretaker.undo(editor);
        assertEquals("Hello", editor.getContent());
    }
}
