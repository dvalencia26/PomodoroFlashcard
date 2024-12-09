package Model;

/*
https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Javas-JOptionPane-showOptionDialog-by-Example
 */

import javax.swing.*;
import java.awt.*;

// Prompts the user to select between starting a new session or start a break
public class BreakDialog {
    public static boolean askUserForBreak(Component parent){
        String[] options = {"Start Break", "Start New Session"};

        int choice = JOptionPane.showOptionDialog(parent, "Timer is up! Start another session or Take a break.", "Options",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return choice == JOptionPane.YES_OPTION;
    }
}
