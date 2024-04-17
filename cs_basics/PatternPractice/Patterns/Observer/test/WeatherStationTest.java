import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WeatherStationTest {
  @Test
  public void testTemperatureUpdate() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    SimpleWeatherStation station = new SimpleWeatherStation();
    station.setTemperature(25);
    assertTrue(outContent.toString().contains("Updated temperature: 25°C"));
  }
}
