import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(int newTemperature) {
        this.temperature = newTemperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

class Display implements Observer {
    private String displayName;

    public Display(String name) {
        this.displayName = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(displayName + " updated with temperature: " + temperature + "°C");
    }
}

