package View;

import Model.BasicFlashcardDeck;
import Model.FlashcardModel;
import Model.sessionTemplate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * A panel that displays flashcards and allows the user to show the answer and move to the next card.
 * This class directly interacts with the sessionTemplate (in this case BasicFlashcardDeck).
 *
 * Single Responsibility: This class is only responsible for displaying and navigating through
 * the current flashcard session visually.
 *
 * author: Isveydi
 */
public class DisplayCards extends JPanel{
    private JLabel questionLabel;
    private JLabel answerLabel;
    private JButton showAnswerButton;
    private JButton nextCardButton;
    private JButton homeButton;
    private sessionTemplate session;// Current session
    private JPanel container;// The parent container with CardLayout to switch screens
    private CardLayout cardLayout;
    private FlashcardModel model;


    // sets up UI and initializes session with the current model data
    public DisplayCards(JPanel container, CardLayout cardLayout, FlashcardModel model) {
        this.container = container;
        this.cardLayout = cardLayout;
        this.model = model;

        // Create a new BasicFlashcardDeck session with all the current flashcards
        session = new BasicFlashcardDeck(model.getAllFlashcards());

        setLayout(null);

        // Question label
        questionLabel = new JLabel("Question: ", JLabel.CENTER);
        questionLabel.setBounds(50, 50, 500, 50);
        add(questionLabel);

        // Answer label
        answerLabel = new JLabel("Answer: ", JLabel.CENTER);
        answerLabel.setBounds(50, 150, 500, 50);
        answerLabel.setVisible(false); // hides it
        add(answerLabel);

        // Show Answer button
        showAnswerButton = new JButton("Show Answer");
        showAnswerButton.setBounds(200, 250, 200, 50);
        showAnswerButton.addActionListener(e -> showAnswer());
        add(showAnswerButton);

        // Next Card button
        nextCardButton = new JButton("Next Card");
        nextCardButton.setBounds(200, 320, 200, 50);
        nextCardButton.addActionListener(e -> nextCard());
        add(nextCardButton);

        // Return Home button
        homeButton = new JButton("Return Home");
        homeButton.setBounds(200, 390, 200, 50);
        homeButton.addActionListener(e -> cardLayout.show(container, "Home"));
        add(homeButton);

        // Load the first flashcard
        loadFlashcard();
    }


    private void loadFlashcard() { // loads the first flashcard question
        if (!session.hasNextQuestion()) {
            // If no flashcards, show a message and disable buttons
            questionLabel.setText("No flashcards available.");
            answerLabel.setVisible(false);
            showAnswerButton.setEnabled(false);
            nextCardButton.setEnabled(false);
            session.endSession();
        } else {
            // Show the current question
            String question = session.getCurrentQuestion(); // gets question
            questionLabel.setText("Question: " + question); //displays question
            answerLabel.setVisible(false); // hides label
            showAnswerButton.setEnabled(true); // enables the show answer button
            nextCardButton.setEnabled(session.canGoNext()); // allows user to see the next card
        }
    }

    private void showAnswer() { // shows answer of the current flashcard
        String answer = session.giveFeedback(true);
        answerLabel.setText(answer);
        answerLabel.setVisible(true);
    }

    private void nextCard() { // moves to next card in the session
        session.nextQuestion();
        loadFlashcard();
    }


    public void refreshDisplay() { // resets display and session
        session = new BasicFlashcardDeck(model.getAllFlashcards());
        loadFlashcard();
    }

}
