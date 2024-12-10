package Model;

/**
LongBreakState represents the state during a long break session.
After completing 4 work session (Pomodoros), the user is set to this state to have a longer break
 */
public class LongBreakState extends PomodoroState{

    // Constructor takes a reference of PomodoroApp to call methods to start, pause or reset the time.
    public LongBreakState(PomodoroApp pomodoroApp){
        super(pomodoroApp);
    }
    @Override
    public void start() {
        // uses startTimer from CountDownTimer Class
        pomodoroApp.getTimer().startTimer(pomodoroApp.getLongBreakDuration());//Start 15 or 30-minutes break
        System.out.println("Long Break started");
    }

    @Override
    public void pause() {
        pomodoroApp.getTimer().pauseTimer();
        System.out.println("Long Break paused");
    }

    @Override
    public void reset() {
        pomodoroApp.getTimer().resetTimer(pomodoroApp.getLongBreakDuration());
        System.out.println("Long Break reset");
    }
}
