package View;

//create 5 cards max

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
// Test ProjectMain
public class CreateFlashcardDisplay extends Panel{
    private JLabel questionLabel;
    private JLabel answerLabel;
    private JTextField questionInput;
    private JTextField answerInput;
    private JLabel status;
    private ArrayList<String[]> list;
    public CreateFlashcardDisplay(JPanel container, CardLayout cardLayout){
        list = new ArrayList<>(); // initiates list
        setLayout(null);

        questionLabel = new JLabel("Question: ");
        questionLabel.setBounds(50, 50, 100, 30);
        add(questionLabel);


        questionInput = new JTextField();
        questionInput.setBounds(150, 50, 300, 30);
        add(questionInput);

        answerLabel = new JLabel("Answer: ");
        answerLabel.setBounds(50, 100, 100, 30);
        add(answerLabel);

        answerInput = new JTextField();
        answerInput.setBounds(150, 100, 300, 30);
        add(answerInput);


        JButton saveButton  = new JButton("Save Card");
        saveButton.setBounds(150, 150, 120, 30);
        add(saveButton);
        JButton homeButton  = new JButton("Return Home");

        saveButton.addActionListener(e -> saveFlashcard());
        homeButton.addActionListener(e -> cardLayout.show(container, "Home"));

        status = new JLabel(" ", SwingConstants.CENTER); // unsure about this
        add(status, BorderLayout.NORTH);
    }

    private void saveFlashcard(){
        String question = questionInput.getText().trim();
        String answer = answerInput.getText().trim();

        if (question.isEmpty() || answer.isEmpty()){
            list.add(new String[]{question, answer}); //String arrays in list
            status.setText("Flashcard added!");
            questionInput.setText(" ");
            answerInput.setText(" ");
        } else {
            status.setText("Enter question and answer");
        }
    }
    public ArrayList<String[]> getList(){
        return list;
    }
//    private JLabel questionLabel;
//    private JTextField questionInput;
//    private JLabel answerLabel;
//    private JTextField answerInput;
//    private JLabel status;
//    private JButton saveCard;
//    private JButton home;
//    private JLabel questionD;
//    private JLabel answerD;
//    private Button nextButton;
//
//
//    private ArrayList<String> list = new ArrayList<>();
//    public CreateFlashcardDisplay(){
//        setLayout(new BorderLayout());
//        questionD = new JLabel("Question: ");
//        answerD = new JLabel("Answer;");
//        nextButton = new Button("Next Card");
//
//        add(questionD, BorderLayout.NORTH);
//        add(answerD, BorderLayout.CENTER);
//        add(nextButton, BorderLayout.SOUTH);


        //Basic settings
//        JPanel panel2 = new JPanel(); //Creating Panel
//
//        JFrame frame2 = new JFrame();
//        frame2.setSize(800, 600);//setting frame size
//        frame2.add(panel2, BorderLayout.CENTER); //adding panel to frame
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes frame if user clicks X in corner
//        frame2.setTitle("Create Flashcards");
//
//        panel2.setBackground(Color.PINK); //panel color
//        panel2.setLayout(null);// look into this
//
//        questionLabel = new JLabel("Question:");
//        questionLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));
//        questionLabel.setForeground(Color.WHITE); // Font text color
//        questionLabel.setBackground(Color.PINK); //Font background color
//        questionLabel.setOpaque(true); // setting color
//        questionLabel.setBounds(60, 50, 100, 20); //placing of title
//        panel2.add(questionLabel); //adding to panel
//
//        questionInput = new JTextField(); // size of text area
//        questionInput.setBackground(Color.white);
//        questionInput.setFont(new Font("TimesRoman", Font.PLAIN, 12));
//        questionInput.setBounds(60, 80, 700, 150);
//        panel2.add(questionInput);
//
//
//        answerLabel = new JLabel("Answer:");
//        answerLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));
//        answerLabel.setForeground(Color.WHITE); // Font text color
//        answerLabel.setBackground(Color.PINK); //Font background color
//        answerLabel.setOpaque(true); // setting color
//        answerLabel.setBounds(60, 270, 100, 20); //placing of title
//        panel2.add(answerLabel); //adding to panel
//
//        answerInput = new JTextField(); // size of text area
//        answerInput.setFont(new Font("TimesRoman", Font.PLAIN, 12));
//        answerInput.setBounds(60, 300, 700, 150 );
//        panel2.add(answerInput);
//
//        saveCard = new JButton("Save Card");
//        saveCard.setFont(new Font("TimesRoman", Font.PLAIN, 20));
//        saveCard.setBounds(600, 500, 100, 50);
//
//        saveCard.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addFlashcard(); // adds flashcard to the list
//            }
//        });
//        panel2.add(saveCard);
//
//        home = new JButton("Return Home"); // takes you back to home screen
//        home.setFont(new Font("TimesRoman", Font.PLAIN, 20));
//        home.setBounds(60, 500, 100, 50);
//        home.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new DisplayHome(); // returns to home screen
//            }
//        });
//        panel2.add(home);
//
//        status = new JLabel(" ", JLabel.CENTER);
//        panel2.add(status, BorderLayout.NORTH);
//
//
//
//        panel2.setVisible(true);
//    }
//
//    public ArrayList<String> getList() {
//        return list;
//    }
//
//    //add method
//    public void addFlashcard(){
//        String question = questionInput.getText();
//        String answer = answerInput.getText();
//
//        if (question.isEmpty() || answer.isEmpty()){
//            status.setText("Enter question and answer.");
//        }else {
//            //FlashCard flash =new FlashCard(question,answer);
//            System.out.println(question);
//            System.out.println(answer);
//            list.add(question);
//            list.add(answer);
//            System.out.println(list);
//
//            status.setText("Flashcard successfully added");
//            questionInput.setText(" ");
//            answerInput.setText(" ");
//
//        }
//        System.out.println(list);
//
//
//    }

    //if else switch cases
}

