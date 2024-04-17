import static org.junit.Assert.*;
import org.junit.Test;

public class DummyTextEditorTest {
  private DummyTextEditor editor;

  public void setUp() {
    editor = new DummyTextEditor();
  }

  @Test
  public void whenWritten_thenCorrectContent() {
    this.setUp();
    editor.write("Hello");
    assertEquals("Hello", editor.getContent());
  }

  @Test
  public void whenUndo_thenUndoLastWrite() {
    this.setUp();
    editor.write("Hello");
    editor.write(" World");
    editor.undo();
    assertEquals("Hello", editor.getContent());
  }
}
