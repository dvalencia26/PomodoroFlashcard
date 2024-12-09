package Model;

import java.util.ArrayList;

//Template Pattern
//Will show the sequence of a study session
public abstract class sessionTemplate {
    protected int currentIndex;
    protected ArrayList<FlashCard> list;


    public sessionTemplate(ArrayList<FlashCard> list){
        this.list = list;
        this.currentIndex = 0;
    }

    public void runSession(){
        initialize();
        getCurrentQuestion();
        hasNextQuestion();
        nextQuestion();
        endSession();
    }

    abstract void initialize();
    public String getCurrentQuestion(){
        if (hasNextQuestion()){
            return list.get(currentIndex).getQuestion();
        }
        return "No more questions.";
    }

    public boolean hasNextQuestion(){
        return  currentIndex < list.size();
    }

    public abstract boolean checkAnswer(String userAnswer);
    public abstract String giveFeedback(boolean isCorrect);
    public void nextQuestion(){
        if (hasNextQuestion()){
            currentIndex++;
        }
    }

    abstract void endSession();
//    public void runSession(){
//        initialize();
//        displayQuestion();
//        getUserInput();
//        getAnswer();
//        giveFeedback();
//        endSession();
//    }
//
//    abstract void initialize();
//    abstract void displayQuestion();
//    abstract void getUserInput();
//    abstract void getAnswer();
//    abstract void giveFeedback();
//    abstract void endSession();

}
