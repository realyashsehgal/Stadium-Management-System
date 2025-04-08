package src;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ActiveEvents extends JPanel {
    public ActiveEvents(int col1, int col2, int col3, int col4, int col5) {
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
        String[] columnNames = { "ID", "Event Name", "Date", "haha", "lala" };
        tableModel.setColumnIdentifiers(columnNames);

        // Set fixed column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(col1); // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(col2); // Event Name
        table.getColumnModel().getColumn(2).setPreferredWidth(col3); // Date
        table.getColumnModel().getColumn(3).setPreferredWidth(col4); // Date
        table.getColumnModel().getColumn(4).setPreferredWidth(col5); // Date
        DbManager db = new DbManager();
        db.fetchdata();
        Object object;
        // Add data to the table
        for (ConvertEvent event : db.existingEvents) {
            Object[] rowData = new Object[] {
                    event.getName(),
                    event.getDate(),
                    event.getStart(),
                    event.getEnd(),
                    event.getSeats()
            };
            System.out.println(rowData.toString());
            tableModel.addRow(rowData);
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
