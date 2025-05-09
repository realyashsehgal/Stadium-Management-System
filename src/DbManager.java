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

    String veiwername;
    String veiwerphn;
    String veiwermail;
    String paytype;
    public List<ConvertEvent> existingEvents = new ArrayList<>();

    public DbManager() {

    }

    public DbManager(String veiwername, String veiwerphn, String veiwermail, String paytype) {
        this.veiwermail = veiwermail;
        this.veiwername = veiwername;
        this.veiwerphn = veiwerphn;
        this.paytype = paytype;
    }

    public void fetchdata() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM events;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                LocalDate date = rs.getDate("event_date").toLocalDate();
                LocalTime start = rs.getTime("start_time").toLocalTime();
                LocalTime end = rs.getTime("end_time").toLocalTime();
                int seats = rs.getInt("seats");

                ConvertEvent event = new ConvertEvent(id, name, date, start, end, seats);
                existingEvents.add(event);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DbManager(String eventname, LocalDate eventdate, LocalTime starttime, LocalTime endtime,
            int seatcount) {
        this.eventname = eventname;
        this.eventdate = eventdate;
        this.starttime = starttime;
        this.endtime = endtime;
        this.seatcount = seatcount;

    }

    public boolean isTimeConflict() {
        fetchdata();
        for (ConvertEvent obj : existingEvents) {
            if (eventdate.equals(obj.getDate())) {
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

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to insert data into the database.");
        }

    }

    public void insertViewer(int evid) throws SQLException {
        Connection conn = DbConnection.getConnection();
        String insertSQL = "INSERT INTO viewers (name, mail, phonenumber, paymenttype) VALUES (?, ?, ?, ?)";
        String sql = "UPDATE events SET seats = seats - 1 WHERE id = ? AND seats > 0;";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, veiwername);
            pstmt.setString(2, veiwermail);
            pstmt.setString(3, veiwerphn);
            pstmt.setString(4, paytype);
            stmt.setInt(1, evid);
            stmt.executeUpdate();
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
            } else {
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
