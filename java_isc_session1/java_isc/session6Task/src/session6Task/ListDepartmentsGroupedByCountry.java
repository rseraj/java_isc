package session6Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListDepartmentsGroupedByCountry {
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        // Establishing connection to the database
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement prepared = connection.prepareStatement(
                     "SELECT c.COUNTRY_NAME, d.DEPARTMENT_NAME " +
                     "FROM COUNTRIES c " +
                     "JOIN DEPARTMENTS d ON c.COUNTRY_ID = d.COUNTRY_ID " +
                     "ORDER BY c.COUNTRY_NAME")) {

            System.out.println("Connection to the database was successful");

            // Execute the query
            try (ResultSet resultSet = prepared.executeQuery()) {
                String currentCountry = null;

                while (resultSet.next()) {
                    String countryName = resultSet.getString("COUNTRY_NAME");
                    String departmentName = resultSet.getString("DEPARTMENT_NAME");

                    // Print country name as a heading when it changes
                    if (!countryName.equals(currentCountry)) {
                        if (currentCountry != null) {
                            System.out.println(); // Print a newline between countries
                        }
                        System.out.println("Country: " + countryName);
                        currentCountry = countryName; // Update current country
                    }

                    // Print department name under the respective country
                    System.out.println(" - Department: " + departmentName);
                }
            }
        }
    }
}
