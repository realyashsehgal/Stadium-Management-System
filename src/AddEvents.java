package src;

import java.awt.*;
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

        // Event Date
        JLabel eventdate = new JLabel("Please enter the date of the event");
        SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH);
        JSpinner datespinner = new JSpinner(model);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datespinner, "yyyy-MM-dd");
        datespinner.setEditor(dateEditor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(eventdate, gbc);

        gbc.gridy = 3;
        frame.add(datespinner, gbc);
        // Event Time Label
        JLabel eventtime = new JLabel("Please enter the time for the event");

        // Start Time
        JLabel startTimeLabel = new JLabel("Start Time:");
        SpinnerDateModel startTimeModel = new SpinnerDateModel();
        JSpinner startTimeSpinner = new JSpinner(startTimeModel);
        JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(startTimeSpinner, "HH:mm");
        startTimeSpinner.setEditor(startTimeEditor);

        // End Time
        JLabel endTimeLabel = new JLabel("End Time:");
        SpinnerDateModel endTimeModel = new SpinnerDateModel();
        JSpinner endTimeSpinner = new JSpinner(endTimeModel);
        JSpinner.DateEditor endTimeEditor = new JSpinner.DateEditor(endTimeSpinner, "HH:mm");
        endTimeSpinner.setEditor(endTimeEditor);

        // Add to layout
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

        JLabel seats = new JLabel("Please enter the number of seats available");
        JTextField seatscount = new JTextField(5);

        // Digit-only and value check (max 40000)
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
                        // Do nothing, invalid input
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
                        // Invalid number
                    }
                }
            }
        });

        gbc.gridy = 9;
        frame.add(seats, gbc);

        gbc.gridy = 10;
        frame.add(seatscount, gbc);

        frame.setVisible(true);
    }
}
