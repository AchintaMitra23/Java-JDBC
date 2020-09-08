package jdbc_oracle_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete_Records {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		Scanner scan = new Scanner(System.in);
		int id = 0;
		
		try {
			Class.forName(DRIVER);
			
			System.out.println("Connecting to Oracle Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection to Oracle Database successful...");
			
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			for (int i = 0; i < 1; i++) {
				System.out.println("\t Enter ID : ");		id = scan.nextInt();
				String sql = "DELETE FROM STUDENT " + 
							"WHERE id = "+id;
				stmt.executeUpdate(sql);
				System.out.println("Record is deleted from table STUDENT with id : " + id);
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
