package Model;

import java.util.ArrayList;

public class textFlashcard extends sessionTemplate{

    public textFlashcard(ArrayList<FlashCard> list) {
        super(list);
    }

    @Override
    void initialize() {
        currentIndex = 0;
        System.out.println("Initiating Flashcard Text-Answer Session");
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        if (!hasNextQuestion()){
            return false;
        }
        String correctAns = list.get(currentIndex).getAnswer();
        return correctAns.equalsIgnoreCase(userAnswer.trim());
    }


    @Override
    public String giveFeedback(boolean isCorrect) {
        if (isCorrect){
            return "Correct!";
        }else {
            String correctAnswer = list.get(currentIndex).getAnswer();
            return "Incorrect. The correct answer is :" + correctAnswer;
        }
    }

    @Override
    void endSession() {
        System.out.println("Flashcard Text-Answer Session Completed");

    }
}
