package modelli;

import java.util.ArrayList;
import java.util.List;

public class Quesiti {
	
public String domanda;
public int idQuesito, idTest;
public float punteggioMin, punteggioMax;
public ArrayList<String> risposte;

public Quesiti (int idq, int idT, float pMin, float pMax, String d, String[] r, boolean isOpen) {
	risposte = new ArrayList<String>();
	if(isOpen) {
		risposte.add("");
		idQuesito = idq; idTest = idT; punteggioMin = pMin; punteggioMax = pMax; domanda = d; }
	else {
		idQuesito = idq; idTest = idT; punteggioMin = pMin; punteggioMax = pMax; domanda = d;
		for(int i = 0; i < r.length; i++) {
			risposte.add(i, r[i]);
		}
	}
}

}
