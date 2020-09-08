package jdbc_rowSet;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class Listener implements RowSetListener {

	public void rowSetChanged(RowSetEvent event) {
		System.out.println("RowSet Changed");
	}

	public void rowChanged(RowSetEvent event) {
		System.out.println("Cursor Changed");
	}

	public void cursorMoved(RowSetEvent event) {
		System.out.println("Cursor Moved");
	}

}
