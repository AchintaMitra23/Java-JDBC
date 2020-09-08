package jdbc_databaseMetaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBMetaData {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(DRIVER);
			
			System.out.println("Connecting to Oracle Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection to Oracle Database successful...");
			
			DatabaseMetaData dbmd = conn.getMetaData();
			
			System.out.println("Driver Name: " + dbmd.getDriverName());  
			System.out.println("Driver Version: " + dbmd.getDriverVersion());  
			System.out.println("UserName: " + dbmd.getUserName());  
			System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());  
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null || conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
