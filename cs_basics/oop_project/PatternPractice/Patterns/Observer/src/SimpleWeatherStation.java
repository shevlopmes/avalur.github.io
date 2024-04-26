public class SimpleWeatherStation {
    private int temperature;

    public void setTemperature(int newTemperature) {
        this.temperature = newTemperature;
        updateDisplay();
    }

    private void updateDisplay() {
        System.out.println("Updated temperature: " + temperature + "°C");
    }

    public static void main(String[] args) {
        SimpleWeatherStation station = new SimpleWeatherStation();
        station.setTemperature(25);
        station.setTemperature(30);
    }
}
