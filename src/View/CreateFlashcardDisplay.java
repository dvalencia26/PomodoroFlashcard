package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFlashcardDisplay {
    private JLabel Question;
    private JTextField questionInput;
    private JLabel Answer;
    private JTextField answerInput;
    private JButton nextCard;
    private JButton saveSet;
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

        Question = new JLabel("Question:");
        Question.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        Question.setForeground(Color.WHITE); // Font text color
        Question.setBackground(Color.PINK); //Font background color
        Question.setOpaque(true); // setting color
        Question.setBounds(60, 50, 100, 20); //placing of title
        panel2.add(Question); //adding to panel

        questionInput = new JTextField(); // size of text area
        questionInput.setBackground(Color.white);
        questionInput.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        questionInput.setBounds(60, 80, 700, 150);
        panel2.add(questionInput);


        Answer = new JLabel("Answer:");
        Answer.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        Answer.setForeground(Color.WHITE); // Font text color
        Answer.setBackground(Color.PINK); //Font background color
        Answer.setOpaque(true); // setting color
        Answer.setBounds(60, 270, 100, 20); //placing of title
        panel2.add(Answer); //adding to panel

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

        //



        frame2.setVisible(true);
    }
    //add method
    //show answer
}
