# Kata: Composite

## Contexto



## El Patrón: Composite



## Beneficios y Principios SOLID

Beneficios:



Principios SOLID:

- **SRP**: Cada clase (Builder, Director, Producto) tiene una única responsabilidad: construir, dirigir o representar el objeto.
- **OCP**: Puedes extender el comportamiento del Builder (por ejemplo, nuevos tipos de construcción) sin modificar el código existente.
- **LSP** Si usas una jerarquía de Builders, cada subclase puede sustituir a su padre sin alterar el funcionamiento del Director.
- **ISP**: Los Builders pueden implementar interfaces específicas para construir solo lo necesario, evitando métodos innecesarios.
- **DIP**: El Director depende de una abstracción del Builder, no de una implementación concreta, lo que permite inyectar diferentes estrategias de construcción.

## ¿Cuándo usar este patrón?



## Reto

Para poner en práctica el patrón Composite, consulta el [README del reto](./reto/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - Composite Pattern]()
- [Source Making - Composite Pattern]()
