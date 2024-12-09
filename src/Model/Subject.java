package Model;

/*
https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java

Subject contains a list of observers to notify of any change in its state.
In this case, Observers (GUI Classes) will update their Timer Display
 */
public interface Subject {
    void addObserver(Observer observer); // Adds observer to observer list
    void removeObserver(Observer observer);
    void notifyObservers(); // Notifies observers in the list
}
