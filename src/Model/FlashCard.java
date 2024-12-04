package Model;

import java.util.ArrayList;
// Test GIt
public class FlashCard { //getting question and answer from user input
    String question;
    String answer;

    public FlashCard(String question, String answer){
        this.question= question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

}
