
//This is going to be the main frame isme we will have the intro like name of the application, logo, current active events(optional), and login button 
//is file mai code aisa hoga like ui, then button or fir unke functions call jo task hona hai like admin login wala button click hoga to admin class ka object banake uske method ko call krenge
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main frame");// This is the main frame

        JLabel heading_label = new JLabel("Staduim Mangement System", SwingConstants.CENTER);// This is heading label
                                                                                             // displayed on the frame
                                                                                             // center aligned
        heading_label.setFont(new Font("Ariel", Font.BOLD, 25));

        frame.setSize(700, 600);

        frame.add(heading_label, BorderLayout.NORTH);// This adds teh label to the frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// It is a closing fucntion it means when click on close
                                                             // button of frame it will close the progrm

        frame.setLocationRelativeTo(null);// This aligns the frame to center of the screebn

        frame.setVisible(true);
    }
}