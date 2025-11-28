# Solución (State)

:warning: **Intenta resolver el reto antes de ver la solución** :warning:

## Cambios Principales

La refactorización eliminó por completo los bloques switch y if-else dependientes del estado, delegando el comportamiento a objetos dedicados.

1. **Interfaz `State`**: Se creó una interfaz común que define los métodos de acción: clickPlay(), clickStop(), clickLock(). Estos métodos reciben una referencia al VideoPlayer (Contexto) para poder ejecutar transiciones de estado (ej. `player.changeState(...)`).
2. **Clases de estado concretas**: Cada "case" de los antiguos switch se movió a su clase correspondiente. Por ejemplo, la lógica de "Qué pasa si doy Play cuando está Bloqueado" ahora vive exclusivamente en `LockedState.java`.
3. **Clase `VideoPlayer.java`**: 
    - La variable `String state` fue reemplazada por `State state`.
    - Los métodos `pressPlay()`, `pressStop()`, etc., ahora son pasarelas simples: solo llaman a `state.clickPlay(this)`.
    - La clase se limpió drásticamente y ya no contiene lógica de negocio sobre las reglas del estado.

## Salida Esperada

El comportamiento externo del reproductor no ha cambiado, pero su estructura interna es ahora robusta y extensible.

```
--- Inicio ---
Listo -> Reproduciendo video.
Estado Interno: MOTOR ON
Reproduciendo -> Pausando video. (o Volviendo a Ready)
Estado Interno: MOTOR OFF

--- Probando Bloqueo ---
Listo -> Reproduciendo video.
Estado Interno: MOTOR ON
Reproduciendo -> Bloqueando interfaz (Video sigue sonando).
Bloqueado: No se puede reproducir.
Bloqueado: No se puede detener.
Bloqueado -> Desbloqueando.
Reproduciendo -> Deteniendo video.
Estado Interno: MOTOR OFF
```

## Extendiendo la funcionalidad
El Patrón State hace que añadir nuevos estados sea trivial:

1. Si queremos añadir el estado `Rewinding` solo debemos de crear su clase e implementar la interfaz `State`, definir qué pasa al dar Play, Stop o Lock mientras se rebobina e ir a la clase PlayingState y modificar clickRewind() (si existiera el botón) para transicionar a este nuevo estado.
2. Podemos añadir un nuevo evento añadiendo `clickNext()` a la interfaz `State` y añadir su comportamiendo en los demas estados.