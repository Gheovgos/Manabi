package PostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Database.ConnessioneDatabase;
import modelli.Risposta;

public class RispostaDAO {
	
	Connection connessione;
	Risposta r;
	
	public RispostaDAO() {
		try {
			connessione = ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			System.out.println("Connessione fallita.");
			e.printStackTrace();
		}
	}


	public void insertRisposta(int id_q, String username_s, String username_i, String risposta, float punteggio, boolean isOpen) {
		if(isOpen) {
			PreparedStatement insert;
			
				try {
					insert = connessione.prepareStatement(
							"INSERT INTO RISPOSTA_APERTA VALUES "
							+ "('"+id_q+"','"+username_s+"','"+username_i+"', '"+risposta+"', ' ', '"+punteggio+"');");
					
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
								"INSERT INTO RISPOSTE_MULTIPLE VALUES "
										+ "('"+id_q+"','"+username_s+"', '"+risposta+"', NULL, '"+punteggio+"');");
						
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

