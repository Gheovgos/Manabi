package PostgresDAO;

import java.sql.*;
import java.util.ArrayList;

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
	
	
	public int[] getQuizId(int id) {
		PreparedStatement g;
		PreparedStatement h;
		int[] tmp = new int[100];
		int i = 0;
		
		try {
			g = connessione.prepareStatement(
					"SELECT id_a FROM QUESITO_APERTO WHERE id_test = "+id);
			
		ResultSet rs = g.executeQuery();
		for(; rs.next(); i++) {
			tmp[i] = rs.getInt("id_a");
		}
		
		rs.close();
		h = connessione.prepareStatement(
				"SELECT id_m FROM QUESITO_MULTIPLO WHERE id_test = "+id);
		
		ResultSet rm = h.executeQuery();
		for(; rm.next(); i++) {
			tmp[i] = rm.getInt("id_m");
		}
		
		rm.close();
		int[] result = new int[i];
		for(int j = 0; j < i; j++) {
			result[j] = tmp[j];
		}
		
		return result;
				
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
	}

	public Quesiti returnQuiz(int id_q, int id_test) {
		PreparedStatement g;
		Quesiti q = null;
		String[] r = new String[1];
		r[0] = "";
		
		if(checkIfOpen(id_q)) {
			
			try {
				g = connessione.prepareStatement(
						"SELECT * FROM QUESITO_APERTO WHERE id_a = "+id_q);
				
			ResultSet rs = g.executeQuery();
			while(rs.next()) {
				q = new  Quesiti(rs.getInt("id_a"), rs.getInt("id_test"), rs.getFloat("punteggio_min"), rs.getFloat("punteggio_max"), rs.getString("domanda"), r, true);
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
			
			try {
				g = connessione.prepareStatement(
						"SELECT * FROM QUESITO_MULTIPLO WHERE id_m = "+id_q);
				
			ResultSet rs = g.executeQuery();
			String[] risposte = getRisposteMul(id_q);
			
			while(rs.next()) {
				q = new  Quesiti(rs.getInt("id_m"), rs.getInt("id_test"), rs.getFloat("punteggio_errato"), rs.getFloat("punteggio_corretto"), rs.getString("domanda"), risposte, false);

			}				
			
			
			rs.close();
			return q;
			
			}
			catch (SQLException e) {
		
				e.printStackTrace();
				return null;

			}				
		}
					
	}
	
	public String[] getRisposteMul(int id_q) {
		String[] str = new String[5];
		PreparedStatement g;
		
		try {
			g = connessione.prepareStatement(
					"SELECT r_unoc, r_due, r_tre, r_quattro, r_cinque FROM QUESITO_MULTIPLO WHERE id_m = "+id_q);
			
		ResultSet rs = g.executeQuery();
		
		while(rs.next()) {
			str[0] = rs.getString("r_unoc"); str[1] = rs.getString("r_due"); str[2] = rs.getString("r_tre"); str[3] = rs.getString("r_quattro"); str[4] = rs.getString("r_cinque");
		}
		
		rs.close();
		return str;
		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}	
		
	}
	
	public boolean checkIfOpen(int id_q) {
		boolean isOpen;
		PreparedStatement g;
		
		
		try {
			g = connessione.prepareStatement("SELECT id_a FROM QUESITO_APERTO WHERE id_a = "+id_q);
			
		ResultSet rs = g.executeQuery();
		
		
		if(rs.next()) isOpen = true;
		else isOpen = false;
		
		rs.close();

		return isOpen;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return false;

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
