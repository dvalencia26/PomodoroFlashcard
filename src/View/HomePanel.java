package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HomePanel extends JPanel{
   private JLabel title;
    private JButton createDeckButton;
    private JButton reviewDeckButton;
    private JButton pomodoroButton;
    public HomePanel(JPanel cardPanel, CardLayout cardLayout){
        setLayout(new GridLayout(3, 1, 10, 10));

        title = new JLabel("Pomodoro Flashcards", JLabel.CENTER);
        title.setFont(new Font("TimesRoman", Font.BOLD, 40));
        title.setBounds(50, 50, 500, 50);
        add(title);

        createDeckButton = new JButton("Create Deck");
        createDeckButton.setBounds(200, 150, 200, 50);
        add(createDeckButton);

        reviewDeckButton = new JButton("Review Deck");
        reviewDeckButton.setBounds(200, 220, 200, 50);
        add(reviewDeckButton);

        pomodoroButton = new JButton("Pomodoro Timer");
        pomodoroButton.setBounds(200, 290, 200, 50);
        add(pomodoroButton);

        createDeckButton.addActionListener((ActionEvent e)-> cardLayout.show(cardPanel, "Create Deck"));
        reviewDeckButton.addActionListener((ActionEvent e)-> cardLayout.show (cardPanel, "Display Cards"));
        //pomodoroButton.addActionListener((ActionEvent e)-> cardLayout.show (cardPanel, "Pomodoro Timer"));
//        container.add(createFlashcardDisplay, "CreateFlashcard");
//        container.add(displayCards, "DisplayCards");

    }
}
