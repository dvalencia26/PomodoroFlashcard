package Model;

import View.DisplayCards;

import java.util.ArrayList;

public class BasicFlashcardDeck extends sessionTemplate {
    public BasicFlashcardDeck(ArrayList<FlashCard> list) {
        super(list);
    }

    @Override
    void initialize() {
        currentIndex = 0;
        System.out.println("Initiating Basic Flashcard Session...");

    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        //no need
        return true;
    }

    @Override
    public String giveFeedback(boolean isCorrect) {
        if (isCorrect){
            return "Answer: " + list.get(currentIndex).getAnswer();
        } else{
            return "Incorrect;";
        }
    }

    @Override
    void endSession() {
        System.out.println("Basic Session Completed");
    }
}
