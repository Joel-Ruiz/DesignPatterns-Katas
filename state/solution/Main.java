public class Main {
    public static void main(String[] args) {
        VideoPlayer player = new VideoPlayer();

        player.pressPlay();  // Listo -> Reproduciendo.
        player.pressLock();  // Reproduciendo -> Bloqueando (Video sigue).
        player.pressPlay();  // Bloqueado -> Desbloqueando y Reproduciendo.
        player.pressStop();  // Reproduciendo -> Deteniendo.
    }
}
