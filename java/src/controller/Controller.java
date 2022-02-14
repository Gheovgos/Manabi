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
	
	public boolean checkUsername(String username) { //Controllo disponibilità dell'username
		String s = null, q = null;
		InsegnanteDAO insegnanteDB = new InsegnanteDAO();
		StudenteDAO studenteDB = new StudenteDAO();
		
		q = studenteDB.getUsername(username);
		if(q != null) return true;
		s = insegnanteDB.getUsername(username);
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
	
	public void inizializzaQuesito(int idq, int idT, float pMin, float pMax, String d, String[] r, boolean isOpen) {
		q = new Quesiti(idq, idT, pMin, pMax, d, r, isOpen);
		QuesitiDAO quesitiDB = new QuesitiDAO();
		
		quesitiDB.insertQuesito(idq, idT, pMin, pMax, d, r, isOpen);
	
		
	}
	
	public String[] returnTestName(String username) {
		TestDAO testDB = new TestDAO();
		String[] rs = testDB.returnUnsolvedTestName(username);
		
		return rs;
				
	}
	
	public String[] returnTestName(String username, int a) {
		TestDAO testDB = new TestDAO();
		String[] rs = testDB.returnSolvedTestName(username);
		
		return rs;
				
	}
	
	public String[] returnAllTest(String username) {
		TestDAO testDB = new TestDAO();
		String[] rs = testDB.returnAllTest(username);
		
		return rs;
		
	}
	
	public void caricaTest(String nome_test, String username) {
		TestDAO testDB = new TestDAO();
		
		t = testDB.returnTest(nome_test, username);			
	}
	
	public void caricaTest(String nome_test) {
		TestDAO testDB = new TestDAO();
		
		t = testDB.returnTest(nome_test);			
	}

	public float ottieniPunteggioStudente(String username_s) {
		StudenteDAO studenteDB = new StudenteDAO();
		
		return studenteDB.getPunt(username_s);
		
	}
	
	public String[] returnCompTestName(String username) {
		TestDAO testDB = new TestDAO();
		String[] rs = testDB.returnCompTestName(username);
		
		return rs;
				
	}

	public void addCorrezione(String username_i, String username_s, int id) {
		TestDAO testDB = new TestDAO();
		
		testDB.aggiornaCorrezione(username_i, username_s, id);
	}
	
	public void caricaInsegnante(String username) {
		InsegnanteDAO insegnanteDB = new InsegnanteDAO();
		
		i = insegnanteDB.login(username);
	}
	
	public void caricaQuesitiTest(int idTest) {
		QuesitiDAO quesitiDB = new QuesitiDAO();
		int[] quantity;
		
		quantity = quesitiDB.getQuizId(idTest);
				
		t.quesiti = new Quesiti[quantity.length];
		
		for(int i = 0; i < quantity.length; i++) {
			t.quesiti[i] = quesitiDB.returnQuiz(quantity[i], idTest);	
		}
	}
	
	public void insertRisposta(int id_q, String risposta, boolean isOpen) {
		RispostaDAO rispostaDB = new RispostaDAO();
		if(isOpen) {rispostaDB.insertRisposta(id_q, s.username, i.username, risposta, isOpen);}
		else {rispostaDB.insertRisposta(id_q, s.username, i.username, risposta, isOpen);}
		
	}

	public void caricaStudente(String username) {
		StudenteDAO studenteDB = new StudenteDAO();
		
		s = studenteDB.login(username);
	}

	public String[] returnStudenti(int id) {
		String[] studenti;
		RispostaDAO rispostaDB = new RispostaDAO();
		
		studenti = rispostaDB.returnStudenti(id);
		
		return studenti;
	}

	public String caricaRisopsta(int idq, String username_s) {
		String risposta;
		RispostaDAO rispostaDB = new RispostaDAO();
		
		risposta = rispostaDB.returnRisposta(idq, username_s);
		
		return risposta;
	}

	public void updateRisposta(int id, String username, float punteggio, String commento) {
		RispostaDAO rispostaDB = new RispostaDAO();
		
		rispostaDB.updateRisposta(id, username, punteggio, commento);
		
	}

	public void aggiornaCorrezione(int id, String username) {
		RispostaDAO rispostaDB = new RispostaDAO();
		
		rispostaDB.updateCorrezione(id, username);
	}
	
	public boolean checkAlreadySolved(int id, String username) {
		TestDAO testDB = new TestDAO();
		return testDB.checkAlreadySolved(id, username);
	}

	public void updateTest() {
		TestDAO testDB = new TestDAO();
		testDB.updateTest(t.id, t.nomeTest, t.materia, t.descrizione);
	}
	
	public boolean hasQ() {
		TestDAO testDB = new TestDAO();
		if(testDB.hasQ(t.id)) return true;
		else return false;
	}
	
	public void aggiornaUtente(String password, String nome, String cognome, boolean who, String oldUsername) {
		InsegnanteDAO insegnanteDB = new InsegnanteDAO();
		
		if(who) insegnanteDB.aggiornaUtente(password, nome, cognome, who, oldUsername);
		else insegnanteDB.aggiornaUtente(password, nome, cognome, who, oldUsername);
	}

	public String[] returnAllTestName(String username) {
		TestDAO testDB = new TestDAO();
		String[] rs = testDB.returnAllTestName(username);
		
		return rs;
				
	}
	
	public String[] returnAllTestName() {
		TestDAO testDB = new TestDAO();
		String[] rs = testDB.returnAllTestName();
		
		return rs;
				
	}
	
	public String[] returnAllMat() {
		TestDAO testDB = new TestDAO();
		String[] rs = testDB.returnAllMat();
		
		return rs;
				
	}
	
	public float ottieniVotoTest(String username, int id) {
		TestDAO testDB = new TestDAO();
		
		return testDB.ottieniVotoTest(username, id);
	}
	
	public String ottieniUltimoTestSvolto(String username) {
		TestDAO testDB = new TestDAO();
		
		return testDB.ottieniUltimoTestSvolto(username);
	}
}
