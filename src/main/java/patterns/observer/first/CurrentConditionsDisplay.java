package patterns.observer.first;

/**
 * Наблюдатель - подписчик
 */
public class CurrentConditionsDisplay implements MyObserver, DisplayElement {
    private float temperature;
    private float humidity;
    private MySubject weatherData;

    public CurrentConditionsDisplay(MySubject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature +
                "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature  = temp;
        this.humidity  = humidity;
        display();
    }
}
