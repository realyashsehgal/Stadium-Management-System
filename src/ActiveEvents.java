package src;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ActiveEvents extends JPanel {
    public ActiveEvents() {
        setLayout(new BorderLayout());

        // Table model with column names
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Fix the table size (Width: 700px, Height: 500px)
        table.setPreferredScrollableViewportSize(new Dimension(740, 200));
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Prevent auto resizing

        // Add scrollPane to panel
        add(scrollPane, BorderLayout.CENTER);

        // Set column headers
        String[] columnNames = { "ID", "Event Name", "Date" };
        tableModel.setColumnIdentifiers(columnNames);

        // Set fixed column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(150); // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(400); // Event Name
        table.getColumnModel().getColumn(2).setPreferredWidth(190); // Date

        // Sample data (without a database)
        List<Object[]> events = Arrays.asList(
                new Object[] { 1, "Music Concert", "2025-04-10" },
                new Object[] { 2, "Tech Conference", "2025-04-15" },
                new Object[] { 3, "Art Exhibition", "2025-04-20" },
                new Object[] { 4, "Food Festival", "2025-04-25" },
                new Object[] { 5, "Film Screening", "2025-04-30" },
                new Object[] { 6, "Sports Championship", "2025-05-05" },
                new Object[] { 7, "Science Fair", "2025-05-10" },
                new Object[] { 8, "Sports Championship", "2025-05-05" },
                new Object[] { 9, "Sports Championship", "2025-05-05" },
                new Object[] { 10, "Sports Championship", "2025-05-05" },
                new Object[] { 11, "Sports Championship", "2025-05-05" },
                new Object[] { 12, "Sports Championship", "2025-05-05" },
                new Object[] { 13, "Sports Championship", "2025-05-05" },
                new Object[] { 14, "Sports Championship", "2025-05-05" },
                new Object[] { 15, "Sports Championship", "2025-05-05" },
                new Object[] { 16, "Sports Championship", "2025-05-05" },
                new Object[] { 17, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" },
                new Object[] { 18, "Sports Championship", "2025-05-05" });

        // Add data to the table
        for (Object[] event : events) {
            tableModel.addRow(event);
        }
    }
}

// Set column headers
// String[] columnNames = { "ID", "Event Name", "Date" };
// tableModel.setColumnIdentifiers(columnNames);

// Fetch data from DatabaseHelper
// List<Object[]> events = DatabaseHelper.getActiveEvents();
// for (Object[] event : events) {
// tableModel.addRow(event);
// }
