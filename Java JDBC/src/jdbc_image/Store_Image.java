package jdbc_image;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Store_Image {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		Scanner scan = new Scanner(System.in);
		String name = "";
		
		try {
			Class.forName(DRIVER);
			
			System.out.println("Connecting to Oracle Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection to Oracle Database successful...");
			
			System.out.println("Enter the name : ");	name = scan.next();
			String sql = "INSERT INTO IMGTABLE VALUES (?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(name));
			
			FileInputStream fin = new FileInputStream("C:\\Users\\achinta\\Pictures\\My Picture\\myPicture2.jpg");
			ps.setBinaryStream(2, fin, fin.available());
			ps.executeUpdate();
			System.out.println("Image is inserted successfully...");
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
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
