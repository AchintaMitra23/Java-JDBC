package jdbc_oracle_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_Records {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(DRIVER);
			int i = 1;
			
			System.out.println("Connecting to Oracle Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection to Oracle Database successful...");
			
			System.out.println("Creating Statement...");
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM STUDENT";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Displaying records from STUDENT: ");
			while (rs.next()) {
				System.out.println("Display Student " + i);
				System.out.println("ID : " + rs.getInt("id"));
				System.out.println("AGE : " + rs.getInt("AGE"));
				System.out.println("ROLL : " + rs.getInt("ROLL"));
				System.out.println("NAME : " + rs.getString("NAME"));
				System.out.println("DEPT : " + rs.getString("DEPT"));
				i++;
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null || conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
