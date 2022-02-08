package PostgresDAO;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

	public void insertQuesito(int idq, int idT, float pMin, float pMax, String d, String[] r, boolean isOpen) {
		if(isOpen) {
			PreparedStatement insert;
			
				try {
					insert = connessione.prepareStatement(
							"INSERT INTO QUESITO_APERTO VALUES ('"+idq+"','"+idT+"','"+pMin+"', '"+pMax+"', '"+d+"');");
					
				insert.executeUpdate();
				return;
				
				} 
				catch (SQLException e) {
			
					e.printStackTrace();
					return;

				}
			
			}	
			else {
				
				PreparedStatement insert;
				
					try {
						insert = connessione.prepareStatement(
								"INSERT INTO QUESITO_MULTIPLO VALUES ('"+idq+"','"+idT+"','"+pMax+"', '"+pMin+"', '"+d+"', '"+r[0]+"','"+r[1]+"','"+r[2]+"','"+r[3]+"','"+r[4]+"');");
						
					insert.executeUpdate();
					return;
					
					} 
					catch (SQLException e) {
				
						e.printStackTrace();
						return;

					}
				
				}
				
			}

}
