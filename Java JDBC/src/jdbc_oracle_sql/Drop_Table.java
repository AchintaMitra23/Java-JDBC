package jdbc_oracle_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Drop_Table {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(DRIVER);
			
			System.out.println("Connecting to Oracle Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection to Oracle Database successful...");
			
			System.out.println("Deleting table with name STUDENT from Database...");
			stmt = conn.createStatement();
			
			String sql = "DROP TABLE STUDENT";
			stmt.executeUpdate(sql);
			System.out.println("Table STUDENT is deleted from Database");
			
			
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
