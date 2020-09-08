package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchProccessingPS {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		int id = 0, roll = 0, age = 0;
		String name = "", dept = "";
		
		try {
			Class.forName(DRIVER);
			
			System.out.println("Connecting to oracle database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection is done successfully...");
			
			System.out.println("Inserting records into STUDENT on Database...");
			String sql = "INSERT INTO STUDENT VALUES (?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			Scanner scan = new Scanner(System.in);
			while (true) {
				System.out.print("\t ID   : ");		id = scan.nextInt();
				System.out.print("\t NAME : ");		name = scan.next();
				System.out.print("\t ROLL : ");		roll = scan.nextInt();
				System.out.print("\t AGE  : ");		age = scan.nextInt();
				System.out.print("\t DEPT : ");		dept = scan.next();
				
				ps.setInt(1, id);
				ps.setString(2, String.valueOf(name));
				ps.setString(3, String.valueOf(dept));
				ps.setInt(4, roll);
				ps.setInt(5, age);
				
				ps.addBatch();
				System.out.print("\n\t Want to add more (y/n): ");		String ans = scan.next();
				if (ans.equalsIgnoreCase("n")) {
					break;
				}
			}
			ps.executeBatch();
			System.out.println("Records have been successfully submitted...");
			
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
