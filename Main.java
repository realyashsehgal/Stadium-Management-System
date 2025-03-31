import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) {
        // Creating the main application frame
        JFrame frame = new JFrame("Stadium Management System");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Header label
        JLabel headerLabel = new JLabel("Stadium Management System", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        headerLabel.setForeground(Color.WHITE);

        // Loading and resizing the logo image
        ImageIcon logo = new ImageIcon("image.png");
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(img);

        // Logo label
        JLabel imgLabel = new JLabel(resizedLogo);
        imgLabel.setBorder(new EmptyBorder(0, 10, 0, 0));

        // Header panel
        JPanel headingPanel = new JPanel(new BorderLayout());
        headingPanel.setBackground(Color.BLUE);
        headingPanel.setPreferredSize(new Dimension(1000, 70));

        headingPanel.add(imgLabel, BorderLayout.WEST);
        headingPanel.add(headerLabel, BorderLayout.EAST);

        // Login panel inside a container
        AdminLogin loginPanel = new AdminLogin();
        JPanel loginContainer = new JPanel(new BorderLayout());
        loginContainer.add(loginPanel, BorderLayout.NORTH);

        // Content panel (main content)
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(loginContainer, BorderLayout.WEST);

        // Calendar panel
        JPanel calpanel = new JPanel(new BorderLayout());
        calpanel.setPreferredSize(new Dimension(282, 200));
        calpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel callabel = new JLabel("Calendar Panel", SwingConstants.CENTER);
        callabel.setOpaque(true);
        callabel.setBackground(Color.BLUE);
        calpanel.add(callabel, BorderLayout.CENTER);

        // Event list panel
        JPanel evlist = new JPanel(new BorderLayout());
        evlist.setPreferredSize(new Dimension(300, 190));
        evlist.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel evlabel = new JLabel("Event List", SwingConstants.CENTER);
        evlabel.setOpaque(true);
        evlabel.setBackground(Color.BLUE);
        evlist.add(evlabel, BorderLayout.CENTER);

        // **New Panel to align contentPanel (Top-Left) & evlist (Bottom-Left)**
        JPanel westPanel = new JPanel(new BorderLayout());
        westPanel.add(contentPanel, BorderLayout.CENTER);
        westPanel.add(evlist, BorderLayout.SOUTH);

        // Adding components to the frame
        frame.add(headingPanel, BorderLayout.NORTH);
        frame.add(westPanel, BorderLayout.WEST); // Use westPanel instead of individual panels
        frame.add(calpanel, BorderLayout.EAST);

        // Making the frame visible
        frame.setVisible(true);
    }
}
