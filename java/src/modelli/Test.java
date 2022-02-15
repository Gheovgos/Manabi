package modelli;

import java.util.Date;

public class Test {
	
	private Integer id;
	private String nomeTest, materia, creatoreTest, descrizione;
	private Date tempo;
    private Quesiti[] quesiti;
    
    public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Test(Integer i, String u, String n, String m, String d) {
    	setId(i); setCreatoreTest(u); setNomeTest(n); setMateria(m); setDescrizione(d); setTempo(new Date());
    	
    }

	public String getNomeTest() {
		return nomeTest;
	}

	public void setNomeTest(String nomeTest) {
		this.nomeTest = nomeTest;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Quesiti[] getQuesiti() {
		return quesiti;
	}

	public void setQuesiti(Quesiti[] quesiti) {
		this.quesiti = quesiti;
	}

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
		this.tempo = tempo;
	}

	public String getCreatoreTest() {
		return creatoreTest;
	}

	public void setCreatoreTest(String creatoreTest) {
		this.creatoreTest = creatoreTest;
	}
}