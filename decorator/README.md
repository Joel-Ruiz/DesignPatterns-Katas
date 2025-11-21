# Kata: Decorator

## Contexto

Estás desarrollando un sistema de pedidos para una cafetería que permite a los usuarios seleccionar una bebida base (ej. Coffee, Tea) y agregar múltiples adiciones o modificadores (ej. Milk, Sugar, WhipCream, SoyMilk).
El código actual intenta manejar las adiciones de dos maneras problemáticas:

1. Se crean subclases para cada combinación: MilkCoffee, SugarCoffee, MilkSugarCoffee, lo que lleva a una explosión exponencial de clases a medida que se añaden nuevos modificadores.

2. Intentar añadir un boolean o una lista de adiciones dentro de la clase base `Beverage` y luego modificar el costo en un solo método `calculateCost()`. Esto viola el Principio Abierto/Cerrado (OCP) porque tienes que modificar la clase base cada vez que añades un nuevo ingrediente.

## El Patrón: Decorator

El patrón Decorator **permite adjuntar dinámicamente responsabilidades adicionales a un objeto**. Proporciona una alternativa flexible a la herencia estática para extender la funcionalidad.
El Decorator resuelve el problema de la explosión de clases al:

- Crear una interfaz común (Componente) que define el objeto base y sus decoradores.
- Crear una clase abstracta Decorator que envuelve al componente y delega las operaciones, añadiendo su propia lógica antes o después de la llamada.
- Permitir que múltiples decoradores se envuelvan secuencialmente uno sobre otro.

## Beneficios y Principios SOLID

Beneficios:

- **Composición Flexible**: Permite crear y combinar funcionalidades de manera dinámica en tiempo de ejecución, en lugar de definirlas estáticamente en el diseño.
- **Encapsulación**: Cada adición (decorador) encapsula su propia lógica (costo, descripción, etc.) sin afectar a otros decoradores o al componente base.
- **Transparencia**: El código cliente puede tratar a un objeto envuelto por uno o más decoradores de la misma manera que trata al objeto base, gracias a la interfaz común.

Principios SOLID:

- **OCP**: La clase base y las adiciones existentes son cerradas a la modificación, pero el sistema es abierto a la extensión, ya que se pueden añadir nuevos decoradores sin tocar el código existente.
- **LSP** Todos los decoradores y el objeto base implementan la misma interfaz, asegurando que cualquier decorador pueda ser sustituido por el componente base o viceversa sin romper la funcionalidad esperada por el cliente.

## ¿Cuándo usar este patrón?

- **Adición Dinámica de Comportamiento**: Cuando necesitas añadir responsabilidades a objetos individuales de forma dinámica y transparente (sin que el cliente lo note).
- **Alternativa a la Herencia**: Cuando la herencia no es práctica y llevaría a demasiadas subclases para cubrir todas las combinaciones posibles de características (como en el ejemplo de los toppings).
- **Envoltura de Funcionalidad**: Cuando necesitas aislar y añadir nuevas funcionalidades (como logging, cifrado, o compresión) a un objeto existente.

## Reto

Para poner en práctica el patrón Decorator, consulta el [README del reto](./reto/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - Decorator Pattern](https://refactoring.guru/design-patterns/decorator)
- [Source Making - Decorator Pattern](https://sourcemaking.com/design_patterns/decorator)
