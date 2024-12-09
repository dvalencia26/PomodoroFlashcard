package Model;

/*
ShortBreakState represents the state during a short break session
 */
public class ShortBreakState extends PomodoroState{

    // Constructor takes a reference of PomodoroApp to call methods to start, pause or reset the time.
    public ShortBreakState(PomodoroApp pomodoroApp){
        super(pomodoroApp);
    }
    @Override
    public void start() {
        // uses startTimer from CountDownTimer Class
        pomodoroApp.getTimer().startTimer(pomodoroApp.getShortBreakDuration());//Start break timer
        System.out.println("Short Break started");
    }

    @Override
    public void pause() {
        pomodoroApp.getTimer().pauseTimer(); // Pause timer
        System.out.println("Short Break  paused");
    }

    @Override
    public void reset() {
        pomodoroApp.getTimer().resetTimer(pomodoroApp.getShortBreakDuration());// Reset timer
        System.out.println("Short Break  reset");
    }
}
