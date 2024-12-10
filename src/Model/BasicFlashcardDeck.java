package Model;

import java.util.ArrayList;

/** Concrete Class - Implements session Template
 * This class is a basic flashcard deck study session. However, it cannot check for correctness.
 * This follows the Template pattern and can be extended or replaced with other implementations.
 *
 * Author: Isveydi
 */
public class BasicFlashcardDeck extends sessionTemplate {

    public BasicFlashcardDeck(ArrayList<String[]> list) { // gets flashcard list
        super(list);
    }

    @Override
    void initialize() {
        currentIndex = 0;
        System.out.println("Initiating Basic Flashcard Session...");
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        // Basic session cannot check for correctness, so it will always return true.
        return true;
    }

    @Override
    public String giveFeedback(boolean isCorrect) {
        // Returns the answer of the current card, or a message if no more cards.
        if (hasNextQuestion()) {
            return "Answer: " + list.get(currentIndex)[1];
        }
        return "No more cards.";
    }

    @Override
    public void endSession() { // ends Basic flashcard session
        System.out.println("Basic Session Completed");
    }
}
