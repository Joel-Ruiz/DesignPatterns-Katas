# Kata: Builder

## Contexto

Estás desarrollando un sistema para construir diferentes tipos de mensajes de notificación (ej. Email, SMS, Push Notification) que se envían a los usuarios. El código actual utiliza el Constructor Telescópico; tiene múltiples constructores sobrecargados para manejar las diferentes combinaciones de campos opcionales, lo que resulta en un código difícil de leer, propenso a errores y complicado de mantener a medida que se añaden más opciones.

## El Patrón: Builder

El patrón Builder **permite construir objetos complejos paso a paso**. Este patrón permite producir diferentes tipos y representaciones de un objeto utilizando el mismo código de construcción.
El Builder resuelve el problema del Constructor Telescópico al:

- Crear una clase Builder que contiene métodos sencillos para configurar cada parte opcional del objeto.
- Permitir que el proceso de construcción se realice paso a paso.
- Ofrecer un método final (`build()`) que devuelve el objeto complejo final y configurado.

## Beneficios y Principios SOLID

Beneficios:

- **Legibilidad y Mantenimiento**: Elimina los constructores con largas listas de parámetros, haciendo que el código de inicialización del objeto sea claro y explícito.
- **Immutabilidad**: Facilita la construcción de objetos inmutables, ya que todos los parámetros se establecen en el Builder.
- **Control Fino**: El director (o el cliente) puede controlar el proceso de construcción paso a paso, aplicando reglas de negocio intermedias si es necesario.
- **Opciones Claras**: Los parámetros opcionales son fáciles de manejar ya que solo se llaman los métodos set necesarios en el Builder.
- **Reusabilidad**: Puedes construir diferentes representaciones del mismo objeto sin duplicar lógica.

Principios SOLID:

- **SRP**: Cada clase (Builder, Director, Producto) tiene una única responsabilidad: construir, dirigir o representar el objeto.
- **OCP**: Puedes extender el comportamiento del Builder (por ejemplo, nuevos tipos de construcción) sin modificar el código existente.
- **LSP** Si usas una jerarquía de Builders, cada subclase puede sustituir a su padre sin alterar el funcionamiento del Director.
- **ISP**: Los Builders pueden implementar interfaces específicas para construir solo lo necesario, evitando métodos innecesarios.
- **DIP**: El Director depende de una abstracción del Builder, no de una implementación concreta, lo que permite inyectar diferentes estrategias de construcción.

## ¿Cuándo usar este patrón?

- **Objetos Complejos con Opciones**: Cuando un objeto necesita ser creado con muchos posibles atributos o configuraciones opcionales (típicamente más de 3-4 parámetros).
- **Construcción por Etapas**: Cuando el proceso de construcción del objeto requiere múltiples pasos.
- **Necesidad de Inmutabilidad**: Cuando quieres asegurar que el objeto final sea inmutable, pero su proceso de creación es complejo.

## Reto

Para poner en práctica el patrón Builder, consulta el [README del reto](./reto/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - Builder Pattern](https://refactoring.guru/design-patterns/builder)
- [Source Making - Builder Pattern](https://sourcemaking.com/design_patterns/builder)
