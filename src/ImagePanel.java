package src;

import java.awt.*;
import javax.swing.*;

class ImagePanel extends JPanel {
    private final Image backgroundImage;

    public ImagePanel(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();
        setOpaque(false); // So child components don't block the background
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
