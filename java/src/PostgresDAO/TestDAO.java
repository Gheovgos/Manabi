package PostgresDAO;

import Database.ConnessioneDatabase;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

	public void insertTest(Test t) {
		PreparedStatement insert;
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		if(t.tempo == null) {
			try {
				insert = connessione.prepareStatement(
						"INSERT INTO TEST(ID_TEST, USERNAME_I, NOME_TEST, MATERIA_TEST, DESCRIZIONE) VALUES ('"+t.id+"','"+t.creatoreTest+"','"+t.nomeTest+"', '"+t.materia+"', '"+t.descrizione+"');");
				
			insert.executeUpdate();
			return;
			
			} 
			catch (SQLException e) {
		
				e.printStackTrace();
				return;

			}
		}
			
		String time = df.format(t.tempo);
		
		try {
			insert = connessione.prepareStatement(
					"INSERT INTO TEST VALUES ('"+t.id+"','"+t.creatoreTest+"','"+t.nomeTest+"','"+time+"', '"+t.materia+"', '"+t.descrizione+"');");
			
		insert.executeUpdate();
		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();

		}
	}
	
	public String[] returnTestName(String username) {
		
		PreparedStatement g;
		String[] t = new String[100];
		int i;
		try {
			g = connessione.prepareStatement(
					"SELECT nome_test FROM TEST WHERE username_i = '"+username+"'");
			
		ResultSet rs = g.executeQuery();
		for(i = 0; rs.next(); i++) {
			t[i] = rs.getString("nome_test");
	
		}
		String[] tmp = new String[i];
		for(int z = 0; z < i; z++) {
			tmp[z] = t[z];
		}
		
		rs.close();
		return tmp;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
	}
	
	public String[] returnUnsolvedTestName(String username) {
		
		PreparedStatement g;
		String[] t = new String[100];
		int i;
		try {
			g = connessione.prepareStatement(
					"SELECT nome_test FROM TEST WHERE username_i = '"+username+"' AND id_test NOT IN (SELECT id_test FROM CORREZIONE WHERE username_i = '"+username+"')");
			
		ResultSet rs = g.executeQuery();
		for(i = 0; rs.next(); i++) {
			t[i] = rs.getString("nome_test");
	
		}
		String[] tmp = new String[i];
		for(int z = 0; z < i; z++) {
			tmp[z] = t[z];
		}
		
		rs.close();
		return tmp;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
	}
	
	public String[] returnSolvedTestName(String username) {
		
		PreparedStatement g;
		String[] t = new String[100];
		int i;
		try {
			g = connessione.prepareStatement(
					"SELECT nome_test FROM TEST WHERE username_i = '"+username+"' AND id_test IN (SELECT id_test FROM CORREZIONE WHERE username_i = '"+username+"')");
			
		ResultSet rs = g.executeQuery();
		for(i = 0; rs.next(); i++) {
			t[i] = rs.getString("nome_test");
	
		}
		String[] tmp = new String[i];
		for(int z = 0; z < i; z++) {
			tmp[z] = t[z];
		}
		
		rs.close();
		return tmp;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
	}

	public String[] returnCompTestName(String username) {
	
	PreparedStatement g;
	int i;
	int[] id = new int[100];
	try {
		g = connessione.prepareStatement(
				"SELECT id_test from test\r\n"
				+ "EXCEPT\r\n"
				+ "SELECT id_test from correzione WHERE\r\n"
				+ "username_s = '"+username+"';");
		
	ResultSet rs = g.executeQuery();
	for(i = 0; rs.next(); i++) {
		id[i] = rs.getInt("id_test");

	}
	
	String[] tmp = new String[i];
	
	for(int j = 0; j < i; j++) {
		g = connessione.prepareStatement(
				"SELECT nome_test FROM TEST WHERE id_test ="+id[j]);
		rs = g.executeQuery();
		while(rs.next()) {
			tmp[j] = rs.getString("nome_test");
		}
		
	}
	
	rs.close();
	return tmp;

	
	} 
	catch (SQLException e) {

		e.printStackTrace();
		return null;

	}
}
		
	

	public Test returnTest(String nome_test, String username) {
		PreparedStatement g;
		Test t = null;
		Time time;
		try {
			g = connessione.prepareStatement(
					"SELECT *"
					+ "FROM TEST "
					+ "WHERE username_i ='"+username+"' AND nome_test = '"+nome_test+"'");
			
		ResultSet rs = g.executeQuery();
		while(rs.next()) {
			t = new Test(rs.getInt("id_test"), rs.getString("username_i"), rs.getString("nome_test"), rs.getString("materia_test"), rs.getString("descrizione"));
			time = rs.getTime("tempo_svolgimento"); 
			if(time != null) {
				String tmp = time.toString();
				
				DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
				try {
					t.tempo = sdf.parse(tmp);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			else {
				String tmp = "00:00:00";
				
				DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
				try {
					t.tempo = sdf.parse(tmp);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

	
		}
		rs.close();
		return t;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
	}

	public Test returnTest(String nome_test) {
		PreparedStatement g;
		Test t = null;
		Time time;
		try {
			g = connessione.prepareStatement(
					"SELECT *"
					+ "FROM TEST "
					+ "WHERE nome_test = '"+nome_test+"'");
			
		ResultSet rs = g.executeQuery();
		while(rs.next()) {
			t = new Test(rs.getInt("id_test"), rs.getString("username_i"), rs.getString("nome_test"), rs.getString("materia_test"), rs.getString("descrizione"));
			time = rs.getTime("tempo_svolgimento"); 
			if(time != null) {
				String tmp = time.toString();
				
				DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
				try {
					t.tempo = sdf.parse(tmp);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			else {
				String tmp = "00:00:00";
				
				DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
				try {
					t.tempo = sdf.parse(tmp);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
	
		}
		rs.close();
		return t;

		
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
			return null;

		}
	}
	
	public void aggiornaCorrezione(String username_i, String username_s, int id) {
		
		PreparedStatement insert;
		
		
			try {
				insert = connessione.prepareStatement(
						"INSERT INTO CORREZIONE VALUES ('"+username_i+"','"+username_s+"','"+id+"');");
				
			insert.executeUpdate();
			return;
			
			} 
			catch (SQLException e) {
		
				e.printStackTrace();
				return;

			}
		
		
	}
}
