package controller;
import modelli.*;
import PostgresDAO.*;

public class Controller {
	public String tmp;
	public Insegnante i = null;
	public Quesiti q;
	public Studente s = null;
	public Test t;
	public Risposta r;
	public Utente u;
	
	public Controller() {
		u = new Utente();
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

	
	
	
	
}
