package Database;

import java.sql.*;
public class ConnessioneDatabase {

	// ATTRIBUTI
	private static ConnessioneDatabase instance;
	public Connection connection = null;
	public String nome = "postgres";
	public String password = "admin";
	public String url = "jdbc:postgresql://localhost:5432/Manabi";
	public String driver = "org.postgresql.Driver";
	String failed = "Connessione al Database fallita.";
	String success = "Connessione al Database effettuata con successo.";

	// COSTRUTTORE
	public ConnessioneDatabase() throws SQLException {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, nome, password);

		} catch (ClassNotFoundException ex) {
			System.out.println("Connessione al Database fallita: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	public Connection getConnection() {
			return connection;
	}
	
	public static ConnessioneDatabase getInstance() throws SQLException {
		if (instance == null) {
			instance = new ConnessioneDatabase();
		} else if (instance.getConnection().isClosed()) {
			instance = new ConnessioneDatabase();
		}
		return instance;
	}

}
