# Reto (State)

## Instrucciones

El código en este directorio simula el firmware de un reproductor de video.
Actualmente, la clase `VideoPlayer` gestiona sus estados (`LOCKED`, `PLAYING`, `READY`) utilizando una serie de condicionales switch masivos dentro de cada método de acción (`pressPlay`, `pressStop`, etc.).
Este diseño viola el Principio Abierto/Cerrado: si quisieras agregar un nuevo estado (ej. "Rebobinando"), tendrías que modificar cada uno de los métodos existentes, aumentando el riesgo de introducir bugs.
Tu objetivo es refactorizar este sistema aplicando el Patrón State para encapsular el comportamiento de cada estado en su propia clase.

## Codigo a refactorizar

**Archivo: `VideoPlayer.java`**
```java
package reto;

/**
 * Clase que simula un reproductor de video.
 * Utiliza lógica condicional excesiva para manejar los estados.
 */
public class VideoPlayer {
    
    // Estados posibles definidos como constantes o Enum
    private static final String LOCKED = "LOCKED";
    private static final String PLAYING = "PLAYING";
    private static final String READY = "READY"; // Detenido y listo

    private String state;
    private boolean playing = false;

    public VideoPlayer() {
        this.state = READY;
        setPlaying(false);
    }

    // --- MÉTODOS DE LA INTERFAZ (BOTONES) ---
    // El problema: Cada método tiene un SWITCH gigante.

    public void pressPlay() {
        switch (state) {
            case LOCKED:
                System.out.println("Bloqueado: No se puede reproducir.");
                break;
            case READY:
                System.out.println("Listo -> Reproduciendo video.");
                this.state = PLAYING;
                setPlaying(true);
                break;
            case PLAYING:
                System.out.println("Reproduciendo -> Pausando video.");
                this.state = READY; // Asumimos que pausa vuelve a ready o crea estado Paused
                setPlaying(false);
                break;
        }
    }

    public void pressStop() {
        switch (state) {
            case LOCKED:
                System.out.println("Bloqueado: No se puede detener.");
                break;
            case READY:
                System.out.println("Listo: Ya está detenido.");
                break;
            case PLAYING:
                System.out.println("Reproduciendo -> Deteniendo video.");
                this.state = READY;
                setPlaying(false);
                break;
        }
    }

    public void pressLock() {
        switch (state) {
            case LOCKED:
                System.out.println("Bloqueado -> Desbloqueando.");
                this.state = READY;
                break;
            case READY:
                System.out.println("Listo -> Bloqueando interfaz.");
                this.state = LOCKED;
                break;
            case PLAYING:
                System.out.println("Reproduciendo -> Bloqueando interfaz (Video sigue sonando).");
                this.state = LOCKED;
                break;
        }
    }
    
    // Método auxiliar
    private void setPlaying(boolean playing) {
        this.playing = playing;
        System.out.println("Estado Interno: " + (this.playing ? "MOTOR ON" : "MOTOR OFF"));
    }
}
```

**Archivo: `Main.java`**
```java
package reto;

public class Main {
    public static void main(String[] args) {
        VideoPlayer player = new VideoPlayer();

        // 1. Uso normal
        System.out.println("--- Inicio ---");
        player.pressPlay(); // Debería reproducir
        player.pressPlay(); // Debería pausar

        // 2. Uso con bloqueo
        System.out.println("\n--- Probando Bloqueo ---");
        player.pressPlay(); // Reproducir
        player.pressLock(); // Bloquear
        
        // Intentar acciones mientras está bloqueado
        player.pressPlay(); // No debería hacer nada
        player.pressStop(); // No debería hacer nada
        
        // Desbloquear y detener
        player.pressLock(); // Desbloquear
        player.pressStop(); // Detener
    }
}
```

## Tips

1. Eliminación de condicionales
    - Mira la clase VideoPlayer al terminar. ¿Ves algún if o switch relacionado con el estado? Deberían haber desaparecido por completo. La lógica de control de flujo ahora es polimorfismo puro.
2. Responsabilidad de la transición
    - ¿Quién decide cuál es el siguiente estado? ¿El propio estado actual o el contexto (VideoPlayer)?
    - En este patrón, es común que el Estado Concreto sepa cuál es su sucesor (ej. PlayingState sabe que al dar Stop pasa a ReadyState). Esto descentraliza la lógica de flujo.
3. Principio Abierto/Cerrado
    - Si quisieras agregar un estado RewindState (Rebobinando), ¿qué archivos tendrías que tocar ahora?
    
## Recursos adicionales

- [Refactoring Guru - State Pattern](https://refactoring.guru/design-patterns/state)
- [Source Making - State Pattern](https://sourcemaking.com/design_patterns/state)