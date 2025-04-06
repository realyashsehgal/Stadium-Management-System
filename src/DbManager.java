package src;

import java.util.Date;

public class DbManager {
    private final String url = "Jdbc:mysql://localhost:3306/minor_project";
    private final String user = "admin";
    private final String password = "password";
    private final String query = "SELECT * FROM event";
    String eventname;
    Date eventdate;
    Date starttime;
    Date endtime;
    int seatcount;

    public void fetchdata() {

    }

    public DbManager(String eventname, Date eventdate, Date starttime, Date endtime, int seatcount) {
        this.eventname = eventname;
        this.eventdate = eventdate;
        this.starttime = starttime;
        this.endtime = endtime;
        this.seatcount = seatcount;

    }

    public boolean isTimeConflict() {
        return true;
    }

    public void insertEvent() {

    }
}
