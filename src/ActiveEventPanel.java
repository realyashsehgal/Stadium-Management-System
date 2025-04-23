package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ActiveEventPanel extends JPanel {
    public ActiveEventPanel(int width, int height) {
        JPanel activeEventPanel = new JPanel(new BorderLayout());

        // Create titled border with etched border
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Active Events",
                TitledBorder.CENTER,
                TitledBorder.TOP);
        titledBorder.setTitleColor(Color.WHITE);
        activeEventPanel.setBorder(titledBorder);

        activeEventPanel.setOpaque(false); // Make the background transparent
        this.setOpaque(false); // Make the parent panel transparent too

        activeEventPanel.setPreferredSize(new Dimension(width, height));

        // Add ActiveEvents Table
        ActiveEvents activeevents = new ActiveEvents(width / 5, width / 5, width / 5, width / 5, width / 5);
        activeevents.setPreferredSize(new Dimension(width, height));
        activeevents.setOpaque(false); // Optional: also make the inner table panel transparent
        activeEventPanel.add(activeevents, BorderLayout.CENTER);

        // Add to main panel with constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.6;
        // gbc.fill = GridBagConstraints.BOTH;
        this.setLayout(new java.awt.GridBagLayout()); // 🧩 Don't forget to set layout for `this`
        this.add(activeEventPanel, gbc);
    }
}
