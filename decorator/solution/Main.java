public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Pedidos de Cafetería (Implementación Con Decorator) ---");

        // 1. Café simple
        Beverage simpleCoffee = new Coffee();
        System.out.println("Pedido 1: " + simpleCoffee.getDescription() + " | Costo: $" + simpleCoffee.getCost());

        // 2. Café con Leche
        Beverage milkCoffee = new Milk(new Coffee());
        System.out.println("Pedido 2: " + milkCoffee.getDescription() + " | Costo: $" + milkCoffee.getCost());

        // 3. Café con Crema Batida Y Leche
        Beverage customCoffee = new WhipCream(new Milk(new Coffee()));
        System.out.println("Pedido 3: " + customCoffee.getDescription() + " | Costo: $" + customCoffee.getCost());
        
        // 4. Café con Leche de Soya y Crema Batida
        Beverage soyWhipCoffee = new WhipCream(new SoyMilk(new Coffee()));
        System.out.println("Pedido 4: " + soyWhipCoffee.getDescription() + " | Costo: $" + soyWhipCoffee.getCost());
    }
}