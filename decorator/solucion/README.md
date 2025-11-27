# Solución (Decorator)

:warning: **Intenta resolver el reto antes de ver la solución** :warning:

## Cambios Principales

La refactorización se centró en eliminar las subclases rígidas (`MilkCoffee`, `MilkAndWhipCoffee`) y reemplazar la herencia por la composición, aplicando el Patrón Decorator.

1. Abstracción del Decorador: Se introdujo la clase abstracta CondimentDecorator que implementa la interfaz Beverage y contiene una referencia (composición) a un objeto Beverage envuelto. Esto asegura que todos los decoradores actúen como la bebida que envuelven.
2. Eliminación de Clases Rígidas: Se eliminaron las clases MilkCoffee, WhipCoffee y MilkAndWhipCoffee por completo, ya que encapsulaban combinaciones estáticas.
3. Decoradores Concretos: Se crearon nuevas clases concretas (Milk, WhipCream) que heredan de CondimentDecorator. Estos decoradores sobrescriben los métodos getCost() y getDescription(), llamando a la implementación del objeto envuelto (super.getCost()) antes de añadir su propia funcionalidad.
4. Principio Abierto/Cerrado (OCP): El código cliente ahora puede añadir cualquier nueva adición simplemente creando una nueva clase Decorator sin modificar la interfaz Beverage ni las clases base (Coffee).

## Salida Esperada

```
--- Pedidos de Cafetería (Implementación Flexible) ---
Pedido 1: Café Base | Costo: $2.0
Pedido 2: Café Base, con Leche | Costo: $2.5
Pedido 3: Café Base, con Leche, con Crema Batida | Costo: $3.2
Pedido 4: Café Base, con Crema Batida, con Leche | Costo: $3.2
```

El patrón Decorator proporciona una ruta de extensión limpia y alineada con los principios SOLID:
1. Ahora se puede añadir de manera sencilla un nuevo condimento (`Chocolate`).
2. Ahora se puede añadir de manera secilla  un nuevo tipo de bebida base (`Tea`).
3. Podemos usar el patron Decorator para añadir nueva funcionalidad,como imprimir un recibo sin tener que modificar las clases existentes.