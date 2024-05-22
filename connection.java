package task.myfurqancode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    private Connection conn;

    public connection() {
        try {
            String url = "jdbc:mysql://localhost:3306/swabi";
            String user = "root";
            String password = "swabiyousafzai@furqan";

            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
