package jdbc_resutSetMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class RSMetaData {
	
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
			
			System.out.println("Creating Statement...");
			String sql = "SELECT * FROM STUDENT";
			ps = conn.prepareStatement(sql);
			
			ResultSet res =  ps.executeQuery();
			ResultSetMetaData rsmd = res.getMetaData();
			
			System.out.println("Total columns: " + rsmd.getColumnCount());  
			System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));  
			System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));  
			
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
