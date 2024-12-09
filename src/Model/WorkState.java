package Model;

/*
Uses a reference of pomodoroApp that calls the startTimer from the CountDownTimer
to start the Work Timer in the GUI
 */
public class WorkState extends PomodoroState {

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
