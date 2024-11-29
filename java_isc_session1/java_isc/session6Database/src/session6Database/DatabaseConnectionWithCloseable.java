package session6Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DatabaseConnectionWithCloseable {
	// JDBC URL, username and password of H2 server
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; // Default username
	private static final String PASSWORD = ""; // Default password (empty)

	public static void main(String[] args) throws SQLException {
		

		String departmentID="2 OR 1=1";
		try(
				Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement prepared = connection.prepareStatement(
						"SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = ?");
				
				)
		
		{
			
			System.out.println("connection to the database was successfully");
			prepared.setString(1,departmentID);
			try(ResultSet resultSet = prepared.executeQuery()){
			
				while(resultSet.next()) {
				String first=resultSet.getString("FIRST_NAME");
				String last = resultSet.getString("LAST_NAME");
				System.out.println("FIRST:" + first + "LAST:" + last);
			}
		}
	}
	}
		
		
		    
			
		
		
		
	
}