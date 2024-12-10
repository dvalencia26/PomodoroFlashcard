package Model;

import java.util.ArrayList;
/**
 * Concrete Class - A session type that will implement the sessionTemplate.
 * This class was not implemented in the program but the Template Pattern allows extensibility, so we can implement it.
 * This class will allow the user to input their answer to the flashcard question, check for correctness, and give feedback
 * Demonstrates using the Template pattern by providing custom implementations.
 *
 * Author: Isveydi
 */

public class textFlashcard extends sessionTemplate {

    public textFlashcard(ArrayList<String[]> list) { // gets the flashcard list
        super(list);
    }

    @Override
    void initialize() { // initializes the text answer session
        currentIndex = 0;
        System.out.println("Initiating Text-Answer Session");
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        if (!hasNextQuestion()) { // checks for correctness
            return false;
        }
        String correctAnswer = list.get(currentIndex)[1]; // gets flashcard answer
        return correctAnswer.equalsIgnoreCase(userAnswer.trim()); // compares user answer to flashcard answer
    }

    @Override
    public String giveFeedback(boolean isCorrect) { // provides feedback
        if (isCorrect) {
            return "Correct!"; // if answer is correct
        } else {
            String correctAnswer = list.get(currentIndex)[1]; //if answer is incorrect and displays correct answer
            return "Incorrect. The correct answer is: " + correctAnswer;
        }
    }

    @Override
    public void endSession() { // ends text answer study session
        System.out.println("Text-Answer Session Completed");
    }

}
