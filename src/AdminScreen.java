package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminScreen {
    private static AddEvents addevents = new AddEvents();
    private static MakeReservation makeReservation = new MakeReservation();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Screen");
        frame.setSize(800, 600); // Increased size to fit the table properly
        frame.setLocationRelativeTo(null);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        frame.add(mainPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        // // Add to mainPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.6; // More weight to this panel
        gbc.fill = GridBagConstraints.BOTH;
        ActiveEventPanel activeEventPanel = new ActiveEventPanel(660, 340);
        mainPanel.add(activeEventPanel, gbc);

        // Buttons Panel (Below the Active Events Table)
        JPanel buttonpanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JButton addEventButton = new JButton("Add Event");
        JButton makeReservationButton = new JButton("Make Reservation");

        // Increase button size
        addEventButton.setPreferredSize(new Dimension(180, 50));
        makeReservationButton.setPreferredSize(new Dimension(180, 50));

        buttonpanel.add(addEventButton);
        buttonpanel.add(makeReservationButton);

        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addevents.main(null); // Call the main method using the instance
            }

        });
        makeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeReservation.main(null);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(buttonpanel, gbc);

        frame.setVisible(true);
    }
}
