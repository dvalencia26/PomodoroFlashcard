public class WorkState extends PomodoroState {

    public WorkState(PomodoroApp pomodoroApp){
        super(pomodoroApp);
    }
    @Override
    public void start() {
        // uses startTimer from CountDownTimer Class
        pomodoroApp.getTimer().startTimer(pomodoroApp.getWorkduration());//Start 25-minutes of work
        System.out.println("Working session started");
    }

    @Override
    public void pause() {
        pomodoroApp.getTimer().pauseTimer();
        System.out.println("Working session paused");
    }

    @Override
    public void reset() {
        pomodoroApp.getTimer().resetTimer(pomodoroApp.getWorkduration());
        System.out.println("Working session reset");
    }
}
