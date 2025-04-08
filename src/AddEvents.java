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

    public static void main(String[] Args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Event Name
        JLabel eventname = new JLabel("Please enter the name of the event");
        JTextField eventnamefield = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(eventname, gbc);
        gbc.gridy = 1;
        frame.add(eventnamefield, gbc);

        // Event LocalDate
        JLabel eventdate = new JLabel("Please enter the date of the event");
        SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH);
        JSpinner datespinner = new JSpinner(model);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datespinner, "yyyy-MM-dd");
        datespinner.setEditor(dateEditor);
        gbc.gridx = 2;
        gbc.gridy = 0;
        frame.add(eventdate, gbc);
        gbc.gridy = 1;
        frame.add(datespinner, gbc);

        // Event Time Label
        JLabel eventtime = new JLabel("Please enter the time for the event");
        JLabel startTimeLabel = new JLabel("Start Time:");
        SpinnerDateModel startTimeModel = new SpinnerDateModel();
        JSpinner startTimeSpinner = new JSpinner(startTimeModel);
        JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(startTimeSpinner, "HH:mm");
        startTimeSpinner.setEditor(startTimeEditor);

        JLabel endTimeLabel = new JLabel("End Time:");
        SpinnerDateModel endTimeModel = new SpinnerDateModel();
        JSpinner endTimeSpinner = new JSpinner(endTimeModel);
        JSpinner.DateEditor endTimeEditor = new JSpinner.DateEditor(endTimeSpinner, "HH:mm");
        endTimeSpinner.setEditor(endTimeEditor);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(eventtime, gbc);
        gbc.gridy = 5;
        frame.add(startTimeLabel, gbc);
        gbc.gridy = 6;
        frame.add(startTimeSpinner, gbc);
        gbc.gridy = 7;
        frame.add(endTimeLabel, gbc);
        gbc.gridy = 8;
        frame.add(endTimeSpinner, gbc);

        // Seat Count
        JLabel seats = new JLabel("Please enter the number of seats available");
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
        frame.add(seats, gbc);
        gbc.gridy = 5;
        frame.add(seatscount, gbc);

        // Add Button
        JButton add = new JButton("Add event");
        add.setPreferredSize(new Dimension(180, 100));
        gbc.gridx = 1;
        gbc.gridy = 9;
        frame.add(add, gbc);

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
                    // LocalDate eventDate = (LocalDate) datespinner.getValue();
                    // LocalDate startTime = (LocalDate) startTimeSpinner.getValue();
                    // LocalDate endTime = (LocalDate) endTimeSpinner.getValue();
                    int seatCount = Integer.parseInt(seatscount.getText());

                    if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
                        System.out.println(startTime + "   " + endTime);
                        JOptionPane.showMessageDialog(null, "Start time must be before end time!");
                        return;
                    }
                    DbManager newEvent = new DbManager(eventname, eventDate, startTime, endTime, seatCount);

                    if (newEvent.isTimeConflict()) {
                        JOptionPane.showMessageDialog(null, "⚠️ Time conflict: Another event overlaps!");
                    } else {
                        newEvent.insertEvent();
                        JOptionPane.showMessageDialog(null, "🎉 Event added successfully!");
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
