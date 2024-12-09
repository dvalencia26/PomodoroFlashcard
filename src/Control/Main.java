package Control;

import View.CreateFlashcardDisplay;
import View.DisplayCards;
import View.DisplayHome;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Pomodoro Flashcard");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        new DisplayHome();

//        CardLayout cardLayout = new CardLayout();
//        JPanel container = new JPanel(cardLayout);

//        DisplayHome home = new DisplayHome(container, cardLayout);
//        CreateFlashcardDisplay createFlashcardDisplay = new CreateFlashcardDisplay(container, cardLayout);
//        DisplayCards displayCards = new DisplayCards(container, cardLayout);

//        container.add(home, "Home");
//        container.add(createFlashcardDisplay, "CreateFlashcard");
//        container.add(displayCards, "DisplayCards");

//        frame.add(container);
        frame.setVisible(true);

//        //new DisplayHome();
//        //new DisplayCards();
//        //new CreateFlashcardDisplay();
//        DisplayHome home = new DisplayHome();
//        home. setSize(600, 800);
//        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        home.setLocationRelativeTo(null);
//
//        home.setVisible(true);
    }

}
