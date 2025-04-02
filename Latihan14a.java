import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Latihan14a {
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
                String newName = JOptionPane.showInputDialog(frame, "Edit Nama Produk:", currentName);
                String newPrice = JOptionPane.showInputDialog(frame, "Edit Harga Produk:", currentPrice);

                // Memastikan input tidak kosong
                if (newName != null && newPrice != null && !newName.isEmpty() && !newPrice.isEmpty()) {
                    tableModel.setValueAt(newName, selectedRow, 0);
                    tableModel.setValueAt(newPrice, selectedRow, 1);
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