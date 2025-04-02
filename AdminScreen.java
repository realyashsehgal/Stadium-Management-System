
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// yae admin screen hogi isme current active events with date and time show
// honge and ek button hoga add events jo naya frame open krega jisme isme bhi
// us addevents ki class hogi object banega call hogi wo iusme
// ek or button rahega isme make reservation kyuki yae admin based application
// hai to us button pe click hoga simialrly new class pe jayenge

public class AdminScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Screen");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        frame.add(mainPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Active Events Panel (Top Left)
        JPanel activeEventPanel = new JPanel();
        activeEventPanel.setBorder(BorderFactory.createTitledBorder("Active Events"));
        activeEventPanel.setPreferredSize(new Dimension(350, 150));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(activeEventPanel, gbc);

        JPanel buttonpanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JButton addEventButton = new JButton("Add event");
        JButton makeReservationButton = new JButton("Make reservation");

        buttonpanel.add(addEventButton);
        buttonpanel.add(makeReservationButton);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.8;
        mainPanel.add(buttonpanel, gbc);
        frame.setVisible(true);
    }
}