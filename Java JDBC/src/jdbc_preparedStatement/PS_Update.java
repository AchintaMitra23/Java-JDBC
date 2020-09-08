package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PS_Update {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(DRIVER);
			
			System.out.println("Connecting to oracle database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection is done successfully...");
			
			System.out.println("Creating statement...");
			String sql = "UPDATE STUDENT SET AGE=? WHERE ID=?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 23);
			ps.setInt(2, 10);
			
			ps.executeUpdate();
			System.out.println("The requirement of table STUDENT is updated...");
			
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
