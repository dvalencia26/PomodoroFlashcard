package View;

import Model.PomodoroApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 * a panel that serves as a home page to allow the user to Create a deck, review a created deck, or start the pomodoro timer.
 *
 * Single Responsibility: This class is only responsible for creating buttons to allow the user to access different
 * parts of the program.
 *
 * Author: Isveydi
 * */


public class HomePanel extends JPanel{
    private JLabel title;
    private JButton createDeckButton;
    private JButton reviewDeckButton;
    private JButton pomodoroButton;

    private DisplayCards displayPanel;


    public HomePanel(JPanel cardPanel, CardLayout cardLayout) {
        setLayout(new BorderLayout());

        // Panel Title
        title = new JLabel("Pomodoro Flashcards", JLabel.CENTER);
        title.setFont(new Font("TimesRoman", Font.BOLD, 40));
        add(title, BorderLayout.NORTH);

        // Outer panel to center components
        JPanel outerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 50));

        // Inner panel to stack buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 20));

        // Create and size buttons
        createDeckButton = new JButton("Create Deck");
        reviewDeckButton = new JButton("Review Deck");
        pomodoroButton = new JButton("Pomodoro Timer");

        Dimension buttonSize = new Dimension(150, 40);
        createDeckButton.setPreferredSize(buttonSize);
        reviewDeckButton.setPreferredSize(buttonSize);
        pomodoroButton.setPreferredSize(buttonSize);

        // Add buttons to the inner panel
        buttonPanel.add(createDeckButton);
        buttonPanel.add(reviewDeckButton);
        buttonPanel.add(pomodoroButton);

        // Add the inner panel to the outer panel
        outerPanel.add(buttonPanel);

        // Add the outer panel to the center of the BorderLayout
        add(outerPanel, BorderLayout.CENTER);

        // Action listeners
        createDeckButton.addActionListener((ActionEvent e) -> cardLayout.show(cardPanel, "Create Deck"));
        reviewDeckButton.addActionListener((ActionEvent e) -> {
            cardLayout.show(cardPanel, "Display Cards");
            if (displayPanel != null) {
                displayPanel.refreshDisplay();
            }
        });
        pomodoroButton.addActionListener((ActionEvent e)-> {
            PomodoroApp pomodoroApp = new PomodoroApp(25,5,15);
            CardLayoutDemo pomodoroDemo = new CardLayoutDemo(pomodoroApp);
            pomodoroDemo.setVisible(true);
        });

    }


    // sets the refetrence to the DisplayCards panel so we can refresh it when reviewing the deck
    public void setDisplayPanel(DisplayCards displayPanel) {
        this.displayPanel = displayPanel;
    }
}
