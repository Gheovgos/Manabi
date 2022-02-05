package PostgresDAO;

import java.sql.*;
import modelli.*;

import Database.ConnessioneDatabase;


public class InsegnanteDAO {
	
	Insegnante i;
	Connection connessione;
	
	public InsegnanteDAO() {
		try {
			connessione = ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			System.out.println("Connessione fallita.");
			e.printStackTrace();
		}
	}
	
	public boolean Verifica() {
		if(connessione == null)
			return false;
		else
			return true;
	}
	
	public Insegnante login(String username, String password)
	{
		PreparedStatement login;
		try {
			login = connessione.prepareStatement(
					"SELECT * "
					+ "FROM Insegnante "
					+ "WHERE username_i ='"+username+"' AND password_i = '"+password+"'");
			
		ResultSet rs = login.executeQuery();
		while(rs.next()) {
			i = new Insegnante(rs.getString("Username_i"), rs.getString("password_i"), rs.getString("nome"), rs.getString("cognome"));

	
		}
		rs.close();
		return i;

		
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
					"SELECT username_i "
					+ "FROM Insegnante "
					+ "WHERE username_i ='"+username+"'");
			
		ResultSet rs = u.executeQuery();
		while(rs.next()) {
			s = rs.getString("username_i");
		}
		rs.close();
		return s;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
		
	}

	public void insertInsegnante(Insegnante i) {
		
		PreparedStatement insert;
		
		try {
			insert = connessione.prepareStatement(
					"INSERT INTO INSEGNANTE VALUES ('"+i.username+"','"+i.password+"','"+i.nome+"','"+i.cognome+"');");
			
		insert.executeUpdate();
		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();

		}
		
	}
	
}
