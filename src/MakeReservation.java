package src;
//is file mae reservation hoga like isme pehle option ayega select events ka jo available hai is waqt isme dhyaan rkhna hoga seats available ho us event ki fir event select hoga then user data dalega name, phone numberm, email, etc etc and done

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MakeReservation {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel selectevent = new JLabel("Select from the following event");
        String[] events = { "yo", "sfa", "tg" };
        JComboBox<String> dropdown = new JComboBox<>(events);
        dropdown.addActionListener(e -> {
            String selected = (String) dropdown.getSelectedItem();
            System.out.println(selected);
        });

        frame.add(dropdown);
        frame.setVisible(true);
    }
}
