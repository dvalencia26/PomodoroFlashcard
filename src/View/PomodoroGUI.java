package View;/*
Video Reference: https://www.youtube.com/watch?v=dsG58DA6Q0I&list=LL&index=1&t=1725s
 */
import Model.Observer;
import Model.PomodoroApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PomodoroGUI is an Observer that displays the current timer state to the user.
 * It shows the remaining time and provides buttons to start, pause, and reset the timer.
 * It observes changes from PomodoroApp (the Subject).
 *
 * author: Domenica
 */

public class PomodoroGUI extends JPanel implements Observer {
    private JLabel timerLabel;
    private JButton startButton, pauseButton, resetButton;


    public PomodoroGUI(PomodoroApp pomodoroApp) {
        pomodoroApp.addObserver(this); // Adds Pomodoro GUI to observers list
        setLayout(new BorderLayout());

        /*
        Sets Label of Pomodoro Timer
         */
        timerLabel = new JLabel("Pomodoro Timer: 00:00", JLabel.CENTER);
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        timerLabel.setForeground(Color.BLACK);
        add(timerLabel, BorderLayout.CENTER); // Add timer label to panel

        /*
        Create Button Panel for Start, Pause and Reset Buttons
         */
        JPanel buttonPanel = new JPanel(new FlowLayout());
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pomodoroApp.start(); // Uses pomodoroApp to call start method inside  WorkState to initialize timer
            }
        });
        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pomodoroApp.pause(); // Uses pomodoroApp to call pause method inside WorkState to pause timer
            }
        });
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pomodoroApp.reset(); // Uses pomodoroApp to call reset method inside WorkState to reset timer
            }
        });

        // Add buttons to Button Panel
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resetButton);

        // Adds button panel to PomodoroGUI panel
        add(buttonPanel, BorderLayout.SOUTH);

    }

    /*
    Method is called by PomodoroApp (subject) when time changes to display current time in the GUI
     */
    @Override
    public void update(int currentTime) {
        int minutes = currentTime / 60;
        int seconds = currentTime % 60;
        //Updates timerLabel with current time
        timerLabel.setText("Pomodoro Timer: " + String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
    }

}
