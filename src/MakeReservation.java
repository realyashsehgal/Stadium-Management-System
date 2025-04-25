package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MakeReservation {

    private static ViewerData view = new ViewerData();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Make a Reservation");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        ImagePanel mainpanel = new ImagePanel("imgs\\makereserv.png");
        mainpanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel selectEventLabel = new JLabel("Select from the following events:");

        selectEventLabel.setForeground(new Color(255, 231, 122));
        mainpanel.add(selectEventLabel, gbc);

        // Dropdown menu for event selection
        DbManager db = new DbManager();
        db.fetchdata();

        HashMap<String, Integer> hs = new HashMap<>(); // eventName → eventId
        HashMap<Integer, Integer> hs_seats = new HashMap<>(); // eventId → availableSeats

        for (ConvertEvent ev : db.existingEvents) {
            hs.put(ev.getName(), ev.getid());
            hs_seats.put(ev.getid(), ev.getSeats());
        }

        ArrayList<String> events = new ArrayList<>(hs.keySet());
        JComboBox<String> dropdown = new JComboBox<>(events.toArray(new String[0]));

        gbc.gridy = 1;
        mainpanel.add(dropdown, gbc);

        JButton selecButton = new JButton("Select event");
        gbc.gridy = 2;
        mainpanel.add(selecButton, gbc);
        selecButton.addActionListener(e -> {
            String selected = (String) dropdown.getSelectedItem();
            if (selected != null && hs.containsKey(selected)) {
                int id = hs.get(selected); // Event ID
                int availseats = hs_seats.get(id); // Get available seats by event ID
                view.main(availseats, id);
            } else {
                System.out.println("Please select a valid event.");
            }
        });
        frame.add(mainpanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
