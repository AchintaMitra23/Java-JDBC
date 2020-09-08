package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PS_Select {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(DRIVER);
			int i = 1;
			
			System.out.println("Connecting to Oracle Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection to Oracle Database successful...");
			
			System.out.println("Creating Statement...");
			String sql = "SELECT * FROM STUDENT";
			ps = conn.prepareStatement(sql);
			
			ResultSet res =  ps.executeQuery();
			while (res.next()) {
				System.out.println("Display Student " + i);
				System.out.println("ID : " + res.getInt("id"));
				System.out.println("AGE : " + res.getInt("AGE"));
				System.out.println("ROLL : " + res.getInt("ROLL"));
				System.out.println("NAME : " + res.getString("NAME"));
				System.out.println("DEPT : " + res.getString("DEPT"));
				i++;
			}
			
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
