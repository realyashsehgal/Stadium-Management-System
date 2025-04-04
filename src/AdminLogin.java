package src;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminLogin extends JPanel {
    public AdminLogin() {
        AdminScreen adscreen = new AdminScreen();
        // Setting layout for login panel
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(500, 200)); // Setting panel size
        this.setBorder(BorderFactory.createTitledBorder("Login")); // Adding a border with title

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components

        // Username label and text field
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(userLabel, gbc);
        gbc.gridx = 1;
        this.add(userField, gbc);

        // Password label and password field
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(passLabel, gbc);
        gbc.gridx = 1;
        this.add(passField, gbc);

        // Login button
        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        this.add(loginButton, gbc);

        // Action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("admin") && password.equals("password")) {
                    // JOptionPane.showMessageDialog(null, "Login Successful!");
                    adscreen.main(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
