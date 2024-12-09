package View;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BreakPanelGUI extends JPanel implements Observer {

    private JLabel timerLabelBreak;
    private JButton startButton;
    private PomodoroApp pomodoroApp;

    public BreakPanelGUI(PomodoroApp pomodoroApp) {
        pomodoroApp.addObserver(this);
        setLayout(new BorderLayout());

        /*
        Sets Label of Break Timer
         */
        timerLabelBreak = new JLabel("Break Timer: 00:00");
        timerLabelBreak.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabelBreak.setFont(new Font("Times New Roman", Font.BOLD, 20));
        timerLabelBreak.setForeground(Color.BLACK);

        add(timerLabelBreak, BorderLayout.CENTER);// Add timerLabelBreak to panel

        /*
        Create button Panel and Start button
         */
        JPanel buttonPanel = new JPanel(new FlowLayout());
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pomodoroApp.start(); // Uses pomodoroApp to call shortBreakState start method to initialize timer
            }
        });

        buttonPanel.add(startButton); // Add start button to button Panel
        add(buttonPanel, BorderLayout.SOUTH); // Adds button panel to BreakPanelGUI
    }

    /*
    Method to update break session time display
     */
    @Override
    public void update(int currentTime) {
        int minutes = currentTime / 60;
        int seconds = currentTime % 60;
        timerLabelBreak.setText("Break Timer: " + String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
    }
}
