package jdbc_oracle_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table {
	
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
			
			System.out.println("Creating table with name STUDENT in Database...");
			stmt = conn.createStatement();
			
			String sql = "CREATE TABLE STUDENT " + "(id INTEGER not NULL, " + 
						" NAME VARCHAR(50), " + " DEPT VARCHAR(50), " + " ROLL INTEGER, " + 
						" AGE INTEGER, " + " PRIMARY KEY (id))";
			stmt.executeUpdate(sql);
			System.out.println("Table STUDENT is created in Database with: " + sql);
			
			
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
