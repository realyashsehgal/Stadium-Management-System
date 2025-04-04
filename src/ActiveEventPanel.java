package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ActiveEventPanel extends JPanel {
    public ActiveEventPanel(int width, int height) {
        JPanel activeEventPanel = new JPanel(new BorderLayout());
        activeEventPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Active Events", TitledBorder.CENTER, TitledBorder.TOP));
        activeEventPanel.setPreferredSize(new Dimension(width, height)); // Updated size

        // Adding ActiveEvents Table Inside This Panel
        ActiveEvents activeevents = new ActiveEvents(width / 3, width / 3, width / 3);
        activeevents.setPreferredSize(new Dimension(width, height)); // Restrict
        // table size
        activeEventPanel.add(activeevents, BorderLayout.CENTER);
        // Add to mainPanel
        GridBagConstraints gbc = new GridBagConstraints();
        // Add to mainPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.6; // More weight to this panel
        gbc.fill = GridBagConstraints.BOTH;
        this.add(activeEventPanel, gbc);
    }
}
