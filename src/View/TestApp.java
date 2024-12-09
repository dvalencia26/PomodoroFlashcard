package View;

import Model.PomodoroApp;

public class TestApp {
    public static void main(String[] args) {

        // Initialize PomodoroApp given duration timer for each session
        PomodoroApp app = new PomodoroApp(1, 1, 15);
        // Initialize new frame using CardLayoutDemo class, pass reference of PomodoroApp
        CardLayoutDemo cardLayoutDemoFrame = new CardLayoutDemo(app);
        //Make Frame visible
        cardLayoutDemoFrame.setVisible(true);
    }
}
