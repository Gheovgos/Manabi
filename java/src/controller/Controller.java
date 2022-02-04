package controller;
import modelli.*;

public class Controller {
	public String tmp;
	public Insegnante i;
	public Quesiti q;
	public Studente s;
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
	
	

}
