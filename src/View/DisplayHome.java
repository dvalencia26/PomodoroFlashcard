package View;

import Model.FlashcardModel;

import javax.swing.*;
import java.awt.*;
/**
 * The main JFrame that holds all panels (Home, Create Deck, Display Cards).
 * Uses a CardLayout for switching between these screens.
 *
 * Single Responsibility: This class is only responsible for assembling the UI
 * and managing the main application window.
 *
 * Author: Isveydi
 * */

public class DisplayHome extends JFrame{
    private CardLayout cardLayout;
    private JPanel container;

    private HomePanel homePanel;
    private CreateFlashcardDisplay createPanel;
    private DisplayCards displayPanel;
    private FlashcardModel model;

    public DisplayHome() {

        //JFrame title
        setTitle("Pomodoro Flashcard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        model = new FlashcardModel();

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        homePanel = new HomePanel(container, cardLayout);
        createPanel = new CreateFlashcardDisplay(container, cardLayout, model);
        displayPanel = new DisplayCards(container, cardLayout, model);


        homePanel.setDisplayPanel(displayPanel);

        // Add all panels to the container
        container.add(homePanel, "Home");
        container.add(createPanel, "Create Deck");
        container.add(displayPanel, "Display Cards");

        add(container);
        setVisible(true);
    }
}
