package jdbc_image;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrive_Image {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(DRIVER);
			
			System.out.println("Connecting to Oracle Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection to Oracle Database successful...");
			
			String sql = "SELECT * FROM IMGTABLE";
			ps = conn.prepareStatement(sql );
			
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				Blob blob = res.getBlob(2);
				byte b[] = blob.getBytes(1, (int)blob.length());
				FileOutputStream fout = new FileOutputStream("C:\\Users\\achinta\\Pictures\\My Picture\\achinta.jpg");
				
				fout.write(b);
				fout.close();
			}
			System.out.println("ok");
			
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
