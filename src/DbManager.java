package src;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    String eventname;
    LocalDate eventdate;
    LocalTime starttime;
    LocalTime endtime;
    int seatcount;
    public List<ConvertEvent> existingEvents = new ArrayList<>();

    public DbManager() {

    }

    public void fetchdata() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM events;");

            while (rs.next()) {
                String name = rs.getString("name");
                LocalDate date = rs.getDate("event_date").toLocalDate();
                LocalTime start = rs.getTime("start_time").toLocalTime();
                LocalTime end = rs.getTime("end_time").toLocalTime();
                int seats = rs.getInt("seats");

                ConvertEvent event = new ConvertEvent(name, date, start, end, seats);
                existingEvents.add(event);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DbManager(String eventname, LocalDate eventdate, LocalTime starttime, LocalTime endtime, int seatcount) {
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

    public void insertEvent() throws SQLException {
        Connection conn = DbConnection.getConnection();
        String query = "INSERT INTO events (name, event_date, start_time, end_time, seats) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, eventname);
            stmt.setDate(2, java.sql.Date.valueOf(eventdate));
            stmt.setTime(3, java.sql.Time.valueOf(starttime));
            stmt.setTime(4, java.sql.Time.valueOf(endtime));
            stmt.setInt(5, seatcount);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " row(s) inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to insert data into the database.");
        }

    }
}
