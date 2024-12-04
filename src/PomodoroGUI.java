/*
Video Reference: https://www.youtube.com/watch?v=dsG58DA6Q0I&list=LL&index=1&t=1725s
 */
//ii
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PomodoroGUI {
    private PomodoroApp pomodoroApp;
    private  int minutes = 25;
    private  int seconds = minutes * 60;

    private Timer timer;
    private JLabel timerLabel;
    private JButton startButton, pauseButton, resetButton;


    public PomodoroGUI(PomodoroApp pomodoroApp) {
        this.pomodoroApp = pomodoroApp;
        GUI();
    }

    private void  GUI() {

        JFrame frame = new JFrame("Pomodoro Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.getContentPane().setBackground(Color.white);
        frame.setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        timerLabel = new JLabel("Time Remaining: 00:00");
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        timerLabel.setForeground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.setBackground(Color.white);


        startButton = new JButton("Start");
        startButton.setBackground(new Color(30, 144, 255));
        startButton.setFocusPainted(false);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pomodoroApp.start();
            }
        });

        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pomodoroApp.pause();
            }
        });
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pomodoroApp.reset();
            }
        });

        inputPanel.add(startButton);
        inputPanel.add(pauseButton);
        inputPanel.add(resetButton);

        contentPanel.add(timerLabel, BorderLayout.CENTER);
        contentPanel.add(inputPanel, BorderLayout.SOUTH);

        frame.add(contentPanel);
        frame.setVisible(true);

       /* int totalSeconds = minutes * 60 + seconds + 1;
        timer = new Timer(1000, new ActionListener() {
            int count = totalSeconds;
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;

                if (count >= 0) {
                    int remainingMinutes = count / 60;
                    int remainingSeconds = count % 60;
                    timerLabel.setText(String.format("Time Remaining: %02d:%02d", remainingMinutes, remainingSeconds));
                } else {
                    timer.stop();
                    timerLabel.setText("Time's Up!");
                }
            }
        });
        timer.start();

    }
    private void startTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        */
    }
    public static void main(String[] args) {
        PomodoroApp pomodoroApp1 = new PomodoroApp( 25,15);
        new PomodoroGUI(pomodoroApp1);

    }
}
