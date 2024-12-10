package Model;

import java.util.ArrayList;
/**
 *  Abstract Class - Implements the Template Method
 *  Defines the skeleton of a flashcard study "session" and allows the program to operate in a specific order.
 *  Sublcasses can provide their own implementations to initiate, check answers, give feedback, and end the session.
 *
 * This class respects the Open/Closed principle: new session types can be created
 * by extending this class without modifying it.
 *
 * Author: Isveydi
 */

public abstract class sessionTemplate {
    protected ArrayList<String[]> list;  // Stores questions and answers as string arrays
    protected int currentIndex;  // Tracks the current flashcard being shown

    public sessionTemplate(ArrayList<String[]> list) { // takes a list of questions and answers
        this.list = list;
        this.currentIndex = 0;
        initialize(); // Template pattern step: initialize session
    }

    abstract void initialize(); // method that subclasses can use to set up before initiating the session

    public String getCurrentQuestion() {
        if (hasNextQuestion()) {
            return list.get(currentIndex)[0]; // returns current question
        }
        return "No more questions."; // if there are no more questions
    }

    public boolean hasNextQuestion() { // checks if there are more questions to the list
        return currentIndex < list.size();
    }

    public boolean canGoNext() { // checks for subsequent card
        return currentIndex + 1 < list.size();
    }

    public abstract boolean checkAnswer(String userAnswer); // method implemented by subclasses checks user answer

    public abstract String giveFeedback(boolean isCorrect); //method implemented by subclasses provides feedback to user

    public void nextQuestion() { // changes to next question
        if (hasNextQuestion()) {
            currentIndex++;
        }
    }

    public abstract void endSession(); // allows subclasses to set up before ending the session
}
