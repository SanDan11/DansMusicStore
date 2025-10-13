package gui;

import javax.swing.*;

public class DeleteProductPanel extends JPanel {

    public DeleteProductPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Delete Product");
        title.setAlignmentX(CENTER_ALIGNMENT);

        add(title);
        add(Box.createVerticalStrut(20));

        JLabel placeholder = new JLabel("(Delete here");
        placeholder.setAlignmentX(CENTER_ALIGNMENT);
        add(placeholder);
    }
}
