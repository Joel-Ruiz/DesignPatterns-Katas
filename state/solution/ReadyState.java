public class ReadyState implements State {
    @Override
    public void clickPlay(VideoPlayer player) {
        System.out.println("Listo -> Reproduciendo.");
        player.setPlaying(true);
        player.changeState(new PlayingState());
    }

    @Override
    public void clickStop(VideoPlayer player) {
        System.out.println("Listo -> Ya está detenido.");
    }

    @Override
    public void clickLock(VideoPlayer player) {
        System.out.println("Listo -> Bloqueando.");
        player.changeState(new LockedState());
    }
    
}
