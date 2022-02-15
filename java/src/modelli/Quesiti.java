package modelli;

public class Quesiti {
	
private String domanda;
@SuppressWarnings("unused")
private int idQuesito, idTest;
private float punteggioMin, punteggioMax;
private String[] risposte;
private boolean isOpen;

public Quesiti (int idq, int idT, float pMin, float pMax, String d, String[] r, boolean isO) {
	setOpen(isO); 
	if(isO) {
		setRisposte(new String[0]);
		setIdQuesito(idq); idTest = idT; setPunteggioMin(pMin); setPunteggioMax(pMax); setDomanda(d);}
	else {
		setRisposte(new String[5]);
		setIdQuesito(idq); idTest = idT; setPunteggioMin(pMin); setPunteggioMax(pMax); setDomanda(d);
		for(int i = 0; i < r.length; i++) {
			getRisposte()[i] = r[i];
		}
	  }
   }

public String[] getRisposte() {
	return risposte;
}

public void setRisposte(String[] risposte) {
	this.risposte = risposte;
}

public boolean isOpen() {
	return isOpen;
}

public void setOpen(boolean isOpen) {
	this.isOpen = isOpen;
}

public String getDomanda() {
	return domanda;
}

public void setDomanda(String domanda) {
	this.domanda = domanda;
}

public int getIdQuesito() {
	return idQuesito;
}

public void setIdQuesito(int idQuesito) {
	this.idQuesito = idQuesito;
}

public float getPunteggioMin() {
	return punteggioMin;
}

public void setPunteggioMin(float punteggioMin) {
	this.punteggioMin = punteggioMin;
}

public float getPunteggioMax() {
	return punteggioMax;
}

public void setPunteggioMax(float punteggioMax) {
	this.punteggioMax = punteggioMax;
}
}
