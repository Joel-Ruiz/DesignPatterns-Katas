public class Coffee implements Beverage {
    @Override
    public String getDescription() {
        return "Café Base";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}
