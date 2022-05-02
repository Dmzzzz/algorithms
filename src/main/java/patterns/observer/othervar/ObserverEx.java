package patterns.observer.othervar;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Observer - интерфейс
 *
 * Observerable - класс
 * содержит списой таких же Обсерверов он может добавлять удалять нотифаить сет-чангед
 *
 * Обсервер(наблюдатель) - получает нотифакицию
 */

public class ObserverEx {

    public static void main(String[] args) {
        System.out.println("Enter text:  ");

        EventSource eventSource = new EventSource();
        eventSource.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("Received response: " + arg);
            }
        });

        new Thread(eventSource).start();
    }
}


class EventSource extends Observable implements Runnable {

    @Override
    public void run() {
        while (true) {
            String response = new Scanner(System.in).next();
            setChanged();
            notifyObservers(response);
        }
    }
}
