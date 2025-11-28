package decorator.challenge;

public class MilkAndWhipCoffee extends MilkCoffee {
    @Override
    public String getDescription() {
        // Asumiendo que MilkCoffee ya incluye "con Leche"
        return super.getDescription() + ", con Crema Batida"; 
    }

    @Override
    public double getCost() {
        // Suma el costo base (Coffee), el de Milk, y el de Whip
        // Es fácil cometer errores de cálculo aquí.
        return super.getCost() + 0.7; 
    }
}