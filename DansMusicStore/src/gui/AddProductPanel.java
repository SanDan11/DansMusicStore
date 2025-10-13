package gui;

import javax.swing.*;

public class AddProductPanel extends JPanel {

    public AddProductPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Add a New Product");
        title.setAlignmentX(CENTER_ALIGNMENT);

        add(title);

        add(Box.createVerticalStrut(20));


    }
}
