package controller;
import modelli.*;
import PostgresDAO.*;

import java.sql.SQLException;

import Database.*;

public class Controller {
	private Insegnante i = null;
	@SuppressWarnings("unused")
	private Quesiti q;
	private Studente s = null;
	private Test t;
	private Utente u;
	private ConnessioneDatabase connessione;
	
	public Controller() {
		setU(new Utente());
	}
	
	public boolean checkConnection() throws SQLException {
		
		setConnessione(new ConnessioneDatabase());
		try {
			getConnessione().setConnection(ConnessioneDatabase.getInstance().getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(getConnessione().getConnection() == null) return false;
		
		return true;
		
	}
	
	public void assignUsername(String s) {getU().username = s;}
	
	public void assignPassword(String password) {getU().password = password;}
	
	public void assignName(String name) {getU().nome = name;}
	
	public void assignSurname(String surname) {getU().cognome = surname;}
		
	public void login(String username, String password) {
		
		InsegnanteDAO insegnanteDB = new InsegnanteDAO();		
		setI(insegnanteDB.login(username, password));
		if(getI() != null) {return;} //Non c'è bisogno di aprire la connessione in studente, non esisterà un utente con medesime credenziali
		
		StudenteDAO studenteDB = new StudenteDAO();
		setS(studenteDB.login(username, password));		
	}
	
	
	public boolean checkUsername() { //Controllo disponibilità dell'username
		String s = null, q = null;
		InsegnanteDAO insegnanteDB = new InsegnanteDAO();
		StudenteDAO studenteDB = new StudenteDAO();
		
		q = studenteDB.getUsername(getU().username);
		if(q != null) return true;
		s = insegnanteDB.getUsername(getU().username);
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
		setI(new Insegnante(getU().username, getU().password, getU().nome, getU().cognome));	
		InsegnanteDAO insegnanteDB = new InsegnanteDAO();
		insegnanteDB.insertInsegnante(getI());
	}
	
	public void inizializzaStudente() {
		setS(new Studente(getU().username, getU().password, getU().nome, getU().cognome));
		StudenteDAO studenteDB = new StudenteDAO();
		studenteDB.insertStudente(getS());
	}

	public boolean checkTestId(Integer i) {
		
		TestDAO testDB = new TestDAO();
		
		if(i == testDB.getTestId(i)) return false;
		
		return true;
	}
	
	public void inizializzaTest() {
		TestDAO testDB = new TestDAO();
		testDB.insertTest(getT());
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
		
		setT(testDB.returnTest(nome_test, username));			
	}
	
	public void caricaTest(String nome_test) {
		TestDAO testDB = new TestDAO();
		
		setT(testDB.returnTest(nome_test));			
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
		
		setI(insegnanteDB.login(username));
	}
	
	public void caricaQuesitiTest(int idTest) {
		QuesitiDAO quesitiDB = new QuesitiDAO();
		int[] quantity;
		
		quantity = quesitiDB.getQuizId(idTest);
				
		getT().setQuesiti(new Quesiti[quantity.length]);
		
		for(int i = 0; i < quantity.length; i++) {
			getT().getQuesiti()[i] = quesitiDB.returnQuiz(quantity[i], idTest);	
		}
	}
	
	public void insertRisposta(int id_q, String risposta, boolean isOpen) {
		RispostaDAO rispostaDB = new RispostaDAO();
		if(isOpen) {rispostaDB.insertRisposta(id_q, getS().username, getI().username, risposta, isOpen);}
		else {rispostaDB.insertRisposta(id_q, getS().username, getI().username, risposta, isOpen);}
		
	}

	public void caricaStudente(String username) {
		StudenteDAO studenteDB = new StudenteDAO();
		
		setS(studenteDB.login(username));
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
		testDB.updateTest(getT().getId(), getT().getNomeTest(), getT().getMateria(), getT().getDescrizione());
	}
	
	public boolean hasQ() {
		TestDAO testDB = new TestDAO();
		if(testDB.hasQ(getT().getId())) return true;
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

	public Insegnante getI() {
		return i;
	}

	public void setI(Insegnante i) {
		this.i = i;
	}

	public Studente getS() {
		return s;
	}

	public void setS(Studente s) {
		this.s = s;
	}

	public Test getT() {
		return t;
	}

	public void setT(Test t) {
		this.t = t;
	}

	public Utente getU() {
		return u;
	}

	public void setU(Utente u) {
		this.u = u;
	}

	public ConnessioneDatabase getConnessione() {
		return connessione;
	}

	public void setConnessione(ConnessioneDatabase connessione) {
		this.connessione = connessione;
	}
}
