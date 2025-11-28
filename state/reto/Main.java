package state.reto;

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