package src;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) {
        // Frame setup
        JFrame frame = new JFrame("Stadium Management System");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Header
        JLabel headerLabel = new JLabel("Stadium Management System", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        headerLabel.setForeground(Color.WHITE);

        ImageIcon logo = new ImageIcon("image.png");
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        imgLabel.setBorder(new EmptyBorder(0, 10, 0, 0));

        JPanel headingPanel = new JPanel(new BorderLayout());
        headingPanel.setBackground(Color.BLUE);
        headingPanel.setPreferredSize(new Dimension(1000, 70));
        headingPanel.add(imgLabel, BorderLayout.WEST);
        headingPanel.add(headerLabel, BorderLayout.CENTER);

        // GridBagLayout main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // spacing

        // Login Panel
        AdminLogin loginPanel = new AdminLogin();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(loginPanel, gbc);

        // Event List Panel
        JPanel evlist = new JPanel(new BorderLayout());
        evlist.setPreferredSize(new Dimension(500, 200));
        evlist.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ActiveEventPanel activeEventPanel = new ActiveEventPanel(500, 200);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.3;
        mainPanel.add(activeEventPanel, gbc);

        // Assemble it all
        frame.add(headingPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
