package patterns.proxy;

public class Proxy1 {

    /*
     * Прокси сервер - промежуточный сайт , подключаетесь к нему - он даёт выход
     *
     *  Прокси - вклинивается между классами и добавляет свой функционал
     *
     * между имплементацией интерфейса и реализацией добавили Свой код - настройки и т.д.
     * 
     */

    public static void main(String[] args) {

        CarI car = new Proxy();
        car.drive();
    }
}

interface CarI{
    void drive();
}

class Reno implements CarI {
    @Override
    public void drive() {
        System.out.println("drive Reno");
    }
}

class Proxy implements CarI {
    CarI car = new Reno();

    @Override
    public void drive() {
        //  можем добавить что-то Своё - вызвать и т.д.
        System.out.println("proxy code");
        car.drive();
    }
}
