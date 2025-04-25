package src;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PaymentGateAway {

    void gateWay() {
        JFrame frame = new JFrame("Payment Gateway");
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        ImagePanel mainpanel = new ImagePanel("imgs\\pgw.png");
        mainpanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Load and scale image
        ImageIcon originalIcon = new ImageIcon("imgs\\qr.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(scaledImage);
        JLabel qrcode = new JLabel(imageIcon);

        // Panel for the image
        JPanel imgpanel = new JPanel();
        imgpanel.add(qrcode);

        // Place image on the left, vertically centered
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        mainpanel.add(imgpanel, gbc);

        // Reset for form fields
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Card Number
        JLabel cardno = new JLabel("Please enter card no");
        JTextField cardnofield = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 0;
        mainpanel.add(cardno, gbc);
        gbc.gridy = 1;
        mainpanel.add(cardnofield, gbc);

        // Amount
        JLabel amount = new JLabel("Please enter the amount");
        JTextField amountfield = new JTextField(15);
        gbc.gridy = 2;
        mainpanel.add(amount, gbc);
        gbc.gridy = 3;
        mainpanel.add(amountfield, gbc);

        // Pay Button
        JButton paybutton = new JButton("Pay");
        gbc.gridy = 4;
        mainpanel.add(paybutton, gbc);

        paybutton.addActionListener(e -> {
            String cardnum = cardnofield.getText();
            String amountvar = amountfield.getText();
            if (!cardnum.isEmpty() && !amountvar.isEmpty()) {

                JOptionPane.showMessageDialog(null, amountvar + " paid through card number " + cardnum);
            } else {
                JOptionPane.showMessageDialog(null, "Please enter your data first");

            }
            frame.dispose();
        });

        frame.add(mainpanel);
        frame.setVisible(true);
    }
}
