package session6Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DatabaseConnectionWithCloseableInsert {
	// JDBC URL, username and password of H2 server
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; // Default username
	private static final String PASSWORD = ""; // Default password (empty)

	public static void main(String[] args) throws SQLException {
		// Declare the connection and statement objects
		//Connection connection = null;
		//Statement statement = null;
		//ResultSet resultSet = null;

		//String departmentID="2 OR 1=1";
		try(
				Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement prepared = connection.prepareStatement(
						"INSERT INTO COUNTRIES(COUNTRY_NAME,COUNTRY_ID,REGION_ID)" + "VALUES (?,?,?)");
				
				)
		
		{
			
			System.out.println("connection to the database was successfully");
			prepared.setString(1,"IRAN");
			prepared.setString(2, "IR");
			prepared.setString(3, "3");
			
			int rowsAffected = prepared.executeUpdate();
			
			System.out.println("insert" + rowsAffected + "row into the country table");
			
			
	}
	}	
		
		    
			
		
		
		
	
}