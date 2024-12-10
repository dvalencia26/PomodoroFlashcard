package Model;

/*
Sources:
Observer Design Pattern:
https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java
*/

/**
* The GUI classes that need to update their time display will implement the Observer class
 *
 * author: Domenica
 */

public interface Observer {
    // Call by Subject (Pomodoro App) when the session state changes.
    void update(int currentTime);
}
