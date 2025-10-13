package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;
import java.util.Objects;

import managers.ViewProduct;

public class ViewProductPanel extends JPanel {

    private JComboBox<String> categoryBox;
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JButton refreshButton, backButton;
    private MainWindow window;

    public ViewProductPanel(MainWindow window) {
        this.window = window;
        setLayout(new BorderLayout(10,10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("View Products");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        categoryBox = new JComboBox<>(new String[]{
                "guitar", "bass", "drum", "keyboard", "amp", "audio", "accessories"
        });
        refreshButton = new JButton("Refresh");
        backButton = new JButton("Back to menu");
        topPanel.add(new JLabel("Category:"));
        topPanel.add(categoryBox);
        topPanel.add(refreshButton);
        topPanel.add(backButton);
        add(topPanel, BorderLayout.SOUTH);

        String[] columnNames = {"ID", "Name", "Brand", "Price", "Quantity"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(tableModel);
        productTable.setFillsViewportHeight(true);
        add(new JScrollPane(productTable), BorderLayout.CENTER);

        refreshButton.addActionListener(e -> loadProducts());
        backButton.addActionListener(e -> window.showPanel("menu"));

        loadProducts();
    }

    private void loadProducts() {
        String category = (String) categoryBox.getSelectedItem();
        tableModel.setRowCount(0);

        try {
            List<Object[]> products = ViewProduct.getProductsByCategory(category);
            for (Object[] row : products) {
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading products: " + e.getMessage(),
                            "Database error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
