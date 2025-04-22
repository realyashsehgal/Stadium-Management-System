package src;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PaymentGateAway {

    void gateWay() {
        JFrame frame = new JFrame("Payment gateaway");
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel mainpanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel cardno = new JLabel("Please enter card no");
        JTextField cardnofield = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainpanel.add(cardno, gbc);
        gbc.gridy = 1;
        mainpanel.add(cardnofield, gbc);

        JLabel amount = new JLabel("Please enter the amount");
        JTextField amountfield = new JTextField(10);
        gbc.gridy = 3;
        mainpanel.add(amount, gbc);
        gbc.gridy = 4;
        mainpanel.add(amountfield, gbc);

        JButton paybutton = new JButton("pay");
        gbc.gridy = 6;
        mainpanel.add(paybutton, gbc);

        paybutton.addActionListener(e -> {
            String cardnum = cardnofield.getText();
            String amountvar = amountfield.getText();

            JOptionPane.showMessageDialog(null, amountvar + " paid through card number " + cardnum);
            frame.dispose();

        });

        frame.add(mainpanel);
        frame.setVisible(true);
    }
}
