package Model;
//Template Pattern
//Will show the sequence of a study session
public abstract class sessionTemplate {
    public void runSession(){
        initialize();
        displayQuestion();
        getUserInput();
        getAnswer();
        giveFeedback();
        endSession();
    }

    abstract void initialize();
    abstract void displayQuestion();
    abstract void getUserInput();
    abstract void getAnswer();
    abstract void giveFeedback();
    abstract void endSession();

}
