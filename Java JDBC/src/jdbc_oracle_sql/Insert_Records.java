package jdbc_oracle_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert_Records {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		Scanner scan = new Scanner(System.in);
		int id = 0, roll = 0, age = 0;
		String name = "", dept = ""; 
		
		try {
			Class.forName(DRIVER);
			
			System.out.println("Connecting to Oracle Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection to Oracle Database successful...");
			
			System.out.println("Inserting records into STUDENT on Database...");
			stmt = conn.createStatement();
			
			for (int i = 0; i < 1; i++) {
				System.out.println("Input for record " + i + " is : ");
				System.out.println("\t ID   : ");		id = scan.nextInt();
				System.out.println("\t NAME : ");		name = scan.next();
				System.out.println("\t ROLL : ");		roll = scan.nextInt();
				System.out.println("\t AGE  : ");		age = scan.nextInt();
				System.out.println("\t DEPT : ");		dept = scan.next();
				
				String sql = "INSERT INTO STUDENT " + 
						"VALUES ("+id+", '"+name+"', '"+dept+"', "+roll+", "+age+")";
				
				stmt.executeUpdate(sql);
				System.out.println("Record is inserted successfully...");
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
