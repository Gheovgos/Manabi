Utente è padre di Studente e Insegnante. Questi due condividono gli attributi login, password, nome, cognome da Utente, NON hanno il metodo CreaUtente.

Studente ha un tipo, un punteggio, un collegamento coi test svolti (in un ArrayLIst di interi che si rifanno agli idTest di Test). In più ha due metodi, accedi test, che prende in input un oggetto test, e stampaRIsulati che stampa i risultati di uno o più test svolti.

Insegnante ha inoltre un tipo, un arrayList di interi che indicano i test creati dal professore e due metodi, CreaTest, che crea appunto un nuovo test, e CorreggiRisposta che prende in input una risposta di uno studente e il professore verifica la correttezza e assegna un eventuale punteggio



La classe test ha un identificativo rappresentato da un intero univoco, un tempo che indica il tempo massimo da dedicare al test, un arrayList di Quiz (oggetti) che compongono il test, un arrayList di stringhe indica gli studenti che hanno svolto il test (è collegato a LOGIN di Studente!!). Contiene il metodo CreaQuiz che crea un quiz senza risposte e il metodo AssegnaPunteggio che assegna, appunto, un punteggio ad uno studente che è stato coinvolto nel test e che ha svolto i quiz

La classe Quiz ha una stringa che indica la domanda, un punteggio minimo (anche negativo) da assegnare in caso di risposta errata, un punteggio massimo da assegnare in caso di risposta esatta (eventualmente si potrebbe inserire un metodo che calcoli assegni 0 come punteggio in caso di risposta nulla), una stringa che registra la risposta dello studente, una stringa che salvi il login dello studente coinvolto, un tipoQuiz che identifica il tipo di Quiz (a risposta aperta), e un identificativo Quiz. Contiene i metodi "Inserisci Risposta" che fa inserire la risposta di un utente (a risposta aperta), "VerificaRIsposta" che controlla il valore booleano della risposta, e il metodo CreaRisposta che crea le risposte per quel test.


La classe risposta ha una stringa che indica una eventuale risposta (vuota se il quiz è a risposta aperta), un valore booleano che ne indica la correttezza, un intero che si riferisce al quiz che lo ha generato. Inoltre contiene il metodo "AssignTrue" che assegna il valore booleano all'attributo isTrue in base alla correttezza della risposta.
