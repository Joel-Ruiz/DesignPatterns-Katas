# Solución (Composite)

:warning: **Intenta resolver el reto antes de ver la solución** :warning:

## Cambios Principales

La refactorización transformó el tratamiento de objetos individuales y contenedores para que sean uniformes, eliminando la necesidad de verificaciones de tipo (`instanceof`).

1. **Interfaz Unificadora (`InventoryComponent`)**: Se creó una interfaz común (o clase abstracta) que define el contrato `getPrice()`. Esto permite que tanto los productos como las cajas sean tratados como "cosas que tienen precio".
2. **Clase `Product` (Hoja)**: Ahora implementa `InventoryComponent`. Su implementación de `getPrice()` simplemente retorna su precio definido.
3. **Clase `ProductBox` (Compuesto)**: 
    - También implementa `InventoryComponent`. 
    - La lista interna cambió de `List<Object>` a `List<InventoryComponent>`.
    - El método `getPrice()` (antes `calculateTotalPrice`) ya no usa if/else ni instanceof. Simplemente recorre la lista de hijos y llama a `child.getPrice()`, sumando los resultados. El polimorfismo se encarga de saber si el hijo es un producto o u otra caja.
4. **Cliente (`Main.java`)**: El código cliente ya no distingue entre cajas y productos. Puede llamar a `.getPrice()` sobre cualquier elemento del inventario sin importar su complejidad interna.

## Salida Esperada

La salida refleja el cálculo recursivo del precio total. Aunque la lógica interna cambió drásticamente, el resultado numérico debe ser el mismo que en el reto:

```
--- Reporte de Precios del Inventario (Composite) ---
Precio de la Camisa: $25.0
Precio de la Caja Maestra: $105.0
```

El Patrón Composite brilla cuando necesitas escalar la jerarquía o añadir nuevas operaciones:
1. Si quisieramos agregar el peso de los productos, por ejemplo, solo necesitariamos agregar `getWeight()` a la interfaz unificadora.
2. Podemos añadir nuevos tipos de contenedores como un `Bundle` que aplique un descuento a la suma total del precio de sus hijos.
3. Podemos agregar nuevos tipos de productos solo implementandoles la interfaz unificadora.