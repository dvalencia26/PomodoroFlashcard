package Model;

/**
 * Class represents a flashcard with a question and answer. It is currently not used, but it might be useful for
 * subclasses that will be extending the sessionTemplate.
 */
public class FlashCard {
    private String question;
    private String answer;

    public FlashCard(String question, String answer){ // initiating parameters
        this.question = question;
        this.answer = answer;
    }

    //getters
    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }
}
