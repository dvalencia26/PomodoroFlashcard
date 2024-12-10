package Model;

import java.util.ArrayList;

/**
 * Manages the pairs of question and answers in the arraylist.
 *
 * Single Responsibility: This class is only responsible for storing and retrieving flashcards.
 * Open/Closed: If we need new ways of storing or manipulating flashcards, we can extend or modify
 * without changing existing external code.
 *
 * author: Isveydi
 */
public class FlashcardModel {
    private ArrayList<String[]> flashcards;

    public FlashcardModel() { //Initiating flashcard list
        this.flashcards = new ArrayList<>();
    }

    public void addFlashcard(String question, String answer) { //adds flashcard to the model
        flashcards.add(new String[]{question, answer});
    }

    public boolean isEmpty() { // checks if the model is empty
        return flashcards.isEmpty();
    }


    public String[] getFlashcard(int index) { // gets flashcard using their index
        if (index >= 0 && index < flashcards.size()) {
            return flashcards.get(index);
        }
        return null;
    }

    public int size() { // returns the total number of flashcards
        return flashcards.size();
    }


    public ArrayList<String[]> getAllFlashcards() { //gets all the flashcards
        return flashcards;
    }
}

