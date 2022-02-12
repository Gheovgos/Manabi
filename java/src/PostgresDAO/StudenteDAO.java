package PostgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.ConnessioneDatabase;
import modelli.*;

public class StudenteDAO {

	Studente s;
	Connection connessione;
	
	public StudenteDAO() {
		try {
			connessione = ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			System.out.println("Connessione fallita.");
			e.printStackTrace();
		}
	}
	
	public Studente login(String username, String password)
	{
		PreparedStatement login;
		try {
			login = connessione.prepareStatement(
					"SELECT * "
					+ "FROM Studente "
					+ "WHERE username_s ='"+username+"' AND password_s = '"+password+"'");
			
		ResultSet rs = login.executeQuery();
		while(rs.next()) {
			s = new Studente(rs.getString("Username_s"), rs.getString("password_s"), rs.getString("nome"), rs.getString("cognome"));

		}
		rs.close();
		return s;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
	}
	
	public Studente login(String username) {
		PreparedStatement login;
		try {
			login = connessione.prepareStatement(
					"SELECT * "
					+ "FROM Studente "
					+ "WHERE username_s ='"+username+"'");
			
		ResultSet rs = login.executeQuery();
		while(rs.next()) {
			s = new Studente(rs.getString("Username_s"), rs.getString("password_s"), rs.getString("nome"), rs.getString("cognome"));

		}
		rs.close();
		return s;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
	}


	public String getUsername(String username) {
		PreparedStatement u;
		String s = null;
		
		try {
			u = connessione.prepareStatement(
					"SELECT username_s "
					+ "FROM Studente "
					+ "WHERE username_s ='"+username+"'");
			
		ResultSet rs = u.executeQuery();
		while(rs.next()) {
			s = rs.getString("username_s");
		}
		rs.close();
		return s;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
		
	}

	
	public void insertStudente(Studente s) {
		
		PreparedStatement insert;
		
		try {
			insert = connessione.prepareStatement(
					"INSERT INTO STUDENTE VALUES ('"+s.username+"','"+s.password+"','"+s.nome+"','"+s.cognome+"');");
			
		insert.executeUpdate();	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public float getPunt(String username) {
		PreparedStatement u;
		float punteggio = 0;
		
		try {
			u = connessione.prepareStatement(
					"SELECT punteggio_tot "
					+ "FROM Studente "
					+ "WHERE username_s ='"+username+"'");
			
		ResultSet rs = u.executeQuery();
		while(rs.next()) {
			punteggio = rs.getFloat("punteggio_tot");
		}
		rs.close();
		return punteggio;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return 0;

		}
		
	}
}
