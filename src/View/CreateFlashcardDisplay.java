package View;

import Model.FlashCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateFlashcardDisplay {
    private JLabel questionLabel;
    private JTextField questionInput;
    private JLabel answerLabel;
    private JTextField answerInput;
    private JLabel status;
    private JButton nextCard;
    private JButton saveSet;
    private ArrayList<FlashCard> flashCards;
    private int currentIndex;
    public CreateFlashcardDisplay(){
        //Basic settings
        JPanel panel2 = new JPanel(); //Creating Panel

        JFrame frame2 = new JFrame();
        frame2.setSize(800, 600);//setting frame size
        frame2.add(panel2, BorderLayout.CENTER); //adding panel to frame
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes frame if user clicks X in corner
        frame2.setTitle("Flashcards");

        panel2.setBackground(Color.PINK); //panel color
        panel2.setLayout(null);// look into this

        questionLabel = new JLabel("Question:");
        questionLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        questionLabel.setForeground(Color.WHITE); // Font text color
        questionLabel.setBackground(Color.PINK); //Font background color
        questionLabel.setOpaque(true); // setting color
        questionLabel.setBounds(60, 50, 100, 20); //placing of title
        panel2.add(questionLabel); //adding to panel

        questionInput = new JTextField(); // size of text area
        questionInput.setBackground(Color.white);
        questionInput.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        questionInput.setBounds(60, 80, 700, 150);
        panel2.add(questionInput);


        answerLabel = new JLabel("Answer:");
        answerLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        answerLabel.setForeground(Color.WHITE); // Font text color
        answerLabel.setBackground(Color.PINK); //Font background color
        answerLabel.setOpaque(true); // setting color
        answerLabel.setBounds(60, 270, 100, 20); //placing of title
        panel2.add(answerLabel); //adding to panel

        answerInput = new JTextField(); // size of text area
        answerInput.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        answerInput.setBounds(60, 300, 700, 150 );
        panel2.add(answerInput);

        nextCard= new JButton("Next Card");
        nextCard.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        nextCard.setBounds(60, 500, 100, 50);
        nextCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel2.add(nextCard);

        saveSet= new JButton("Save Set");
        saveSet.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        saveSet.setBounds(600, 500, 100, 50);
        nextCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel2.add(saveSet);

        status = new JLabel(" ", JLabel.CENTER);
        panel2.add(status, BorderLayout.NORTH);



        frame2.setVisible(true);
    }
    //add method
    public void addFlashcard(){
        String question = questionInput.getText();
        String answer = answerInput.getText();

        if (question.isEmpty() || answer.isEmpty()){
            status.setText("Enter question and answer.");
        }else {
            FlashCard flashcard = new FlashCard(question, answer);
            flashCards.add(flashcard);
            status.setText("Flashcard successfully added");
            questionInput.setText(" ");
            answerInput.setText(" ");
        }
    }
    //show answer
}
