import java.time.Clock;

public abstract class PomodoroState {
    protected PomodoroApp pomodoroApp;

    public PomodoroState(PomodoroApp pomodoroApp) {
        this.pomodoroApp = pomodoroApp;
    }

    public abstract void start();
    public abstract void pause();
    public abstract void reset();
}
