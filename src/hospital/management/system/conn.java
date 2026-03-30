package hospital.management.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection connection;
    Statement statement;

    public conn() {
        try {
            // Load driver (optional for newer JDBC versions, but safe)
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital_management_system",
                    "root",
                    "Ayushu@123"
            );

            statement = connection.createStatement();
            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
