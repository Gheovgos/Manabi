package modelli;

public class Quesiti {
	
public String domanda;
public int idQuesito, idTest;
public float punteggioMin, punteggioMax;
public String[] risposte;
public boolean isOpen;

public Quesiti (int idq, int idT, float pMin, float pMax, String d, String[] r, boolean isO) {
	isOpen = isO; 
	if(isO) {
		risposte = new String[0];
		idQuesito = idq; idTest = idT; punteggioMin = pMin; punteggioMax = pMax; domanda = d;}
	else {
		risposte = new String[5];
		idQuesito = idq; idTest = idT; punteggioMin = pMin; punteggioMax = pMax; domanda = d;
		for(int i = 0; i < r.length; i++) {
			risposte[i] = r[i];
		}
	  }
   }
}
