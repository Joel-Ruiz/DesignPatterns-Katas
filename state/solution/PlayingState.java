public class PlayingState implements State {
    @Override
    public void clickPlay(VideoPlayer player) {
        System.out.println("Reproduciendo -> Pausando.");
        player.setPlaying(false);
        player.changeState(new ReadyState());
    }

    @Override
    public void clickStop(VideoPlayer player) {
        System.out.println("Reproduciendo -> Deteniendo.");
        player.setPlaying(false);
        player.changeState(new ReadyState());
    }

    @Override
    public void clickLock(VideoPlayer player) {
        System.out.println("Reproduciendo -> Bloqueando (Video sigue).");
        player.changeState(new LockedState());
    }
}