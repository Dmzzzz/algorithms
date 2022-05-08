package patterns.observer.first;


public class MainObsFirst {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(110f,5f,120.5f);
        weatherData.setMeasurements(80f,85f,820.5f);
        weatherData.setMeasurements(990f,95f,920.5f);

    }
}
