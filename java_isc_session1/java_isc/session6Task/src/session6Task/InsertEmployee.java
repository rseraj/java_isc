package session6Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployee {
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa" ;
	private static final String PASSWORD = "";

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		try( Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement prepared = connection.prepareStatement(
						"INSERT INTO EMPLOYEES(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,MANAGER_ID,DEPARTMENT_ID )" + "VALUES (?,?,?,?,?,?,?,?,?,?)");
					){
			System.out.println("connection to the database was successfully");
			prepared.setString(1,"1");
			prepared.setString(2, "REYHANEH");
			prepared.setString(3, "SERAJ");
			prepared.setString(4, "www");
			prepared.setString(5, "0903");
			prepared.setString(6, "2023-07-07");
			prepared.setString(7, "13");
			prepared.setString(8,"450000");
			prepared.setNull(9, java.sql.Types.INTEGER);
			prepared.setString(10, "6");
			
			int rowsAffected = prepared.executeUpdate();
			
			System.out.println("insert" + rowsAffected + "row into the employees table");
		}

	}

}
