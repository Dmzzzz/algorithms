package patterns.observer.first;


import java.util.ArrayList;
import java.util.List;

/**
 * Есть Субьект (главный класс)  и есть Наблюдатель(observer, подписчик, наблюдатели)
 * <p>
 * <p>
 * объекта WeatherData (отсле- живает данные, поступающие от метеостанции, и обновляет отображаемую информацию)
 * <p>
 * subject - Интерфейс субъекта.
 * Используется объектами для регистрации в качестве наблюдателя, а также ис- ключения из списка.
 * Каждый субъект может иметь много наблюдателей
 * <p>
 * observer
 * Каждый потенциальный наблюдатель должен реализовать интерфейс Observer. Интер- фейс содержит единствен-
 * ный метод update(), который вызывается при изменении состояния субъекта.
 */
public class WeatherData implements MySubject {
    private List<MyObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList();
    }

    @Override
    public void registerObserver(MyObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(MyObserver o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            MyObserver observer = observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

}
