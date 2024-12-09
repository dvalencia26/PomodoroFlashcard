package Model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/*
Create Beep Sound in Java
https://java-demos.blogspot.com/2012/11/create-beep-sound-in-java.html
 */
public class CountDownTimer  {

    private int seconds; // Remaining time in seconds
    private Timer timer; // Swing Class Timer to initialize countDown
    private boolean isRunning;  // Checks if timer has been started
    private PomodoroApp pomodoroApp; // Reference to PomodoroApp

    // Constructor to get instance of PomodoroApp, and initialize timer and isRunning
    public CountDownTimer(PomodoroApp pomodoroApp) {
        this.pomodoroApp = pomodoroApp;
        this.timer = null;
        this.isRunning = false;
    }

    // Start the timer with a given duration
    public void startTimer(int duration){
        if (timer == null) {
            this.seconds = duration * 60;
            // Swing Timer is initialized, it updates timer every second
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (seconds > 0){
                        seconds--;
                        pomodoroApp.notifyObservers(); // Notify GUI to update timer Display

                    }else {
                        pauseTimer(); // Stops timer when it reaches zero
                        Toolkit.getDefaultToolkit().beep(); // Play Beeping sound
                        pomodoroApp.PomodoroCompleted(); // Handle transition between states
                    }
                }
            });
        }
        // Start Timer if it is not running
        if (!isRunning){
            isRunning = true;
            timer.start();
        }

    }

    // Method to pause timer if it is running
    public void pauseTimer(){
        if (timer != null){
            timer.stop();
            this.isRunning = false;
        }
    }

    // Resets timer to duration (in minutes)
    public void resetTimer(int minutes){
        this.seconds =  minutes * 60;
        this.isRunning = false;
        if (timer != null){
            timer.stop();
        }
        pomodoroApp.notifyObservers();  // Notify observers to Update GUI
    }


    //Getter to access seconds
    public int getSeconds() {
        return seconds;
    }



}
