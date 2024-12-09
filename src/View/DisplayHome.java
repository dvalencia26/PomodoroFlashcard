package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayHome extends JFrame{
//    private JLabel title;
//    private JButton createDeckButton;
//    private JButton reviewDeckButton;
//    private JButton pomodoroButton;
    private CardLayout cardLayout;
    private JPanel container;

    private HomePanel homePanel;
    private CreateFlashcardDisplay createPanel;
    private DisplayCards displayPanel;


    public DisplayHome(){
        setTitle("Pomodoro Flashcard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        homePanel = new HomePanel(container, cardLayout);
        createPanel= new CreateFlashcardDisplay(container, cardLayout);
        displayPanel = new DisplayCards(container, cardLayout);


        container.add(homePanel,"Home");
        container.add(createPanel, "Create Deck");
        container.add(displayPanel, "Display Cards");

        add(container);

        setVisible(true);


//        title = new JLabel("Pomodoro Flashcards", JLabel.CENTER);
//        title.setFont(new Font("TimesRoman", Font.BOLD, 40));
//        title.setBounds(50, 50, 500, 50);
//        add(title);
//
//        createDeckButton = new JButton("Create Deck");
//        createDeckButton.setBounds(200, 150, 200, 50);
//        add(createDeckButton);
//
//        reviewDeckButton = new JButton("Create Deck");
//        reviewDeckButton.setBounds(200, 220, 200, 50);
//        add(reviewDeckButton);
//
//        pomodoroButton = new JButton("Create Deck");
//        pomodoroButton.setBounds(200, 290, 200, 50);
//        add(pomodoroButton);
//
//        createDeckButton.addActionListener((ActionEvent e)-> cardLayout.show(container, "Create Flashcard"));
//        reviewDeckButton.addActionListener((ActionEvent e)-> cardLayout.show (container, "Display Cards"));
//
//        container.add(createFlashcardDisplay, "CreateFlashcard");
//        container.add(displayCards, "DisplayCards");
//        add(container);

    }
//    private JLabel Title;
//    private JButton CreateDeckButton;
//    private JButton ReviewDeckButton;
//    private CardLayout cardLayout;
//    private JPanel container;
//    private CreateFlashcardDisplay createFlashcardDisplay;
//    private DisplayCards displayCards;
//
//    public DisplayHome(){
//        setTitle("Pomonoro Flashcard");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(500, 400);
//        setLocationRelativeTo(null);
//
//        cardLayout = new CardLayout();
//        container = new JPanel(cardLayout);
//
//        displayCards = new DisplayCards();
//        container.add(displayCards, "Home");
//        add(container);
//
//    }

//    public DisplayHome() {
//        //Basic settings
//        JPanel panel = new JPanel(); //Creating Panel
//
//        JFrame frame = new JFrame();
//        frame.setSize(800, 600);//setting frame size
//        frame.add(panel, BorderLayout.CENTER); //adding panel to frame
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes frame if user clicks X in corner
//        frame.setTitle("Home Page");
//
//        panel.setBackground(Color.PINK); //panel color
//        panel.setLayout(null);// look into this
//
//
//        //HOME PAGE*****************************************************************************************************
//
//        //Title
//        Title = new JLabel("POMODORO \n FLASHCARDS");
//        Title.setFont(new Font("TimesRoman", Font.BOLD, 50)); //Editing font type and size
//        Title.setForeground(Color.WHITE); // Font text color
//        Title.setBackground(Color.PINK); //Font background color
//        Title.setOpaque(true); // setting color
//        Title.setBounds(60, 50, 750, 100); //placing of title
//        panel.add(Title); //adding to panel
//
//        //Create Deck
//        CreateDeckButton = new JButton("Create Deck");
//        CreateDeckButton.setBounds(280, 150, 200, 80);
//        CreateDeckButton.setFont(new Font("TimesRoman", Font.PLAIN, 30));
//        CreateDeckButton.setForeground(Color.DARK_GRAY);
//        panel.add(CreateDeckButton);
//
//        CreateDeckButton.addActionListener(new ActionListener() { // Create Deck Button Actions
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Create Deck Button Clicked");
//                new CreateFlashcardDisplay();
//
//            }
//        });
//
//        ReviewDeckButton = new JButton("Review Deck");
//        ReviewDeckButton.setBounds(280, 250, 200, 80);
//        ReviewDeckButton.setFont(new Font("TimesRoman", Font.PLAIN, 30));
//        ReviewDeckButton.setForeground(Color.DARK_GRAY);
//        panel.add(ReviewDeckButton);
//
//        ReviewDeckButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new DisplayCards();
//                System.out.println("Review Deck Button Clicked");
//            }
//        });
//
//
//
//        panel.setVisible(true);
//
//
//    }
}
