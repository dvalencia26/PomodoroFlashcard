package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * PomodoroApp has an instance of the Pomodoro state (work, short break, long break),
 * It manages transitions between states, and keeps track of pomodoros completed
 * It notifies observers (GUI Panels) when the timer or state changes.
 *
 * author: Domenica
 */

public class PomodoroApp implements Subject{
    private CountDownTimer timer ; // Manages TimerCountDown logic
    private PomodoroState currentState; // Keeps a reference of the current state
    private int pomodorosCompleted; // Counter for completed Pomodoros
    private int workduration;   // Duration of Work Session
    private int longBreakDuration; // Duration of Long Break
    private int shortBreakDuration; // Duration of Short Break
    private List<Observer> observers; // List of Observers to be notified


    /* Constructor to initialize corresponding session times.
     */
    public PomodoroApp(int WorkDuration, int shortBreakDuration, int LongBreakDuration) {
        this.workduration = WorkDuration;
        this.shortBreakDuration = shortBreakDuration;
        this.longBreakDuration = LongBreakDuration;
        this.pomodorosCompleted = 0;
        this.currentState = new WorkState(this);
        this.observers = new ArrayList<>();
        this.timer = new CountDownTimer(this);
        resetTimer(); // Resets initial Timer Display
    }

    //  Calls the corresponding start, pause and reset methods based on the currentState
    public void start(){
        currentState.start();
    }
    public void pause(){
        currentState.pause();
    }
    public void reset(){
        currentState.reset();
    }

    // Changes the states of the session
    public void setState(PomodoroState state) {
            this.currentState = state;
            resetTimer(); // Resets timer
            notifyObservers(); // Notify observers of state change
    }

    // Resets timer based on the currentState
    public void resetTimer() {
        if (currentState instanceof WorkState) {
            timer.resetTimer(workduration);
        } else if (currentState instanceof ShortBreakState) {
            timer.resetTimer(shortBreakDuration);
        } else if (currentState instanceof LongBreakState) {
            timer.resetTimer(longBreakDuration);
        }
    }

    /* Called by CountDownTimer when timer reaches zero
    Handles the logic to transition between states
    and increments pomodoros after work session has been completed
     */
    public void PomodoroCompleted() {
        // Checks the currentState
        if (currentState instanceof WorkState) {
            pomodorosCompleted++;
            System.out.println("Pomodoro completed: " + pomodorosCompleted);

            // Ask user for break or start new session
            boolean takeBreak = BreakDialog.askUserForBreak(null);

            // Sets state based on the number of completed Pomodoros and user choice
            if (getPomodorosCompleted() % 4 == 0) {
                setState(new LongBreakState(this));
            } else if (takeBreak) {
                setState(new ShortBreakState(this));
            } else {
                setState(new WorkState(this));
            }

        } else if (currentState instanceof ShortBreakState || currentState instanceof LongBreakState) {
            // After any break, return to work session
            setState(new WorkState(this));
        }
    }

    // Getters methods
    public CountDownTimer getTimer() {
        return timer;
    }
    public PomodoroState getCurrentState() {
        return currentState;
    }

    public int getPomodorosCompleted(){
        return pomodorosCompleted;
    }

    public int getWorkduration(){
        return workduration;
    }
    public int getShortBreakDuration(){
        return shortBreakDuration;
    }
    public int getLongBreakDuration(){
        return longBreakDuration;
    }

    // Implementation of Subject Interface methods to add, remove and notify Observers
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(timer.getSeconds());
        }
    }
}
