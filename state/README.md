# Kata: State

## Contexto

Estás desarrollando el firmware para un Reproductor de Video. La interfaz tiene tres botones físicos: Play, Stop y Rewind.
El comportamiento de estos botones cambia drásticamente dependiendo del estado actual del reproductor:

- Si el sistema está Bloqueado (Locked), los botones no hacen nada.
- Si el sistema está Reproduciendo (Playing), el botón Play pausa el video.
- Si el sistema está Pausado (Paused), el botón Play reanuda el video.
- Si el sistema está Reproduciendo, el botón Stop detiene el video y resetea el tiempo.

El código actual gestiona esto utilizando una variable state y múltiples sentencias switch o if/else gigantescas dentro de cada método de botón. Esto hace que añadir un nuevo estado (ej. Rewinding) sea una pesadilla, ya que hay que modificar todos los métodos de la clase principal.

## El Patrón: State

El patrón State permite que un objeto altere su comportamiento cuando su estado interno cambia. Parece como si el objeto cambiara de clase.
El State Pattern resuelve el problema de los condicionales gigantes al:

- Definir una interfaz State común para todos los estados posibles.
- Extraer todos los comportamientos específicos de un estado a su propia clase (ej. PlayingState, LockedState).
- Hacer que el objeto original (Context) delegue la ejecución del comportamiento a su objeto de estado actual.

## Beneficios y Principios SOLID

Beneficios:

- **Eliminación de Condicionales**: Desaparecen los bloques if-else o switch masivos que controlan el flujo según el estado.
- **Organización**: El código relacionado con un estado específico (ej. qué pasa cuando se da Play estando bloqueado) vive en un solo lugar.
- **Transiciones Explícitas**: Las transiciones de estado se vuelven explícitas (una clase estado retorna o define la siguiente clase estado).

Principios SOLID:

- **OCP**: Puedes introducir nuevos estados sin cambiar el código de los estados existentes ni de la clase Contexto (en gran medida).
- **SRP**: Cada estado es una clase separada que encapsula la lógica de ese estado específico. El contexto no necesita saber los detalles de la lógica del estado.

## ¿Cuándo usar este patrón?

- **Comportamiento Dependiente del Estado**: Cuando el comportamiento de un objeto depende de su estado y debe cambiar en tiempo de ejecución.
- **Condicionales Masivos**: Cuando tus operaciones tienen grandes estructuras condicionales que dependen del estado del objeto.

## Reto

Para poner en práctica el patrón Composite, consulta el [README del reto](./challenge/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - State Pattern](https://refactoring.guru/design-patterns/state)
- [Source Making - State Pattern](https://sourcemaking.com/design_patterns/state)
