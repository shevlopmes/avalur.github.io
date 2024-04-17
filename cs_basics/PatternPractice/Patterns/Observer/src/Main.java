public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Display display1 = new Display("Display 1");
        Display display2 = new Display("Display 2");
        station.addObserver(display1);
        station.addObserver(display2);

        station.setTemperature(25);
        station.setTemperature(30);
    }
}
