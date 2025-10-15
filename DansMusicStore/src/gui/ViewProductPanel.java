package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("View Products");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        // ==== Control bar
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

        // *** proper types
        String[] cols = {"ID", "Name", "Brand", "Price", "Quantity"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override
            public Class<?> getColumnClass(int c) {
                 return switch (c) {
                     case 0, 4 -> Integer.class;
                     case 3 -> Double.class;
                     default -> String.class;
                 };
            }
            @Override public boolean isCellEditiontable(int r, int c) { return false; }
        };

        productTable = new JTable(tableModel);
        productTable.setAutoCreateRowSorter(true);
        productTable.setFillsViewportHeight(true);

        DefaultTableCellRenderer right = new DefaultTableCellRenderer();
        right.setHorizontalAlignment(SwingConstants.RIGHT);
        productTable.getColumnModel().getColumn(3).setCellRenderer(right);
        productTable.getColumnModel().getColumn(3).setCellRenderer(right);

        add(new JScrollPane(productTable), BorderLayout.CENTER);

        refreshButton.addActionListener(e -> loadProducts());
        backButton.addActionListener(e -> window.showPanel("menu"));

        loadProducts();
    }

    private void loadProducts() {
        String category = (String) categoryBox.getSelectedItem();
        refreshButton.setEnabled(false);
        tableModel.setRowCount(0);

        new SwingWorker<List<Object[]>, Void>() {
            @Override
            protected List<Object[]> doInBackground() {
                return ViewProduct.getProductsByCategory(category);
            }

            @Override
            protected void done() {
                try {
                    List<Object[]> products = get();
                    if (products.isEmpty()) {
                        JOptionPane.showMessageDialog(ViewProductPanel.this,
                                "No products found for category: " + category,
                                "Empty", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        for (Object[] row : products) tableModel.addRow(row);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ViewProductPanel.this,
                            "Error loading products: " + ex.getMessage(),
                            "Database Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    refreshButton.setEnabled(true);
                }
            }
        }.execute();
    }
}
