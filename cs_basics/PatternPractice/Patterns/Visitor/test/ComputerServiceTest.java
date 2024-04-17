import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ComputerServiceTest {
    @Test
    public void testComputerMaintenanceWithVisitor() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Computer computer = new Computer();
        computer.accept(new MaintenanceVisitor());
        assertTrue(outContent.toString().contains("Performing general maintenance on Computer."));
    }

    @Test
    public void testKeyboardMaintenanceWithVisitor() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Keyboard keyboard = new Keyboard();
        keyboard.accept(new MaintenanceVisitor());
        assertTrue(outContent.toString().contains("Cleaning Keyboard."));
    }

    @Test
    public void testMonitorMaintenanceWithVisitor() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Monitor monitor = new Monitor();
        monitor.accept(new MaintenanceVisitor());
        assertTrue(outContent.toString().contains("Adjusting Monitor display settings."));
    }
}
