package gui;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(MainWindow window) {
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton add = new JButton("Add Product");
        JButton view = new JButton("View Products");
        JButton search = new JButton("Search Product");
        JButton delete = new JButton("Delete Product");
        JButton exit = new JButton("Exit");

        add(add);
        add(view);
        add(search);
        add(delete);
        add(exit);

        add.addActionListener(e -> window.showPanel("add"));
        view.addActionListener(e -> window.showPanel("view"));
        search.addActionListener(e -> window.showPanel("search"));
        delete.addActionListener(e -> window.showPanel("delete"));
        exit.addActionListener(e -> System.exit(0));
    }
}
