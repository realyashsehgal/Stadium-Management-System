import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) {
        // Creating the main application frame
        JFrame frame = new JFrame("Stadium Management System");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centers the frame on the screen
        frame.setLayout(new BorderLayout()); // Using BorderLayout for better organization

        // Header label displaying the application name
        JLabel headerLabel = new JLabel("Stadium Management System", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        headerLabel.setForeground(Color.WHITE); // Set text color for better visibility

        // Loading and resizing the logo image
        ImageIcon logo = new ImageIcon("image.png"); // Ensure the image file is in the correct directory
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(img);

        // Creating a label to hold the logo image
        JLabel imgLabel = new JLabel(resizedLogo);
        imgLabel.setBorder(new EmptyBorder(0, 10, 0, 0)); // Adds padding for better spacing

        // Creating the header panel to hold the logo and title
        JPanel headingPanel = new JPanel(new BorderLayout());
        headingPanel.setBackground(Color.BLUE); // Set background color of the header
        headingPanel.setPreferredSize(new Dimension(1000, 70)); // Set preferred size of the header panel

        // Adding components to the header panel
        headingPanel.add(imgLabel, BorderLayout.WEST); // Logo aligned to the left
        headingPanel.add(headerLabel, BorderLayout.CENTER); // Title centered

        // Creating the login panel and positioning it at the bottom-left
        AdminLogin loginPanel = new AdminLogin();
        JPanel loginContainer = new JPanel(new BorderLayout());
        loginContainer.add(loginPanel, BorderLayout.NORTH);

        // Main content panel to organize components
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(loginContainer, BorderLayout.WEST);

        // Adding components to the frame
        frame.add(headingPanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.WEST);

        // Making the frame visible
        frame.setVisible(true);
    }
}
