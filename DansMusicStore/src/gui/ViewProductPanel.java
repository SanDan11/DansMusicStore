package gui;

import javax.swing.*;

public class ViewProductPanel extends JPanel {

    public ViewProductPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("View Products");
        title.setAlignmentX(CENTER_ALIGNMENT);

        add(title);
        add(Box.createVerticalStrut(20));

        JLabel placeholder = new JLabel("(Product here)");
        placeholder.setAlignmentX(CENTER_ALIGNMENT);
        add(placeholder);
    }
}
