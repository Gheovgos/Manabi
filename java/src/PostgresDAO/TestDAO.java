package PostgresDAO;

import Database.ConnessioneDatabase;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
}
