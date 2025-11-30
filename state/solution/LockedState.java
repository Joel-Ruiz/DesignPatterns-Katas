public class LockedState implements State {
    @Override
    public void clickPlay(VideoPlayer player) {
        System.out.println("Bloqueado -> Desbloqueando y Reproduciendo.");
        player.setPlaying(true);
        player.changeState(new PlayingState());
    }

    @Override
    public void clickStop(VideoPlayer player) {
        System.out.println("Bloqueado -> Desbloqueando y Deteniendo.");
        player.setPlaying(false);
        player.changeState(new ReadyState());
    }

    @Override
    public void clickLock(VideoPlayer player) {
        System.out.println("Bloqueado -> Ya está bloqueado.");
    }
    
}
