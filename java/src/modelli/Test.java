package modelli;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
	
	public Integer id;
	public String nomeTest, materia, creatoreTest, descrizione;
	public Date tempo;
    List<Quesiti> quesitiTot = new ArrayList<Quesiti>();
    List<Studente> studentiCoinvolti = new ArrayList<Studente>();
    
    public Test(Integer i, String u, String n, String m, String d) {
    	id = i; creatoreTest = u; nomeTest = n; materia = m; descrizione = d;
    	
    }
}
