package src;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewerData {

    public void main(int avseats, int evid) {
        JFrame frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        ImagePanel mainpanel = new ImagePanel("imgs\\stands.png");
        mainpanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel username = new JLabel("Please enter your name");
        JTextField usernamefield = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainpanel.add(username, gbc);
        gbc.gridy = 1;
        mainpanel.add(usernamefield, gbc);

        JLabel phonenum = new JLabel("Please enter your phone number");
        JTextField phonenumfield = new JTextField();
        phonenumfield.setColumns(10);
        phonenumfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = phonenumfield.getText();

                // Only allow digits, block input if already 10 characters
                if (!Character.isDigit(c) || text.length() >= 10) {
                    e.consume(); // Ignore this keypress
                }
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        mainpanel.add(phonenum, gbc);
        gbc.gridy = 1;
        mainpanel.add(phonenumfield, gbc);

        JLabel email = new JLabel("Please enter your email");
        JTextField emailfield = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainpanel.add(email, gbc);
        gbc.gridy = 3;
        mainpanel.add(emailfield, gbc);

        String[] paytype = { "Cash", "Online" };
        JLabel paymenttype = new JLabel("Please select a payment type");
        gbc.gridx = 2;
        gbc.gridy = 2;
        mainpanel.add(paymenttype, gbc);
        JComboBox<String> paymentypedropdown = new JComboBox<>(paytype);
        gbc.gridy = 3;
        mainpanel.add(paymentypedropdown, gbc);

        JButton addviewer = new JButton("Book seats");
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainpanel.add(addviewer, gbc);
        addviewer.addActionListener(e -> {
            if (avseats > 0) {

                String veiwername = usernamefield.getText();
                String viewerphn = phonenumfield.getText();
                String mailfield = emailfield.getText();
                String selectedPayType = (String) paymentypedropdown.getSelectedItem();
                if (selectedPayType.equals("Online")) {
                    PaymentGateAway pgw = new PaymentGateAway();
                    pgw.gateWay();
                    frame.dispose();
                }
                DbManager newviewer = new DbManager(veiwername, viewerphn, mailfield, selectedPayType);
                try {
                    newviewer.insertViewer(evid);
                    frame.dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Error inserting viewer data: " + ex.getMessage());
                }
            }
        });
        frame.add(mainpanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

}
