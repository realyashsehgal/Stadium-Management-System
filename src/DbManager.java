package src;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    String eventname;
    LocalDate eventdate;
    LocalDate starttime;
    LocalDate endtime;
    int seatcount;
    public List<ConvertEvent> existingEvents = new ArrayList<>();

    public void fetchdata() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM events;");

            while (rs.next()) {
                String name = rs.getString("name");
                LocalDate date = rs.getDate("event_date").toLocalDate();
                LocalDate start = rs.getDate("start_time").toLocalDate();
                LocalDate end = rs.getDate("end_time").toLocalDate();
                int seats = rs.getInt("seats");

                ConvertEvent event = new ConvertEvent(name, date, start, end, seats);
                existingEvents.add(event);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DbManager(String eventname, LocalDate eventdate, LocalDate starttime, LocalDate endtime, int seatcount) {
        this.eventname = eventname;
        this.eventdate = eventdate;
        this.starttime = starttime;
        this.endtime = endtime;
        this.seatcount = seatcount;

    }

    public boolean isTimeConflict() {
        System.out.println("i ran");
        fetchdata();
        System.out.println(eventdate);
        for (ConvertEvent obj : existingEvents) {
            System.out.print(obj.getDate());
            if (eventdate.equals(obj.getDate())) {
                System.out.println("tryyy");
                return true;
            }
        }
        return false;
    }

    public void insertEvent() {

    }
}
