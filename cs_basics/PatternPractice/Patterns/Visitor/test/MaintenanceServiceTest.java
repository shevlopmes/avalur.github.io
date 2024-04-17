import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MaintenanceServiceTest {
  @Test
  public void testComputerMaintenance() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    SimpleComputer computer = new SimpleComputer();
    computer.maintain();
    assertTrue(outContent.toString().contains("Performing general maintenance on Computer."));
  }

  @Test
  public void testKeyboardMaintenance() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    SimpleKeyboard keyboard = new SimpleKeyboard();
    keyboard.maintain();
    assertTrue(outContent.toString().contains("Cleaning Keyboard."));
  }

  @Test
  public void testMonitorMaintenance() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    SimpleMonitor monitor = new SimpleMonitor();
    monitor.maintain();
    assertTrue(outContent.toString().contains("Adjusting Monitor display settings."));
  }
}
