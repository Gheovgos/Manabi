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

	public Quesiti returnQuiz(int id, boolean isOpen) {
		PreparedStatement g;
		Quesiti q = null;
		
		if(isOpen) {
			String[] r = new String[0];
			r[0] = "";
			
			try {
				g = connessione.prepareStatement(
						"SELECT * FROM QUESITO_APERTO WHERE id_test = "+id);
				
			ResultSet rs = g.executeQuery();
			while(rs.next()) {
				q = new Quesiti(rs.getInt("id_a"), rs.getInt("id_test"), rs.getFloat("punteggio_min"), rs.getFloat("punteggio_max"), rs.getString("domanda"), r ,isOpen);

		
			}
			rs.close();
			return q;

			
			} 
			catch (SQLException e) {
		
				e.printStackTrace();
				return null;

			}
			
		}
		else {
			return null;
		}
	}

	public int nQuizA(int id) {
		PreparedStatement g;
		int n = 0;
		
		try {
			g = connessione.prepareStatement(
					"select count(id_test) from quesito_aperto where id_test = "+id);
			
		ResultSet rs = g.executeQuery();
		while(rs.next()) {
			n = rs.getInt("count");

	
		}
		rs.close();
		return n;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return 0;

		}
		
	}
	
	public int nQuizM(int id) {
		PreparedStatement g;
		int n = 0;
		
		try {
			g = connessione.prepareStatement(
					"select count(id_test) from quesito_multiplo where id_test = "+id);
			
		ResultSet rs = g.executeQuery();
		while(rs.next()) {
			n = rs.getInt("count");

	
		}
		rs.close();
		return n;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return 0;

		}
		
	}
}
