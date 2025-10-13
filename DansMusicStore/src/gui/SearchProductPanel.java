package gui;

import javax.swing.*;

public class SearchProductPanel extends JPanel{

    public SearchProductPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Search Products");
        title.setAlignmentX(CENTER_ALIGNMENT);

        add(title);
        add(Box.createVerticalStrut(20));

        JLabel placeholder = new JLabel("(Search bar and results here");
        placeholder.setAlignmentX(CENTER_ALIGNMENT);
        add(placeholder);
    }
}
