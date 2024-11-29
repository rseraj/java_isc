package session6Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCountryId {
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        // Establishing connection to the database
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement prepared = connection.prepareStatement(
                     "UPDATE COUNTRIES SET COUNTRY_ID = ? WHERE COUNTRY_NAME = ?")) {

            System.out.println("Connection to the database was successful");

            // Set parameters for the update
            prepared.setString(1, "ca"); //  lowercase
            prepared.setString(2, "Canada"); 

            // Execute the update
            int rowsAffected = prepared.executeUpdate();

            System.out.println("Updated " + rowsAffected + " row(s) in the COUNTRIES table");
        }
    }
}
