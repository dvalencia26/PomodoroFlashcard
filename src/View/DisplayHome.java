package View;

import Model.FlashCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayHome {
    private JLabel Title;
    private JButton CreateDeckButton;
    private JButton ReviewDeckButton;

    public DisplayHome() {
        //Basic settings
        JPanel panel = new JPanel(); //Creating Panel

        JFrame frame = new JFrame();
        frame.setSize(800, 600);//setting frame size
        frame.add(panel, BorderLayout.CENTER); //adding panel to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes frame if user clicks X in corner
        frame.setTitle("Home Page");

        panel.setBackground(Color.PINK); //panel color
        panel.setLayout(null);// look into this


        //HOME PAGE*****************************************************************************************************

        //Title
        Title = new JLabel("POMODORO \n FLASHCARDS");
        Title.setFont(new Font("TimesRoman", Font.BOLD, 50)); //Editing font type and size
        Title.setForeground(Color.WHITE); // Font text color
        Title.setBackground(Color.PINK); //Font background color
        Title.setOpaque(true); // setting color
        Title.setBounds(60, 50, 750, 100); //placing of title
        panel.add(Title); //adding to panel

        //Create Deck
        CreateDeckButton = new JButton("Create Deck");
        CreateDeckButton.setBounds(280, 150, 200, 80);
        CreateDeckButton.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        CreateDeckButton.setForeground(Color.DARK_GRAY);
        panel.add(CreateDeckButton);

        CreateDeckButton.addActionListener(new ActionListener() { // Create Deck Button Actions
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Create Deck Button Clicked");
                new CreateFlashcardDisplay();

            }
        });

        ReviewDeckButton = new JButton("Review Deck");
        ReviewDeckButton.setBounds(280, 250, 200, 80);
        ReviewDeckButton.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        ReviewDeckButton.setForeground(Color.DARK_GRAY);
        panel.add(ReviewDeckButton);

        ReviewDeckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Review Deck Button Clicked");
            }
        });



        frame.setVisible(true);


    }
}
