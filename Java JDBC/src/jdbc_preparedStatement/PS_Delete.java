package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PS_Delete {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		Scanner scan = new Scanner(System.in);
		int id = 0;
		
		try {
			Class.forName(DRIVER);
			
			System.out.println("Connecting to oracle database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection is done successfully...");
			
			System.out.println("Creating statement...");
			System.out.print("\t ID   : ");		id = scan.nextInt();
			
			String sql = "DELETE FROM STUDENT WHERE ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			System.out.println("Record is deleted from table STUDENT with id : " + id);
			
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
