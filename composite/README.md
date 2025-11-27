# Kata: Composite

## Contexto

Estás desarrollando un sistema para administrar el inventario y los precios de los productos en una tienda. El inventario consta de **productos individuales** (ej. una camisa, un balón) y **cajas o kits de productos** (ej. una "Caja de Regalo Deportiva" que contiene una camisa, un balón y calcetines).

El código actual (en la Carpeta Reto) tiene un problema fundamental:

1. Necesitas calcular el precio total o el stock de una caja (compuesto), pero el código cliente tiene que distinguir si está tratando con un producto individual (hoja) o con una caja, usando condicionales (if instanceOf Product vs. if instanceOf Box) o forzando la creación de interfaces separadas.
2. Esto lleva a un código cliente acoplado, que pierde la capacidad de tratar a ambos tipos de objetos de forma uniforme y dificulta la composición recursiva.

## El Patrón: Composite

El patrón Composite compone objetos en estructuras de árbol para representar jerarquías de parte-todo. Permite que los clientes traten a los objetos individuales (hojas) y a las composiciones de objetos (compuestos) de manera uniforme.
El Composite resuelve el problema de la uniformidad al:

- Crear una interfaz común (Componente) que declara las operaciones para ambos tipos de objetos.
- Definir las hojas (objetos individuales) que implementan el Componente directamente.
- Definir los compuestos (contenedores) que también implementan el Componente y, además, contienen colecciones de otros Componentes (hojas o compuestos).

## Beneficios y Principios SOLID

Beneficios:

- **Uniformidad y Simplicidad**: Simplifica el código del cliente, ya que no necesita conocer la diferencia entre objetos simples y complejos, tratando a ambos con la misma interfaz.
- **Composición Recursiva**: Facilita la creación de estructuras de árbol recursivas de forma natural (una caja puede contener otras cajas).
- **Fácil Extensión**: Añadir nuevos tipos de hojas o compuestos es sencillo siempre que implementen la interfaz Componente común.

Principios SOLID:

- **OCP**: El código cliente que procesa la estructura de componentes es cerrado a la modificación, ya que puede trabajar con nuevos tipos de hojas o compuestos sin necesidad de ser alterado.
- **LSP**: Tanto las hojas (Product) como los compuestos (Box) implementan la misma interfaz. Esto garantiza que una Box se pueda usar en cualquier lugar donde se espera un Product, ya que el código cliente solo interactúa con el Componente abstracto.

## ¿Cuándo usar este patrón?

**Estructuras Jerárquicas**: Cuando se necesita representar jerarquías de objetos donde las partes se componen de partes más pequeñas (ej. sistemas de archivos, organigramas, estructuras de menús, componentes de interfaz gráfica).
**Tratamiento Uniforme**: Cuando los clientes necesitan ignorar si están tratando con objetos individuales o con grupos de objetos (composiciones).
**Operaciones Recursivas**: Cuando se requiere ejecutar operaciones que deben propagarse recursivamente a través de la jerarquía (ej. calcular el precio total, pintar un nodo del árbol).

## Reto

Para poner en práctica el patrón Composite, consulta el [README del reto](./reto/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - Composite Pattern](https://refactoring.guru/design-patterns/composite)
- [Source Making - Composite Pattern](https://sourcemaking.com/design_patterns/composite )
