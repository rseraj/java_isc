package session6Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DatabaseConnectionWithCloseable2 {
	// JDBC URL, username and password of H2 server
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; // Default username
	private static final String PASSWORD = ""; // Default password (empty)

	public static void main(String[] args) throws SQLException {
		// Declare the connection and statement objects
		//Connection connection = null;
		//Statement statement = null;
		//ResultSet resultSet = null;

		String startWith="A";
		try(
				Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES WHERE FIRST_NAME %" + startWith + "%");
				
				)
		
		{
			
			System.out.println("connection to the database was successfully");
			
			
			
				while(resultSet.next()) {
				String first=resultSet.getString("FIRST_NAME");
				String last = resultSet.getString("LAST_NAME");
				System.out.println("FIRST:" + first + "LAST:" + last);
			}
		}
	}
	}
		
		
		    
			
		
		
		
	
