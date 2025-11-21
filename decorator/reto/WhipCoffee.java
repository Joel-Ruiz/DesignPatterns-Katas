package decorator.reto;

public class WhipCoffee extends Coffee {
    @Override
    public String getDescription() {
        return super.getDescription() + ", con Crema Batida";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.7; // Costo de la crema
    }
}