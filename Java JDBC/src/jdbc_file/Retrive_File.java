package jdbc_file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrive_File {
	
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
			
			String sql = "SELECT * FROM FILETABLE";
			ps = conn.prepareStatement(sql );
			
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				Clob clob = res.getClob(2);
				Reader read = clob.getCharacterStream();
				
				FileWriter fw = new FileWriter("F:\\Hello.txt");
				int i;
				while ((i = read.read()) != -1) 	fw.write((char)i);
				fw.close();
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
