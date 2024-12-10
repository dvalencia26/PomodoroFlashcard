package Model;

/**
 * WorkState represents the Pomodoro state during a working session.
 * This state will start the work timer. When the timer reaches zero,
 * the session is marked as completed (incrementing the Pomodoros counter).
 *
 * author: Domenica
 */
public class WorkState extends PomodoroState {

    // Uses a reference of pomodoroApp that calls the startTimer from the CountDownTimer
    public WorkState(PomodoroApp pomodoroApp){
        super(pomodoroApp);
    }
    @Override
    public void start() {
        // StartTimer from CountDownTimer Class
        pomodoroApp.getTimer().startTimer(pomodoroApp.getWorkduration());//Start 25-minutes of work
        System.out.println("Working session started");
    }

    @Override
    public void pause() {
        //Pauses the current work session timer
        pomodoroApp.getTimer().pauseTimer();
        System.out.println("Working session paused");
    }

    @Override
    public void reset() {
        // Resets timer for the current work session timer
        pomodoroApp.getTimer().resetTimer(pomodoroApp.getWorkduration());
        System.out.println("Working session reset");
    }
}
