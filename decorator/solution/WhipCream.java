public class WhipCream extends CondimentDecorator {
    public WhipCream(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Crema Batida";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.7;
    }
    
}
