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
    private JLabel statusLabel;

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

        // *** proper types
        String[] cols = {"ID", "Name", "Brand", "Price", "Quantity"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override
            public Class<?> getColumnClass(int c) {
                 switch (c) {
                     case 0:
                     case 4:
                         return Integer.class;
                     case 3:
                        return Double.class;
                     default:
                         return String.class;
                 }
            }
            @Override public boolean isCellEditable(int r, int c) { return false; }

        };

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        bottomPanel.add(topPanel, BorderLayout.NORTH);

        productTable = new JTable(tableModel);
        productTable.setAutoCreateRowSorter(true);
        productTable.setFillsViewportHeight(true);

        DefaultTableCellRenderer right = new DefaultTableCellRenderer();
        right.setHorizontalAlignment(SwingConstants.RIGHT);
        productTable.getColumnModel().getColumn(3).setCellRenderer(right);
        productTable.getColumnModel().getColumn(4).setCellRenderer(right);

        add(new JScrollPane(productTable), BorderLayout.CENTER);

        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        statusLabel = new JLabel("Ready.");
        statusPanel.add(statusLabel);
        add(statusPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        refreshButton.addActionListener(e -> loadProducts());
        backButton.addActionListener(e -> window.showPanel("menu"));

        loadProducts();
    }

    private void loadProducts() {
        String category = (String) categoryBox.getSelectedItem();
        refreshButton.setEnabled(false);
        tableModel.setRowCount(0);
        statusLabel.setText("Loading " + category + " products...");


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
                        statusLabel.setText("No products found for " + category + ".");
                    } else {
                        for (Object[] row : products) tableModel.addRow(row);
                        statusLabel.setText("Loaded " + products.size() + " " + category + " items. ");
                    }
                } catch (Exception ex) {
                    statusLabel.setText("Error loading products.");
                    JOptionPane.showMessageDialog(ViewProductPanel.this,
                            "Error loading products: " + ex.getMessage(),
                                    "Database error",JOptionPane.ERROR_MESSAGE);
                } finally {
                    refreshButton.setEnabled(true);
                }
            }
        }.execute();
    }
}
