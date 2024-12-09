package Model;

/*
Abstract class that gives the blueprint for representing the state of the different Pomodoro sessions
Concrete classes like: WorkState, ShortBreakState, LongBreakState will implement the abstract methods

https://refactoring.guru/design-patterns/state/java/example
 */
public abstract class PomodoroState {
    protected PomodoroApp pomodoroApp;// instance of pomodoro App

    public PomodoroState(PomodoroApp pomodoroApp) {
        this.pomodoroApp = pomodoroApp;
    }

    public abstract void start();
    public abstract void pause();
    public abstract void reset();
}
