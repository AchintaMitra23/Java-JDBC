package jdbc_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Store_File {
	
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
			
			System.out.println("Connecting to Oracle Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection to Oracle Database successful...");
			
			System.out.println("Enter the id : "); 		id = scan.nextInt();
			String sql = "INSERT INTO FILETABLE VALUES (?, ?)";
			ps = conn.prepareStatement(sql);
			
			File file = new File("F:\\Hello.txt");
			FileReader read = new FileReader(file);
			
			ps.setInt(1, id);
			ps.setCharacterStream(2, read, (int)file.length());
			ps.executeUpdate();
			System.out.println("File is inserted successfully...");
			
		} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
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
