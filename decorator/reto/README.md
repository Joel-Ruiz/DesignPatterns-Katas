# Reto (Decorator)

## Instrucciones

El código en este directorio presenta un sistema de bebidas que maneja las adiciones (leche, crema batida) mediante herencia estática (clases como `MilkCoffee`, `WhipCoffee`, etc.).
Tu objetivo es refactorizar este sistema aplicando el Patrón Decorator para eliminar la explosión de clases y permitir la adición dinámica de ingredientes a cualquier bebida base.

## Codigo a refactorizar

**Archivo: `Beverage.java`**
```java
package decorator.reto;

public interface Beverage {
    String getDescription();
    double getCost();
}
```

**Archivo: `Coffee.java`**
```java
package decorator.reto;

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
```

**Archivo: `MilkAndWhipCoffee.java`**
```java
package decorator.reto;

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
```

**Archivo: `MilkCoffee.java`**
```java
package decorator.reto;

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
```

**Archivo: `WhipCoffee.java`**
```java
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
```

**Archivo: `Main.java`**

```java
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
```

## Tips

1. Principios SOLID
    - ¿Cómo demuestra la nueva estructura del Decorator el Principio Abierto/Cerrado (OCP)? ¿Cómo podría añadir un nuevo ingrediente (Chocolate) al sistema sin modificar las clases Coffee, Milk o WhipCream?
    - Concepto Clave: Al depender de la Composición (un Decorator tiene un Componente) en lugar de la Herencia, logras una flexibilidad que la herencia estática no puede ofrecer.
2. Acoplamiento
    - ¿De qué manera el código cliente (`Main.java`) se vuelve menos acoplado a las clases concretas (`Coffee`, `MilkAndWhipCoffee`) al usar el Decorator? ¿Por qué es suficiente que el cliente solo conozca la interfaz `Beverage`?

## Recursos adicionales

[Refactoring Guru - Decorator Pattern](https://refactoring.guru/design-patterns/decorator)
[Source Making - Decorator Pattern](https://sourcemaking.com/design_patterns/decorator)