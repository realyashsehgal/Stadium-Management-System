package src;

import java.util.Date;

public class DbAddEvents {
    String eventname;
    Date eventdate;
    Date starttime;
    Date endtime;
    int seatcount;

    public DbAddEvents(String eventname, Date eventdate, Date starttime, Date endtime, int seatcount) {
        this.eventname = eventname;
        this.eventdate = eventdate;
        this.starttime = starttime;
        this.endtime = endtime;
        this.seatcount = seatcount;

    }
}