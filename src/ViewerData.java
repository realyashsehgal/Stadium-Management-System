package src;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewerData {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel username = new JLabel("Please enter your name");
        JTextField usernamefield = new JTextField(30);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(username, gbc);
        gbc.gridy = 1;
        frame.add(usernamefield, gbc);

        JLabel phonenum = new JLabel("Please enter you phone number");
        JTextField phonenumfield = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(phonenum, gbc);
        gbc.gridy = 1;
        frame.add(phonenumfield, gbc);

        JLabel email = new JLabel("Please enter your email");
        JTextField emailfield = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(email, gbc);
        gbc.gridy = 3;
        frame.add(emailfield, gbc);

        frame.setVisible(true);

    }

}
