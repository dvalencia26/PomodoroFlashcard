package View;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LongBreakPanelGUI is an Observer panel for the long break session.
 * It displays the remaining long break time and a button to start the long break.
 *
 * author: Domenica
 */

public class LongBreakPanelGUI extends JPanel implements Observer{
    private JLabel timerLabelLB;
    private JButton startButtonLB;

    public LongBreakPanelGUI(PomodoroApp pomodoroApp){
        pomodoroApp.addObserver(this);
        setLayout(new BorderLayout());

        //Sets Label of Break Timer
        timerLabelLB = new JLabel("Long Break Timer: 00:00");
        timerLabelLB.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabelLB.setFont(new Font("Times New Roman", Font.BOLD, 20));
        timerLabelLB.setForeground(Color.BLACK);
        add(timerLabelLB, BorderLayout.CENTER);


        //Create button Panel and Start button
        JPanel buttonPanel = new JPanel();
        startButtonLB = new JButton("Start");
        startButtonLB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pomodoroApp.start();
            }
        });

        buttonPanel.add(startButtonLB); // Add start button to button Panel
        add(buttonPanel, BorderLayout.SOUTH); // Add ButtonPanel to LongBreakPanelGUI
    }

    /*
    Method to update timer display during Long Break Session
     */
    @Override
    public void update(int currentTime) {
        int minutes = currentTime / 60;
        int seconds = currentTime % 60;
        timerLabelLB.setText("Long Break Timer: " + String.format("%02d", minutes) + ":" + String.format("%02d", seconds));

    }
}
