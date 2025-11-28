package state.reto;

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