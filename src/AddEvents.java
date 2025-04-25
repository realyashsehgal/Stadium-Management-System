package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class AddEvents {

    public void main() {
        JFrame frame = new JFrame("Add New Event");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout()); // Changed layout to BorderLayout

        JLabel headerLabel = new JLabel("Add new event", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        headerLabel.setForeground(Color.WHITE);

        ImagePanel headingPanel = new ImagePanel("imgs\\hed.png");
        headingPanel.setPreferredSize(new Dimension(1000, 70));
        // headingPanel.add(imgLabel, BorderLayout.WEST);
        headingPanel.add(headerLabel, BorderLayout.CENTER);

        ImagePanel formPanel = new ImagePanel("imgs\\yel.png"); // Form content stays
        // here
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Event Name
        JLabel eventname = new JLabel("Please enter the name of the event");
        eventname.setForeground(new Color(255, 231, 122));
        JTextField eventnamefield = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(eventname, gbc);
        gbc.gridx = 1;
        formPanel.add(eventnamefield, gbc);

        // Event LocalDate
        JLabel eventdate = new JLabel("Please enter the date of the event");
        eventdate.setForeground(new Color(255, 231, 122));
        SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH);
        JSpinner datespinner = new JSpinner(model);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datespinner, "yyyy-MM-dd");
        datespinner.setEditor(dateEditor);
        gbc.gridx = 2;
        gbc.gridy = 0;
        formPanel.add(eventdate, gbc);
        gbc.gridx = 3;
        formPanel.add(datespinner, gbc);

        // Event Time
        JLabel eventtime = new JLabel("Please enter the time for the event");
        eventtime.setForeground(new Color(255, 231, 122));
        JLabel startTimeLabel = new JLabel("Start Time:");
        startTimeLabel.setForeground(new Color(255, 231, 122));
        SpinnerDateModel startTimeModel = new SpinnerDateModel();
        JSpinner startTimeSpinner = new JSpinner(startTimeModel);
        JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(startTimeSpinner, "HH:mm");
        startTimeSpinner.setEditor(startTimeEditor);

        JLabel endTimeLabel = new JLabel("End Time:");
        endTimeLabel.setForeground(new Color(255, 231, 122));
        SpinnerDateModel endTimeModel = new SpinnerDateModel();
        JSpinner endTimeSpinner = new JSpinner(endTimeModel);
        JSpinner.DateEditor endTimeEditor = new JSpinner.DateEditor(endTimeSpinner, "HH:mm");
        endTimeSpinner.setEditor(endTimeEditor);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(eventtime, gbc);
        gbc.gridy = 5;
        formPanel.add(startTimeLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(startTimeSpinner, gbc);
        gbc.gridy = 6;
        gbc.gridx = 0;
        formPanel.add(endTimeLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(endTimeSpinner, gbc);

        // Seat Count
        JLabel seats = new JLabel("Please enter the number of seats available");
        seats.setForeground(new Color(255, 231, 122));
        JTextField seatscount = new JTextField(5);
        ((AbstractDocument) seatscount.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
                if (newText.matches("\\d+")) {
                    try {
                        int value = Integer.parseInt(newText);
                        if (value <= 40000) {
                            super.insertString(fb, offset, string, attr);
                        }
                    } catch (NumberFormatException e) {
                        // Do nothing
                    }
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                StringBuilder sb = new StringBuilder(currentText);
                sb.replace(offset, offset + length, text);
                String newText = sb.toString();

                if (newText.matches("\\d*")) {
                    try {
                        int value = newText.isEmpty() ? 0 : Integer.parseInt(newText);
                        if (value <= 40000) {
                            super.replace(fb, offset, length, text, attrs);
                        }
                    } catch (NumberFormatException e) {
                        // Do nothing
                    }
                }
            }
        });

        gbc.gridx = 2;
        gbc.gridy = 4;
        formPanel.add(seats, gbc);
        gbc.gridx = 3;
        formPanel.add(seatscount, gbc);

        // Create the button
        JButton add = new JButton("Add Event");
        add.setPreferredSize(new Dimension(180, 50));

        // Button Panel
        ImagePanel buttonPanel = new ImagePanel("imgs\\bot.png");
        buttonPanel.add(add);

        // Add components to frame
        frame.add(headingPanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button Action
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String eventname = eventnamefield.getText();
                    Date date = (Date) datespinner.getValue();
                    LocalDate eventDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    Date date1 = (Date) startTimeSpinner.getValue();
                    LocalTime startTime = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                    Date date2 = (Date) endTimeSpinner.getValue();
                    LocalTime endTime = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                    int seatCount = Integer.parseInt(seatscount.getText());

                    if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
                        JOptionPane.showMessageDialog(null, "Start time must be before end time!");
                        return;
                    }

                    DbManager newEvent = new DbManager(eventname, eventDate, startTime, endTime, seatCount);

                    if (newEvent.isTimeConflict()) {
                        JOptionPane.showMessageDialog(null, " Time conflict: Another event overlaps!");
                    } else {
                        newEvent.insertEvent();
                        JOptionPane.showMessageDialog(null, " Event added successfully!");
                        frame.dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }
}
