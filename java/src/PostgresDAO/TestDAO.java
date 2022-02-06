package PostgresDAO;

import Database.ConnessioneDatabase;
import java.sql.*;
import modelli.*;

public class TestDAO {
	Test t;
	Connection connessione;
	
	public TestDAO() {
		try {
			connessione = ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			System.out.println("Connessione fallita.");
			e.printStackTrace();
		}
	}
	
	public Integer getTestId(Integer id) {
		PreparedStatement u;
		@SuppressWarnings("removal")
		Integer s = new Integer(-1);
		String cmp = String.valueOf(id);
		System.out.println(cmp);
		
		try {
			u = connessione.prepareStatement(
					"SELECT id_test FROM TEST WHERE id_test = "+cmp);
			
		ResultSet rs = u.executeQuery();
		while(rs.next()) {
			s = rs.getInt("id_test");
		}
		rs.close();
		
		return s;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return -1;

		}
	}

}
