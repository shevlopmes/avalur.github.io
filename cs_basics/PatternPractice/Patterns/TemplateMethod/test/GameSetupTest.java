import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameSetupTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Test
  public void testWorldOfWarcraftSetup() {
    System.setOut(new PrintStream(outContent));
    DummyWorldOfWarcraft wow = new DummyWorldOfWarcraft();
    wow.setupGame();
    assertTrue(outContent.toString().contains("Loading WoW data from local storage..."));
    assertTrue(outContent.toString().contains("Initializing WoW profiles..."));
  }

  @Test
  public void testDiabloSetup() {
    System.setOut(new PrintStream(outContent));
    DummyDiablo diablo = new DummyDiablo();
    diablo.setupGame();
    assertTrue(outContent.toString().contains("Loading Diablo data from local storage..."));
    assertTrue(outContent.toString().contains("Initializing Diablo profiles..."));
  }
}
