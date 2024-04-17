import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TemplateMethodTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testWorldOfWarcraftSetup() {
        WorldOfWarcraft wow = new WorldOfWarcraft();
        wow.setupGame();
        String output = outContent.toString();
        assert(output.contains("Loading WoW data from local storage..."));
        assert(output.contains("Initializing WoW profiles..."));
    }

    @Test
    public void testDiabloSetup() {
        Diablo diablo = new Diablo();
        diablo.setupGame();
        String output = outContent.toString();
        assert(output.contains("Loading Diablo data from local storage..."));
        assert(output.contains("Initializing Diablo profiles..."));
    }
}
