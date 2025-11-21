package decorator.reto;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Pedidos de Cafetería (Implementación Rígida) ---");

        // 1. Café simple
        Beverage simpleCoffee = new Coffee();
        System.out.println("Pedido 1: " + simpleCoffee.getDescription() + " | Costo: $" + simpleCoffee.getCost()); // Café Base | Costo: $2.0

        // 2. Café con Leche
        Beverage milkCoffee = new MilkCoffee();
        System.out.println("Pedido 2: " + milkCoffee.getDescription() + " | Costo: $" + milkCoffee.getCost()); // Café Base, con Leche | Costo: $2.5

        // 3. Café con Crema Batida Y Leche (Necesita una clase específica)
        Beverage customCoffee = new MilkAndWhipCoffee();
        System.out.println("Pedido 3: " + customCoffee.getDescription() + " | Costo: $" + customCoffee.getCost()); // Café Base, con Leche, con Crema Batida | Costo: $3.2

        // 4. ¿Cómo creamos un Café *solo* con Crema Batida y *sin* Leche usando MilkAndWhipCoffee?
        // No es posible, necesitamos otra clase (WhipCoffeeAndNoMilk)... ¡Y el problema crece!
    }
}