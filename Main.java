
//This is going to be the main frame isme we will have the intro like name of the application, logo, current active events(optional), and login button 
//is file mai code aisa hoga like ui, then button or fir unke functions call jo task hona hai like admin login wala button click hoga to admin class ka object banake uske method ko call krenge
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main frame");// This is the main frame
        JLabel header_label = new JLabel("Staduim Mangement System", SwingConstants.CENTER);// This is header label
        header_label.setFont(new Font("Ariel", Font.BOLD, 25));

        ImageIcon logo = new ImageIcon("image.png");// logo mae imgae store kri is object mae
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);// yae image ka naya object banaya
                                                                                  // image resize krne ke liye
        ImageIcon resized_log = new ImageIcon(img);// naya resized image icon banyaa idhar
        JLabel imglabel = new JLabel(resized_log);// or idhar image ke liyue naya label
        imglabel.setBorder(new EmptyBorder(0, 4, 0, 0));

        // The panel below it will have logo, title etc thigns
        JPanel heading_panel = new JPanel();
        heading_panel.setBackground(Color.BLUE);// for setting background color
        heading_panel.setPreferredSize(new Dimension(1000, 70));// setting size to take some sapce above
        heading_panel.setLayout(new BorderLayout());// changin the layout type so more labels can fir inside
        heading_panel.add(header_label, BorderLayout.EAST);// aliging the header label which have the title
        heading_panel.add(imglabel, BorderLayout.WEST);

        // ADDING THINGS TO FRAME ITSELF
        frame.setSize(1000, 800);
        frame.add(heading_panel, BorderLayout.NORTH);
        // frame.add(header_label, BorderLayout.NORTH);// This adds teh label to the
        // frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// It is a closing fucntion it means when click on close
                                                             // button of frame it will close the progrm
        frame.setLocationRelativeTo(null);// This aligns the frame to center of the screebn
        frame.setVisible(true);
    }
}