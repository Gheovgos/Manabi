package modelli;

import java.util.Date;

public class Test {
	
	public Integer id;
	public String nomeTest, materia, creatoreTest, descrizione;
	public Date tempo;
    public Quesiti[] quesiti;
    
    public Test(Integer i, String u, String n, String m, String d) {
    	id = i; creatoreTest = u; nomeTest = n; materia = m; descrizione = d; tempo = new Date();
    	
    }
}