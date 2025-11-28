# Reto (Composite)

## Instrucciones

El código en este directorio simula un sistema de inventario que maneja productos individuales y cajas de productos.
Actualmente, el sistema sufre de falta de uniformidad: el código cliente debe tratar a las cajas y a los productos de manera diferente, y la clase `ProductBox` depende de verificaciones de tipo (`instanceof`) para calcular precios, lo cual es frágil y difícil de mantener.
Tu objetivo es refactorizar este sistema aplicando el Patrón Composite para tratar tanto a los productos individuales como a las cajas de manera uniforme.

## Codigo a refactorizar

**Archivo: `Product.java`**
```java
package composite.reto;

public class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
```

**Archivo: `ProductBox.java`**
```java
package composite.reto;

import java.util.ArrayList;
import java.util.List;

public class ProductBox {
    private String name;
    private List<Object> children = new ArrayList<>();

    public ProductBox(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Object component) {
        children.add(component);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        
        for (Object component : children) {
            if (component instanceof Product) {
                totalPrice += ((Product) component).getPrice();
            } else if (component instanceof ProductBox) {
                totalPrice += ((ProductBox) component).calculateTotalPrice();
            } else {
                System.err.println("Advertencia: Componente desconocido en la caja.");
            }
        }
        return totalPrice;
    }
}
```

**Archivo: `Main.java`**
```java
package composite.reto;

public class Main {
    public static void main(String[] args) {

        Product camisa = new Product("Camisa de Algodón", 25.0);
        Product pantalon = new Product("Pantalón de Lona", 50.0);
        Product calcetines = new Product("Calcetines (Par)", 5.0);

        ProductBox cajaRopa = new ProductBox("Caja de Ropa Casual");
        cajaRopa.add(camisa);
        cajaRopa.add(pantalon);

        ProductBox cajaAccesorios = new ProductBox("Caja de Accesorios");
        cajaAccesorios.add(calcetines);
        cajaAccesorios.add(new Product("Corbata", 15.0));

        ProductBox cajaMaestra = new ProductBox("Gran Kit de Regalo");
        cajaMaestra.add(cajaRopa);
        cajaMaestra.add(cajaAccesorios);
        cajaMaestra.add(new Product("Tarjeta de Regalo", 10.0)); 
        
        System.out.println("--- Reporte de Precios del Inventario ---");
        
        System.out.println("Precio de la Camisa: $" + camisa.getPrice()); 

        System.out.println("Precio de la Caja Maestra: $" + cajaMaestra.calculateTotalPrice()); 
    }
}
```

## Tips

1. Recursividad
    - Al llamar a `cajaMaestra.getPrice()`, ¿qué sucede internamente? ¿Cómo se propaga la llamada a través de las cajas anidadas hasta llegar a los productos individuales?
    - Concepto Clave: El patrón Composite convierte una estructura de árbol compleja en una estructura simple de recorrer mediante delegación recursiva. El compuesto delega el trabajo a sus hijos, sin saber si son hojas u otros compuestos.
2. Simplificación
    - Observa el nuevo Main.java. Si mañana se decide crear un nuevo tipo de contenedor (ej. Pallet o ContenedorMaritimo), ¿tendrías que cambiar el código del Main que calcula el precio total?
    - Beneficio: El cliente se vuelve agnóstico a la estructura concreta de los objetos. Solo sabe que "tienen un precio".

## Recursos adicionales

[Refactoring Guru - Composite Pattern](https://refactoring.guru/design-patterns/composite)
[Source Making - Composite Pattern](https://sourcemaking.com/design_patterns/composite)