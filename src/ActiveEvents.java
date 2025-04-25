package src;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ActiveEvents extends JPanel {
    public ActiveEvents(int col1, int col2, int col3, int col4, int col5) {
        setLayout(new BorderLayout());

        // Table model with column names
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Fix the table size (Width: 700px, Height: 500px)
        table.setPreferredScrollableViewportSize(new Dimension(740, 200));
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Prevent auto resizing
        // After creating JTable
        table.setBackground(new Color(106, 153, 78));// background
        table.setForeground(Color.WHITE);
        table.setGridColor(new Color(56, 102, 65));// grid color

        table.getTableHeader().setBackground(new Color(108, 88, 76));
        table.getTableHeader().setForeground(Color.WHITE);

        // Optional aesthetics
        scrollPane.getViewport().setBackground(new Color(169, 132, 103));
        this.setBackground(new Color(169, 132, 103));

        // Add scrollPane to panel
        add(scrollPane, BorderLayout.CENTER);

        // Set column headers
        String[] columnNames = { "Event Name", "Date", "Start Time", "End Time", "Total Seats" };
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
            tableModel.addRow(rowData);
        }
    }
}
