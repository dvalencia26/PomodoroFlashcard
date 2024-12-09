package View;

import Model.*;
import javax.swing.*;
import java.awt.*;

/*
https://www.youtube.com/watch?v=ocb3x0TeoUw
CardLayoutDemo is the JFrame that switches between the different GUIs (work, break, longBreak)
It implements the Observer pattern, and uses an instance of PomodoroApp to display the correct GUI panel
based on the session current state.
 */

public class CardLayoutDemo extends JFrame implements Observer {
    private CardLayout cardLayout;
    private JPanel container;
    private PomodoroApp pomodoroApp;

    private BreakPanelGUI breakPanelGUI;
    private PomodoroGUI pomodoroGUI;
    private LongBreakPanelGUI longBreakPanelGUI;

    public CardLayoutDemo(PomodoroApp pomodoroApp) {
        this.pomodoroApp = pomodoroApp;
        this.pomodoroApp.addObserver(this);

        // Set Program Title
        setTitle("Pomodoro Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout(); // Initialize CardLayout
        container = new JPanel(cardLayout); // Adds carLayout inside container Panel

        // Initialize the different GUI Panels
        breakPanelGUI = new BreakPanelGUI(pomodoroApp);
        pomodoroGUI = new PomodoroGUI(pomodoroApp);
        longBreakPanelGUI = new LongBreakPanelGUI(pomodoroApp);

        // Add panels to the container with identifying strings
        container.add(pomodoroGUI, "work");
        container.add(breakPanelGUI, "break");
        container.add(longBreakPanelGUI, "longBreak");
        add(container);

        // Change background color of GUI Panels
        pomodoroGUI.setBackground(Color.CYAN);
        breakPanelGUI.setBackground(Color.PINK);
        longBreakPanelGUI.setBackground(Color.PINK);


        update(pomodoroApp.getTimer().getSeconds()); //Initial Update
        setVisible(true);

    }

    /*
    Method checks current state and switches the cardLayout accordingly
     */
    @Override
    public void update(int currentTime) {
        if (pomodoroApp.getCurrentState() instanceof WorkState ){
            cardLayout.show(container, "work");
        }else  if (pomodoroApp.getCurrentState() instanceof ShortBreakState){
            cardLayout.show(container, "break");
        } else if (pomodoroApp.getCurrentState() instanceof LongBreakState){
            cardLayout.show(container, "longBreak");
        }
    }
}
