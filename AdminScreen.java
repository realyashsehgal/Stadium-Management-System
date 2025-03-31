
import java.awt.*;
import javax.swing.JFrame;

// yae admin screen hogi isme current active events with date and time show
// honge and ek button hoga add events jo naya frame open krega jisme isme bhi
// us addevents ki class hogi object banega call hogi wo iusme
// ek or button rahega isme make reservation kyuki yae admin based application
// hai to us button pe click hoga simialrly new class pe jayenge

public class AdminScreen {
    public void main(String[] args) {
        JFrame frame = new JFrame("Admin screen");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        frame.setVisible(true);
    }
}