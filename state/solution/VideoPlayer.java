public class VideoPlayer {
    private State state;
    private boolean playing = false;

    public VideoPlayer() {
        // Estado inicial
        this.state = new ReadyState();
    }

    public void changeState(State newState) {
        this.state = newState;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    // Los botones solo delegan al estado actual
    public void pressPlay() {
        state.clickPlay(this);
    }

    public void pressStop() {
        state.clickStop(this);
    }

    public void pressLock() {
        state.clickLock(this);
    }
}