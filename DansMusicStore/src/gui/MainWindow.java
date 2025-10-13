package gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainWindow() {
        setTitle("Dan's Music Store Inventory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new MenuPanel(this), "menu");
        mainPanel.add(new AddProductPanel(this), "add");
        mainPanel.add(new ViewProductPanel(this), "view");
        mainPanel.add(new SearchProductPanel(), "search");
        mainPanel.add(new DeleteProductPanel(), "delete");

        add(mainPanel);
        setVisible(true);
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }
}
