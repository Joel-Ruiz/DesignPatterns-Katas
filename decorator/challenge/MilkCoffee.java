package decorator.challenge;

public class MilkCoffee extends Coffee {
    @Override
    public String getDescription() {
        return super.getDescription() + ", con Leche";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5; // Costo de la leche
    }
}