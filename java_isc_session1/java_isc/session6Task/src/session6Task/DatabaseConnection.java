package session6Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection  {
	
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa" ;
	private static final String PASSWORD = "";

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String departmentId= "1 OR 1=1";
		try( Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement prepared = connection.prepareStatement(
					"SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = ?");
				){
		System.out.println("connection to the database was succsessfully");
				//set the value for prepared statement
		prepared.setString(1, departmentId);	
		try(ResultSet resultSet= prepared.executeQuery()){
			while(resultSet.next()){
				String first=resultSet.getString("FIRST_NAME");
				String last = resultSet.getString("LAST_NAME");
				System.out.println("FIRST:" + first + "LAST:" + last);
			}
				
			
		}		
		
			
		} 

	}

}
