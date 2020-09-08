package jdbc_rowSet;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowsetDemo {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "achintamitra23";

	public static void main(String[] args) {
		
		try {
			Class.forName(DRIVER);
			int i = 1;
			
			JdbcRowSet row = RowSetProvider.newFactory().createJdbcRowSet();
			row.setUrl(DB_URL);
			row.setUsername(USER);
			row.setPassword(PASS);
			
			String sql = "SELECT * FROM STUDENT";
			row.setCommand(sql);
			row.execute();
			
			while (row.next()) {
				System.out.println("Display Student " + i);
				System.out.println("ID : " + row.getInt("id"));
				System.out.println("AGE : " + row.getInt("AGE"));
				System.out.println("ROLL : " + row.getInt("ROLL"));
				System.out.println("NAME : " + row.getString("NAME"));
				System.out.println("DEPT : " + row.getString("DEPT"));
				i++;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}

}
