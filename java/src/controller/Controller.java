package controller;
import modelli.*;
import PostgresDAO.*;

import java.sql.SQLException;

import Database.*;

public class Controller {
	public String tmp;
	public Insegnante i = null;
	public Quesiti q;
	public Studente s = null;
	public Test t;
	public Risposta r;
	public Utente u;
	public ConnessioneDatabase connessione;
	
	public Controller() {
		u = new Utente();
	}
	
	public boolean checkConnection() throws SQLException {
		
		connessione = new ConnessioneDatabase();
		try {
			connessione.connection = ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(connessione.connection == null) return false;
		
		return true;
		
	}
	
	public void assignUsername(String s) {u.username = s;}
	
	public void assignPassword(String password) {u.password = password;}
	
	public void assignName(String name) {u.nome = name;}
	
	public void assignSurname(String surname) {u.cognome = surname;}
	
	public void assignMat(String materia) {tmp = materia;} //Salva la materia in una variabile temporanea}
	
	public void login(String username, String password) {
		
		InsegnanteDAO insegnanteDB = new InsegnanteDAO();		
		i = insegnanteDB.login(username, password);
		if(i != null) {return;} //Non c'è bisogno di aprire la connessione in studente, non esisterà un utente con medesime credenziali
		
		StudenteDAO studenteDB = new StudenteDAO();
		s = studenteDB.login(username, password);		
	}
	
	public void registraStudente() {}
	
	public boolean checkUsername() { //Controllo disponibilità dell'username
		String s = null, q = null;
		InsegnanteDAO insegnanteDB = new InsegnanteDAO();
		StudenteDAO studenteDB = new StudenteDAO();
		
		q = studenteDB.getUsername(u.username);
		if(q != null) return true;
		s = insegnanteDB.getUsername(u.username);
		if(s != null) return true;

		return false;
	}
	
	public void inizializzaInsegnante() {
		i = new Insegnante(u.username, u.password, u.nome, u.cognome);	
		InsegnanteDAO insegnanteDB = new InsegnanteDAO();
		insegnanteDB.insertInsegnante(i);
	}
	
	public void inizializzaStudente() {
		s = new Studente(u.username, u.password, u.nome, u.cognome);
		StudenteDAO studenteDB = new StudenteDAO();
		studenteDB.insertStudente(s);
	}

	public boolean checkTestId(Integer i) {
		
		TestDAO testDB = new TestDAO();
		
		if(i == testDB.getTestId(i)) return false;
		
		return true;
	}
	
	public void inizializzaTest() {
		TestDAO testDB = new TestDAO();
		testDB.insertTest(t);
	}

	public boolean checkQuizId(Integer i, boolean isOpen) {

		
		QuesitiDAO quesitiDB = new QuesitiDAO();
		
		if(i == quesitiDB.getQuizId(i, isOpen)) {return false;}
		
		return true;
	}
	
	public void inizializzaQuesito() {
		Quesiti q = new Quesiti();
	}
}
