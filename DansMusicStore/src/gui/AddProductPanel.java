package gui;

import javax.swing.*;
import java.awt.*;
import managers.AddProduct;

public class AddProductPanel extends JPanel {

    private JTextField nameField, brandField, priceField, quantityField;
    private JComboBox<String> categoryBox;
    private JButton saveButton, backButton;
    private MainWindow window;

    public AddProductPanel(MainWindow window) {

        this.window = window;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("Add new product");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        formPanel.add(new JLabel("Name: "));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Brand: "));
        brandField = new JTextField();
        formPanel.add(brandField);

        formPanel.add(new JLabel("price: "));
        priceField = new JTextField();
        formPanel.add(priceField);

        formPanel.add(new JLabel("Quantity: "));
        quantityField = new JTextField();
        formPanel.add(quantityField);

        formPanel.add(new JLabel("category:"));
        String[] categories = {"guitar", "bass", "drum", "keyboard", "amp", "audio", "accessories"};
        categoryBox = new JComboBox<>(categories);
        formPanel.add(categoryBox);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Save Product");
        backButton = new JButton("Back to Menu");
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> saveProduct());
        backButton.addActionListener(e -> window.showPanel("menu"));

    }

    private void saveProduct() {
        try {
            String name = nameField.getText().trim();
            String brand = brandField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int quantity = Integer.parseInt(quantityField.getText().trim());
            String category = (String) categoryBox.getSelectedItem();

            AddProduct.addProduct(name, brand, price, quantity, category);

            JOptionPane.showMessageDialog(this,
                    "Product added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            nameField.setText("");
            brandField.setText("");
            priceField.setText("");
            quantityField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers for price and quantity.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error adding product: " + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
