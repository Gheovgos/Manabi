package PostgresDAO;

import java.sql.*;

import Database.ConnessioneDatabase;
import modelli.*;

public class QuesitiDAO {
	
	Connection connessione;
	Quesiti q;
	
	public QuesitiDAO() {
		try {
			connessione = ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			System.out.println("Connessione fallita.");
			e.printStackTrace();
		}
	}

	public Integer getQuizId(Integer id, boolean isOpen) {
		PreparedStatement u;
		@SuppressWarnings("removal")
		Integer s = new Integer(-1);
		String cmp = String.valueOf(id);
		
		if(isOpen) {
			try {
				u = connessione.prepareStatement(
						"SELECT id_a FROM QUESITO_APERTO WHERE id_a = "+cmp);
				
			ResultSet rs = u.executeQuery();
			while(rs.next()) {
				s = rs.getInt("id_a");
			}
			rs.close();
			
			return s;

			
			} 
			catch (SQLException e) {
		
				e.printStackTrace();
				return -1;

			}
		}
		else {
			try {
				u = connessione.prepareStatement(
						"SELECT id_m FROM QUESITO_MULTIPLO WHERE id_m = "+cmp);
				
			ResultSet rs = u.executeQuery();
			while(rs.next()) {
				s = rs.getInt("id_m");
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
}
