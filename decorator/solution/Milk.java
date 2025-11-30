public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Leche";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.5;
    }
    
}
