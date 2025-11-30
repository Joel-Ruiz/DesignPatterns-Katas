public class SoyMilk extends CondimentDecorator {
    public SoyMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Leche de Soya";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 1.2;
    }
    
}
