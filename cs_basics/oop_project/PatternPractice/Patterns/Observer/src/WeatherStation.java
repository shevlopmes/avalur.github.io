import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int temperature);
}

class WeatherStation {
    private ArrayList<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Display display) {
        observers.add(display);
    }

    public void setTemperature(int t) {
        this.temperature = t;
        for (Observer observer : observers) {
            observer.update(this.temperature);
        }
    }
    /* TODO: implement WeatherStation via Observer pattern */
}

class Display implements Observer {
    private final String displayName;

    public Display(String name) {
        this.displayName = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(displayName + " updated with temperature: " + temperature + "°C");
    }
}

