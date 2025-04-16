import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class quiz14 {
    private static DefaultTableModel tableModel;
    private static JTable table;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Daftar Produk");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"Nama Produk", "Harga"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        JTextField nameField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JButton addButton = new JButton("Tambah");
        JButton deleteButton = new JButton("Hapus");
        JButton updateButton = new JButton("Ubah");

        // Tambah Produk
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String price = priceField.getText();
            if (!name.isEmpty() && !price.isEmpty()) {
                tableModel.addRow(new Object[]{name, price});
                nameField.setText("");
                priceField.setText("");
            }
        });

        // Hapus Produk
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            }
        });

        // Ubah Produk
        updateButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String currentName = (String) tableModel.getValueAt(selectedRow, 0);
                String currentPrice = (String) tableModel.getValueAt(selectedRow, 1);

                // Menampilkan dialog untuk mengedit nama dan harga
                JPanel editPanel = new JPanel(new GridLayout(0, 2));
                editPanel.add(new JLabel("Edit Nama Produk:"));
                JTextField newNameField = new JTextField(currentName);
                editPanel.add(newNameField);
                editPanel.add(new JLabel("Edit Harga Produk:"));
                JTextField newPriceField = new JTextField(currentPrice);
                editPanel.add(newPriceField);

                int result = JOptionPane.showConfirmDialog(frame, editPanel, "Edit Produk", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String newName = newNameField.getText();
                    String newPrice = newPriceField.getText();

                    // Memastikan input tidak kosong
                    if (!newName.isEmpty() && !newPrice.isEmpty()) {
                        tableModel.setValueAt(newName, selectedRow, 0);
                        tableModel.setValueAt(newPrice, selectedRow, 1);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Silakan pilih produk yang ingin diubah.");
            }
        });

        // Panel Input
        JPanel panel = new JPanel();
        panel.add(new JLabel("Nama:"));
        panel.add(nameField);
        panel.add(new JLabel("Harga:"));
        panel.add(priceField);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(updateButton);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setVisible(true);
    }
}