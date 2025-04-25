package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DatabaseInitializer {
    private static final String url = "jdbc:mysql://localhost:3306";
    private static String user = "";
    private static String password = "";

    public static int initialize() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS minor_project");

            conn = DbConnection.getConnection();
            stmt = conn.createStatement();

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS events (" +
                            "id int PRIMARY KEY AUTO_INCREMENT, " +
                            "name VARCHAR(20), " +
                            "event_date date, " +
                            "start_time time, " +
                            "end_time time, " +
                            "seats int)");

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS viewers (" +
                            "id int PRIMARY KEY AUTO_INCREMENT, " +
                            "name VARCHAR(100), " +
                            "mail varchar(100), " +
                            "phonenumber varchar(15), " +
                            "paymenttype varchar(50))");
            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Connecting to SQL, Please Check SQLConfig.txt!", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public static void getCreds() throws IOException {
        String creds = Files.readString(Path.of("lib/SQLConfig.txt"));
        String[] arr = creds.split("\n");
        user = arr[0].trim();
        password = arr[1].trim();
    }
}