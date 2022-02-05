package modelli;

import java.util.ArrayList;
import java.util.List;

public class Studente extends Utente{

float punteggioStudente, mediaVotiCat;
List<Test> testSvolti = new ArrayList<Test>();

public Studente(String u, String p, String n, String c) {
	username = u;
	password = p;
	nome = n;
	cognome = c;
}
	

}
