package PostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.ConnessioneDatabase;


public class RispostaDAO {
	
	private Connection connessione;

	
	public RispostaDAO() {
		try {
			connessione = ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			System.out.println("Connessione fallita.");
			e.printStackTrace();
		}
	}


	public void insertRisposta(int id_q, String username_s, String username_i, String risposta, boolean isOpen) {
		if(isOpen) {
			PreparedStatement insert;
			
				try {
					insert = connessione.prepareStatement(
							"INSERT INTO RISPOSTA_APERTA VALUES "
							+ "('"+id_q+"','"+username_s+"','"+username_i+"', '"+risposta+"', ' ', '0');");
					
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
				PreparedStatement g;
				PreparedStatement update;
				String ris = "";
				boolean isCorrect;
				float puntMax = 0, puntMin = 0;
				
				try {
					g = connessione.prepareStatement("SELECT r_unoc, punteggio_corretto, punteggio_errato FROM QUESITO_MULTIPLO WHERE id_m = "+id_q);
					
				ResultSet rs = g.executeQuery();
				while(rs.next()) {
					ris = rs.getString("r_unoc"); puntMax = rs.getFloat("punteggio_corretto"); puntMin = rs.getFloat("punteggio_errato");
				}
				
				rs.close();	} 
				catch (SQLException e) {			
					e.printStackTrace();
					return; }
				
				if(risposta.equals(ris)) isCorrect = true;
				else isCorrect = false;
				
				if(isCorrect) {
					try {
						insert = connessione.prepareStatement(
								"INSERT INTO RISPOSTE_MULTIPLE VALUES "
								+ "('"+id_q+"','"+username_s+"', '"+risposta+"', TRUE, '"+puntMax+"');");
						update = connessione.prepareStatement(
								"UPDATE CORREZIONE SET voto_test = voto_test + "+puntMax+" WHERE id_test = "+id_q+" AND username_s = '"+username_s+"'");
					
					update.executeUpdate();
					insert.executeUpdate();
					return; } 
					catch (SQLException e) {
				
						e.printStackTrace();
						return; }
				}
				else {
					try {
						insert = connessione.prepareStatement(
								"INSERT INTO RISPOSTE_MULTIPLE VALUES "
								+ "('"+id_q+"','"+username_s+"', '"+risposta+"', FALSE, '"+puntMin+"');");
						update = connessione.prepareStatement(
								"UPDATE CORREZIONE SET voto_test = voto_test + "+puntMin+" WHERE id_test = "+id_q+" AND username_s = '"+username_s+"'");
					
					update.executeUpdate();
						
					insert.executeUpdate();
					return; } 
					catch (SQLException e) {
				
						e.printStackTrace();
						return; }
				}
			}
	}

	public String[] returnStudenti(int id) {
		String[] studenti = new String[50];
		PreparedStatement g;
		
		int i;
		try {
			g = connessione.prepareStatement(
					"SELECT username_s FROM CORREZIONE WHERE id_test = "+id+" AND corretto = FALSE");
			
		ResultSet rs = g.executeQuery();
		for(i = 0; rs.next(); i++) {
			studenti[i] = rs.getString("username_s");
	
		}
		if(i == 0) {i = 2;}
		String[] tmp = new String[i];
		for(int j = 0; j < i; j++) {
			tmp[j] = studenti[j];
		}
		
		rs.close();
		return tmp;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
	}

	public String returnRisposta(int id_q, String username) {
		String risposta = "";
		PreparedStatement g;
		try {
			g = connessione.prepareStatement(
					"SELECT risposta_data FROM RISPOSTA_APERTA WHERE idr_a = "+id_q+" AND username_s = '"+username+"'");
			
		ResultSet rs = g.executeQuery();
		while(rs.next()) {
			risposta = rs.getString("risposta_data");
	
		}
		rs.close();
		return risposta;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
		
	}

	public void updateRisposta(int id, String username, float punteggio, String commento) {
		PreparedStatement update;
		
		try {
			update = connessione.prepareStatement(
					"UPDATE risposta_aperta SET punteggio_risa = "+punteggio+", commento = '"+commento+"' WHERE idr_a = "+id+" AND username_s = '"+username+"'");
			
		update.executeUpdate();
		update = connessione.prepareStatement(
				"UPDATE CORREZIONE SET voto_test = voto_test + "+punteggio+" WHERE id_test = "+id+" AND username_s = '"+username+"'");
		
		update.executeUpdate();
		return;
		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return;

		}
	}
	
	public void updateCorrezione(int id, String username) {
		PreparedStatement update;
		PreparedStatement get;
		float punteggio = 0;
		
		try {
			update = connessione.prepareStatement(
					"UPDATE CORREZIONE SET corretto = TRUE WHERE id_test = "+id+" AND username_s = '"+username+"'");
			get = connessione.prepareStatement("SELECT voto_test FROM CORREZIONE WHERE id_test = "+id+" AND username_s = '"+username+"'");
			
		ResultSet rs = get.executeQuery();
		while(rs.next()) {
			punteggio = rs.getFloat("voto_test");
		}
		update.executeUpdate();
		update = connessione.prepareStatement(
				"UPDATE STUDENTE SET corretto = TRUE, punteggio_tot = "+punteggio+" WHERE id_test = "+id+" AND username_s = '"+username+"'");
		return;
		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return;

		}
	}
	
}

