import static org.junit.Assert.*;
import org.junit.Test;

class Display implements Observer {
    private String displayName;
    private String lastMessage = "";

    public Display(String name) {
        this.displayName = name;
    }

    @Override
    public void update(int temperature) {
        lastMessage = displayName + " updated with temperature: " + temperature + "°C";
    }

    public String getLastMessage() {
        return lastMessage;
    }
}

public class WeatherStationObserverTest {
    private WeatherStation station;
    private Display display1;
    private Display display2;

    public void setUp() {
        station = new WeatherStation();
        display1 = new Display("Display 1");
        display2 = new Display("Display 2");
        station.addObserver(display1);
        station.addObserver(display2);
    }

    @Test
    public void testObserversReceiveUpdates() {
        this.setUp();
        station.setTemperature(25);
        assertEquals("Display 1 updated with temperature: 25°C", display1.getLastMessage());
        assertEquals("Display 2 updated with temperature: 25°C", display2.getLastMessage());
    }
}
