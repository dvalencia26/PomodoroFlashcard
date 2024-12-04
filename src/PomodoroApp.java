public class PomodoroApp {
    private CountDownTimer timer ;
    private PomodoroState currentState; // Keeps a reference of the current state
    private int pomodorosCompleted;
    private int workduration;
    private int longBreakDuration;
    private int shortBreakDuration;



    public PomodoroApp(int WorkDuration, int LongBreakDuration) {
        this.timer = new CountDownTimer();
        this.workduration = WorkDuration;
        this.shortBreakDuration = 0;
        this.longBreakDuration = 5;
        this.pomodorosCompleted = 0;
        this.currentState = new WorkState(this);
    }

    public void start(){
        currentState.start();
    }
    public void pause(){
        currentState.pause();
    }
    public void reset(){
        currentState.reset();
    }

//    public void setState(PomodoroState state) {
//        this.currentState = state;
//    }

    public void PomodorosCompleted(){
        pomodorosCompleted++;
        if (pomodorosCompleted == 4){
            currentState = new LongBreakState(this);
        }
        else if (pomodorosCompleted < 4){
            // Take a 5-minute break
            currentState = new ShortBreakState(this);
        }
    }

    public CountDownTimer getTimer() {
        return timer;
    }

    public int getPomodorosCompleted(){
        return pomodorosCompleted;
    }

    public int getWorkduration(){
        return workduration;
    }
}
