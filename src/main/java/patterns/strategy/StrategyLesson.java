package patterns.strategy;

public class StrategyLesson {

    public static void main(String[] args) {

        double value = 100;
        ContextStrategy contextStrategy = new ContextStrategy(new HalfPrice());
        double price = contextStrategy.getPrice(value);
        System.out.println(price);
    }
}

interface Strategy {
    double getPrice(double price);
}

class FullPrice implements Strategy {
    @Override
    public double getPrice(double price) {
        return price;
    }
}

class HalfPrice implements Strategy {
    @Override
    public double getPrice(double price) {
        return price * 0.5;
    }
}

class ContextStrategy {
    Strategy strategy;

    public ContextStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price) {
        return strategy.getPrice(price);
    }
}