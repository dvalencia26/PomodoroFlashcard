package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayCards extends JPanel{
    private JLabel questionLabel;
    private JLabel answerLabel;
    private JButton showAnswerButton;
    private JButton nextCardButton;
    private ArrayList<String[]> list;
    private int currentIndex;

    public DisplayCards(JPanel container, CardLayout cardLayout){
        setLayout(null);

        list = new ArrayList<>();
        currentIndex = 0;

        questionLabel = new JLabel("Question: ", JLabel.CENTER);
        questionLabel.setBounds(50, 50, 500, 50);
        add(questionLabel);

        answerLabel = new JLabel("Answer: ", JLabel.CENTER);
        answerLabel.setBounds(50, 150, 500, 50);
        answerLabel.setVisible(false);
        add(answerLabel);

        showAnswerButton = new JButton("Show Answer");
        showAnswerButton.setBounds(200, 250, 200, 50);
        add(showAnswerButton);
        showAnswerButton.addActionListener( e-> answerLabel.setVisible(true));

        nextCardButton = new JButton("Next Card");
        nextCardButton.setBounds(200, 320, 200, 50);
        add(nextCardButton);
        nextCardButton.addActionListener(e-> showNextCard());

        JButton homeButton = new JButton("Return Home");
        homeButton.setBounds(200, 390, 200, 50);
        add(homeButton);
        homeButton.addActionListener(e -> cardLayout.show(container, "Home"));

        loadFlashcards();
    }
    private void loadFlashcards(){
        CreateFlashcardDisplay flashcardCreator = new CreateFlashcardDisplay(null, null);
        list =  flashcardCreator.getList();
        currentIndex = 0;

        if (!list.isEmpty()){
            questionLabel.setText("Question: " + list.get(currentIndex)[0]);
            answerLabel.setText("Answer: "+ list.get(currentIndex)[1]);
        }else {
            questionLabel.setText("No flashcards available.");
            answerLabel.setVisible(false);
        }
    }

    public void showNextCard(){
        if (!list.isEmpty()){
            questionLabel.setText("No flashcards available.");
            answerLabel.setVisible(false);

        } else{
            currentIndex = (currentIndex + 1)% list.size();
            questionLabel.setText("Question: "+ list.get(currentIndex)[0]);
            answerLabel.setText("Question: "+ list.get(currentIndex)[1]);
            answerLabel.setVisible(false);

        }
    }

//    //private JTextArea questionDisplay;
////    private JTextField qDisplay;
////    private JButton NextCard;
////    private String flashQuestion;
////    private ArrayList<String> flashcardDeck;
////    private int currentIndex = 0; // current question index
////    private String currentCard;
//    private JLabel questionD;
//    private JLabel answerD;
//    private Button nextButton;
//
//    public DisplayCards(){
//        setLayout(new BorderLayout());
//        questionD = new JLabel("Question: ");
//        answerD = new JLabel("Answer;");
//        nextButton = new Button("Next Card");
//
//        add(questionD, BorderLayout.NORTH);
//        add(answerD, BorderLayout.CENTER);
//        add(nextButton, BorderLayout.SOUTH);
//
//    }
        //Basic settings
//        JPanel panel3 = new JPanel(); //Creating Panel
//
//        JFrame frame = new JFrame();
//        frame.setSize(800, 600);//setting frame size
//        frame.add(panel3, BorderLayout.CENTER); //adding panel to frame
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes frame if user clicks X in corner
//        frame.setTitle("Flashcards");
//
//        panel3.setBackground(Color.PINK); //panel color
//        panel3.setLayout(null);// look into this
//
////        questionDisplay = new JTextArea();
////        questionDisplay.setBounds(60, 50, 300, 50);
////        questionDisplay.setBackground(Color.white);
////        questionDisplay.setFont(Font.getFont("Times Roman"));
////        questionDisplay.setLineWrap(true);
////        questionDisplay.setEditable(false);
////        panel3.add(questionDisplay);
//
//
//        qDisplay = new JTextField();
//        qDisplay.setBounds(60, 50, 300, 50);
//        qDisplay.setBackground(Color.white);
//        qDisplay.setFont(Font.getFont("Times Roman"));
//        qDisplay.setEditable(false);
//        panel3.add(qDisplay);
//
//        getFlashcards();
//
//        if (flashcardDeck.isEmpty()) {
//            qDisplay.setText("No cards available.");
//            NextCard.setEnabled(false);
//        } else {
//            currentIndex = 0;
//            qDisplay.setText(flashcardDeck.get(currentIndex));
//        }
//
//        NextCard = new JButton();
//        NextCard= new JButton("Next");
//        NextCard.setFont(new Font("TimesRoman", Font.PLAIN, 20));
//        NextCard.setBounds(600, 500, 100, 50);
//        NextCard.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!flashcardDeck.isEmpty()){ // if deck is not empty then..
//                    showNextCard();
//                }else {
//                    qDisplay.setText("That was the last card"); // once all flashcards are completed
//                    NextCard.setEnabled(false); // doesnt allow you to click the Next Card Button
//                }
//
//            }
//        });
//        panel3.add(NextCard);
//
//
//        panel3.setVisible(true);
//
//    }
//
//    public void getFlashcards(){
//        CreateFlashcardDisplay  createFlashcardDisplay = new CreateFlashcardDisplay();
//        flashcardDeck = createFlashcardDisplay.getList();
//    }
//
//    public void showNextCard(){
//
//        for (int i = 0; i < flashcardDeck.size(); i++ ){
//            currentCard = flashcardDeck.get(currentIndex);
//            currentIndex ++;
//            qDisplay.setText(currentCard);
//        }
//
////        currentCard = flashcardDeck.get(currentIndex);
////        currentIndex ++;
////        qDisplay.setText();
////        for (int i = 0; i < flashcardDeck.size(); i++ ){
////            if (i == (currentIndex + 1 ) % flashcardDeck.size()){
////                currentIndex = i;
////                qDisplay.setText(flashcardDeck.get(0));
////                return;
////            }
////        }
//    }


}
