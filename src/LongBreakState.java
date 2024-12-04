public class LongBreakState extends PomodoroState{
    public LongBreakState(PomodoroApp pomodoroApp){
        super(pomodoroApp);
    }
    @Override
    public void start() {
        // uses startTimer from CountDownTimer Class
        pomodoroApp.getTimer().startTimer(pomodoroApp.getWorkduration());//Start 25-minutes of work
        System.out.println("Long Break started");
    }

    @Override
    public void pause() {
        pomodoroApp.getTimer().pauseTimer();
        System.out.println("Long Break paused");
    }

    @Override
    public void reset() {
        pomodoroApp.getTimer().resetTimer(pomodoroApp.getWorkduration());
        System.out.println("Long Break reset");
    }
}
