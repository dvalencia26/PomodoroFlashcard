package View;//create 5 cards max

import Model.FlashcardModel;

import javax.swing.*;
import java.awt.*;

/**
 * A panel that allows the user to create new flashcards by entering a question and answer.
 * Single Responsibility: This class is only responsible for UI related to creating flashcards.
 *
 * Author: Isveydi
 */
public class CreateFlashcardDisplay extends JPanel{
    private JLabel questionLabel;
    private JLabel answerLabel;
    private JTextField questionInput;
    private JTextField answerInput;
    private JLabel status;
    private FlashcardModel model;


    public CreateFlashcardDisplay(JPanel container, CardLayout cardLayout, FlashcardModel model) {
        this.model = model; // sets up UI to create the cards, container, and the model to store the cards

        setLayout(new BorderLayout());

        //Labels and Text Fields
        JPanel inputPanel = new JPanel(null);
        inputPanel.setPreferredSize(new Dimension(600, 200));

        questionLabel = new JLabel("Question: ");
        questionLabel.setBounds(50, 50, 100, 30);
        inputPanel.add(questionLabel);

        questionInput = new JTextField(); // field for question input
        questionInput.setBounds(150, 50, 300, 30);
        inputPanel.add(questionInput);

        answerLabel = new JLabel("Answer: ");
        answerLabel.setBounds(50, 100, 100, 30);
        inputPanel.add(answerLabel);

        answerInput = new JTextField(); // field for answer input
        answerInput.setBounds(150, 100, 300, 30);
        inputPanel.add(answerInput);

        add(inputPanel, BorderLayout.CENTER);

        //Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        //Buttons that will be added to the Button Panel
        JButton saveButton  = new JButton("Save Card");
        JButton homeButton  = new JButton("Return Home");

        // Save card action- adds the card to the model
        saveButton.addActionListener(e -> saveFlashcard());
        // Return home action
        homeButton.addActionListener(e -> cardLayout.show(container, "Home"));

        buttonPanel.add(saveButton); //adding buttons to button panel
        buttonPanel.add(homeButton);

        // Status label to show messages to user
        status = new JLabel(" ", SwingConstants.CENTER);
        add(status, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    private void saveFlashcard() { // saves flashcard to the model
        //getting text from text fields
        String question = questionInput.getText().trim();
        String answer = answerInput.getText().trim();

        if (question.isEmpty() || answer.isEmpty()) { // checks if field is empty
            status.setText("Enter question and answer"); //lets you know if its empty
        } else {
            model.addFlashcard(question, answer); //adding question and answer to model
            status.setText("Flashcard added!"); // lets you know when flashcard is added
            questionInput.setText("");
            answerInput.setText("");
        }
    }
}

