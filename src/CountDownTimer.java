import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observer;
import javax.swing.Timer;

public class CountDownTimer {

    private int minutes;
    private int seconds;
    private Timer timer;
    //private int pomodorosCompleted;
    private PomodoroState currentState;
    private boolean isRunning;
    private List<Observer> observers; //Notify user about changes

    public CountDownTimer() {
    }

    public void startTimer(int duration){
        this.seconds = duration * 60;
        this.isRunning = true;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seconds > 0){
                    seconds--;
                }else {
                    pauseTimer();
                }
            }
        });
        timer.start();
    }

    public void pauseTimer(){
        if (timer != null){
            timer.stop();
            this.isRunning = false;
        }
    }

    public void resetTimer(int minutes){
        this.seconds =  minutes * 60;
        this.isRunning = false;
    }

   /* public void incrementPom(){
        this.pomodorosCompleted++;
    }

    public void resetPomodoro(){
        this.pomodorosCompleted = 0;
    }

    public int getPomodorosCompleted() {
        return pomodorosCompleted;
    }

    public void setPomodorosCompleted(int sessionsCompleted) {
        this.pomodorosCompleted = sessionsCompleted;
    }
    */
}
