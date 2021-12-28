README Manabi
DBMS: PostgreSQL 10 con pgAdmin 4.
Il file SQL è stato ideato per essere inserito in un DB vuoto con un comando "Restore" in pgAdmin.

Di seguito riportati i commenti al codice SQL\PLPGSQL

BREVE INDICE

RIGA 15-129 CREAZIONE TABELLE

RIGA 130-658 VINCOLI E PROCEDURE

RIGA 651-710 VISTE



--------------------------------------------------------------------------------------------
CREAZIONE TABELLE

```SQL
CREATE TABLE INSEGNANTE(
USERNAME_I VARCHAR(25) NOT NULL,
PASSWORD_I VARCHAR(25) NOT NULL,
NOME VARCHAR(25),
COGNOME VARCHAR(25),
PRIMARY KEY (USERNAME_I)
);
```
Tabella contenente varie stringhe di 25 caratteri (scelta una grandezza fittizia)

```SQL
CREATE TABLE STUDENTE(
	USERNAME_S VARCHAR(25) NOT NULL,
	PASSWORD_S VARCHAR(25) NOT NULL,
	NOME VARCHAR(25),
	COGNOME VARCHAR(25),
	PUNTEGGIO_TOT FLOAT DEFAULT 0,
PRIMARY KEY (USERNAME_S)
);
```

Tabella contenente varie stringhe di 25 caratteri (scelta una grandezza fittizia) e un float

```SQL
CREATE TABLE TEST(
    ID_TEST INT NOT NULL,
    USERNAME_I VARCHAR(25) NOT NULL,
    NOME_TEST VARCHAR(25) NOT NULL,
    TEMPO_SVOLGIMENTO TIME,
    MATERIA_TEST VARCHAR(25),
    DESCRIZIONE VARCHAR(100) DEFAULT ‘Nessuna descrizione.’,
PRIMARY KEY (ID_TEST),	
FOREIGN KEY (USERNAME_I) REFERENCES INSEGNANTE (USERNAME_I)
);
```
Tabella per il test. Il tipo TIME è stato perlopiù sperimentale, dato che è stata la prima volta con cui ci siamo interfacciati con 
questo tipo di dato.
```SQL
 CREATE TABLE CORREZIONE(
    USERNAME_I VARCHAR(25) NOT NULL,
    USERNAME_S VARCHAR(25) NOT NULL,
    ID_TEST INT NOT NULL,
    CORRETTO BOOLEAN DEFAULT FALSE,
    VOTO_TEST FLOAT DEFAULT 0,
PRIMARY KEY (USERNAME_I, USERNAME_S, ID_TEST),	
FOREIGN KEY (USERNAME_I) REFERENCES INSEGNANTE (USERNAME_I),
FOREIGN KEY (USERNAME_S) REFERENCES STUDENTE (USERNAME_S),
FOREIGN KEY (ID_TEST) REFERENCES TEST (ID_TEST)
);
```
Tabella contenente tutte le informazioni utili per la relazione test-insegnante-studente. Da qui si possono dedurre tutti i partecipanti 
ad un test, tutti i voti, tutti i professori che hanno creato un test, i voti assegnati. I primi tre attributi formano la chiave primaria.
```SQL
CREATE TABLE QUESITO_APERTO(
    ID_A INT NOT NULL,
    ID_TEST INT NOT NULL,
    PUNTEGGIO_MIN FLOAT NOT NULL,	
    PUNTEGGIO_MAX FLOAT NOT NULL,
    DOMANDA VARCHAR(50) NOT NULL,
PRIMARY KEY (ID_A),
FOREIGN KEY (ID_TEST) REFERENCES TEST (ID_TEST)	
);
```
Tabella contenente le informazioni utili per un quesito aperto.

```SQL
CREATE TABLE RISPOSTA_APERTA(
	IDR_A INT NOT NULL,
	USERNAME_S VARCHAR(25) NOT NULL,
	USERNAME_I VARCHAR(25) NOT NULL,
	RISPOSTA_DATA VARCHAR(200),
	COMMENTO VARCHAR(200) DEFUALT ‘Nessun commento.’,
	PUNTEGGIO_RISA FLOAT DEFAULT 0,
PRIMARY KEY (IDR_A, USERNAME_S),
FOREIGN KEY (USERNAME_S) REFERENCES STUDENTE (USERNAME_S),
FOREIGN KEY (USERNAME_I) REFERENCES INSEGNANTE (USERNAME_I),
FOREIGN KEY (IDR_A) REFERENCES QUIZ_APERTO (ID_A)
);
```

Tabella contenente informazioni riguardante le risposte degli utenti. Abbiamo deciso di usare la chiave esterna + username come chiave
primaria per accentuare il legame con i quesiti e l'utente. Vale lo stesso ragionamento con le risposte multiple.

```SQL
CREATE TABLE QUESITO_MULTIPLO(
	ID_M INT NOT NULL,
	ID_TEST INT NOT NULL,
	PUNTEGGIO_CORRETTO FLOAT NOT NULL,
	PUNTEGGIO_ERRATO FLOAT NOT NULL,
	DOMANDA VARCHAR(200) NOT NULL,
	R_UNOC VARCHAR(50) NOT NULL,
	R_DUE VARCHAR(50) NOT NULL,
	R_TRE VARCHAR(50),
	R_QUATTRO VARCHAR(50),
	R_CINQUE VARCHAR(50),
PRIMARY KEY (ID_M),
FOREIGN KEY (ID_TEST) REFERENCES TEST (ID_TEST)
```
Tabella contenente informazioni per i quesiti aperti. La risposta uno è sempre quella corretta, nell'applicativo dovrà essere messo
in posizione casuale. Risposta tre, quattro e cinque saranno invece potenzialmente null per ridurre le risposte possibili ad un test.

```SQL
CREATE TABLE RISPOSTE_MULTIPLE(
	IDR_M INT NOT NULL,
	USERNAME_S VARCHAR(25) NOT NULL,
	RISPOSTA_DATA VARCHAR(50) NOT NULL,
	CORRETTA BOOLEAN,
	PUNTEGGIO_RM FLOAT DEFAULT 0,
PRIMARY KEY (IDR_M, USERNAME_S),
FOREIGN KEY (IDR_M) REFERENCES QUIZ_MULTIPLO (ID_M),
FOREIGN KEY (USERNAME_S) REFERENCES STUDENTE (USERNAME_S)
);	
```
Informazioni utili per le risposte multiple date dagli utenti.

--------------------------------------------------------------------------------------------
VINCOLI
```SQL
    ALTER TABLE QUIZ_APERTO 
    ADD CONSTRAINT controllo_pa CHECK (PUNTEGGIO_MIN<PUNTEGGIO_MAX);
```   
Controllo che il punteggio minimo di quesito aperto non superi il punteggio massimo.


```SQL
ALTER TABLE QUIZ_MULTIPLO
ADD CONSTRAINT controllo_pm1 CHECK (PUNTEGGIO_CORRETTO>PUNTEGGIO_ERRATO),
ADD CONSTRAINT controllo_pm2 CHECK (PUNTEGGIO_CORRETTO>0),
ADD CONSTRAINT controllo_pm3 CHECK (PUNTEGGIO_ERRATO<=0)
```
Controllo che il punteggio corretto non sia inferiore a punteggio errato e inoltre si controlla se il primo sia positivo e il secondo non positivo.

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION controllo_tempo() RETURNS TRIGGER AS $controllo_tempo$
DECLARE 
tempo TIME;
BEGIN
SELECT TEST.TEMPO_SVOLGIMENTO INTO tempo
FROM TEST
WHERE TEST.TEMPO_SVOLGIMENTO = NEW.TEMPO_SVOLGIMENTO;

    IF(tempo < '00:15:00' AND tempo IS NOT NULL) THEN
	RAISE EXCEPTION 'Tempo insufficiente per svolgere il test.'
		USING HINT = 'Prova ad assegnare maggior tempo (>= 15 min)';
		END IF;
RETURN NULL;
END;

$controllo_tempo$ LANGUAGE PLPGSQL;

CREATE TRIGGER CONTROLLO_TEMPO AFTER INSERT OR UPDATE OF TEMPO_SVOLGIMENTO
ON TEST
FOR EACH ROW EXECUTE PROCEDURE controllo_tempo();
```

Si controlla che il tempo non sia null e che sia almeno di 15 minuti. Non siamo sicuri sulla gestione del tipo TIME, la documentazio
la documentazione ci ha riferimtno che viene trattato come una stringa di tale formato: 'hh:mm:ss'.

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION controllo_lunghezza_stu() RETURNS TRIGGER AS $controllo_lunghezza_stu$
DECLARE
username STUDENTE.USERNAME_S%TYPE;
NOME STUDENTE.NOME%TYPE;
COGNOME STUDENTE.COGNOME%TYPE;
BEGIN

	SELECT STUDENTE.USERNAME_S, STUDENTE.NOME, STUDENTE.COGNOME INTO username
	FROM STUDENTE
	WHERE STUDENTE.USERNAME_S = NEW.USERNAME_S AND STUDENTE.NOME = NEW.NOME AND STUDENTE.COGNOME = NEW.COGNOME;
	
	IF(LENGTH(username) < 8) THEN
		RAISE EXCEPTION 'Username non valido'
		USING HINT = 'Prova a inserire un username più lungo';
	END IF;
	IF(LENGTH(nome) < 2 OR LENGTH(cognome) < 2) THEN
		RAISE EXCEPTION 'Nome o cognome non valido'
		USING HINT = 'Prova a inserire un nome e cognome vero!';
	END IF;
RETURN NULL;
END;

$controllo_lunghezza_stu$ LANGUAGE PLPGSQL;


CREATE TRIGGER CONTROLLO_CREDENZIALI_STUDENTE AFTER INSERT
ON STUDENTE
FOR EACH ROW EXECUTE PROCEDURE controllo_lunghezza_stu();
```

Si controlla che l'username, il nome e il cognome di uno studente siano almeno di 8 caratteri.

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION controllo_lunghezza_ins() RETURNS TRIGGER AS $controllo_lunghezza_ins$
DECLARE
username INSEGNANTE.USERNAME_I%TYPE;
password_i INSEGNANTE.PASSWORD_I%TYPE;
nome INSEGNANTE.NOME%TYPE;
cognome INSEGNANTE.COGNOME%TYPE;
BEGIN

	SELECT INSEGNANTE.USERNAME_I, INSEGNANTE.PASSWORD_I, INSEGNANTE.NOME, INSEGNANTE.COGNOME INTO
	username, password_i, nome, cognome
	FROM INSEGNANTE
	WHERE INSEGNANTE.USERNAME_I = NEW.USERNAME_I AND INSEGNANTE.PASSWORD_I = NEW.PASSWORD_I AND
	INSEGNANTE.NOME = NEW.NOME AND INSEGNANTE.COGNOME = NEW.COGNOME;
	
	IF(LENGTH(username) < 8 OR LENGTH(password_i) < 8) THEN
		RAISE EXCEPTION 'Username non valido'
		USING HINT = 'Prova a inserire un username più lungo';
	END IF;
	IF(LENGTH(nome) < 2 OR LENGTH(cognome) < 2) THEN
		RAISE EXCEPTION 'Nome o cognome non valido'
		USING HINT = 'Prova a inserire un nome e cognome vero!';
	END IF;
RETURN NULL;
END;

$controllo_lunghezza_ins$ LANGUAGE PLPGSQL;


CREATE TRIGGER CONTROLLO_CREDENZIALI_INSEGNANTE AFTER INSERT
ON INSEGNANTE
FOR EACH ROW EXECUTE PROCEDURE controllo_lunghezza_ins();
```

Stessa identica funzione di sopra, ma dato che su plpgsql ai trigger\funzioni non si possono passare parametri, abbiamo sdoppiato
la funzione per i due tipi di utente. Si procede analogamente per la password

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION verifica_ipassword() RETURNS TRIGGER AS $verifica_ipassword$
DECLARE
pass insegnante.password_i%type;
BEGIN
	SELECT INSEGNANTE.PASSWORD_I INTO pass
	FROM INSEGNANTE
	WHERE INSEGNANTE.PASSWORD_I = NEW.PASSWORD_I;

	IF(LENGTH(pass) < 8) THEN
	RAISE EXCEPTION 'Password % non valida', pass
		USING HINT = 'Prova a inserire una password più lunga!';
	END IF;
RETURN NULL;
END;

$verifica_ipassword$ LANGUAGE PLPGSQL;


CREATE TRIGGER VERIFICA_IPASSWORD AFTER INSERT
ON INSEGNANTE
FOR EACH ROW EXECUTE PROCEDURE verifica_ipassword();
```

Si controlla che la password dell'insegnante sia almeno di 8 caratteri.

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION verifica_spassword() RETURNS TRIGGER AS $verifica_spassword$
DECLARE
spassword STUDENTE.PASSWORD_S%TYPE;
BEGIN
	SELECT PASSWORD_S INTO spassword
	FROM STUDENTE
	WHERE STUDENTE.PASSWORD_S = NEW.PASSWORD_S;
	
	IF(LENGTH(spassword) < 8) THEN
	RAISE EXCEPTION 'Password non valida'
		USING HINT = 'Prova a inserire una password più lunga!';
	END IF;
RETURN NULL;
END;

$verifica_spassword$ LANGUAGE PLPGSQL;

CREATE TRIGGER VERIFICA_SPASSWORD AFTER INSERT
ON STUDENTE
FOR EACH ROW EXECUTE PROCEDURE verifica_spassword();
```

Si controlla che la password dello studente sia almeno di 8 caratteri.


--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION controllo_risa ()
RETURNS TRIGGER AS $controllo_risa$
DECLARE
Var1 RISPOSTA_APERTA.PUNTEGGIO_RISA%type;
Var2 QUESITO_APERTO.PUNTEGGIO_MAX%type;
Var3 QUESITO_APERTO.PUNTEGGIO_MIN%type;
idquiz RISPOSTA_APERTA.IDR_A%TYPE;
BEGIN
SELECT RISPOSTA_APERTA.PUNTEGGIO_RISA, RISPOSTA_APERTA.IDR_A INTO VAR1, idquiz
FROM RISPOSTA_APERTA
WHERE PUNTEGGIO_RISA = NEW.PUNTEGGIO_RISA;

SELECT QUESITO_APERTO.PUNTEGGIO_MAX, QUESITO_APERTO.PUNTEGGIO_MIN INTO VAR2, VAR2
FROM QUIZ_APERTO
WHERE QUESITO_APERTO.ID_A = idquiz;

IF (VAR1>VAR2 AND VAR1<VAR3)
THEN
RAISE EXCEPTION 'ERROR punteggio non valido';
RETURN NULL;
END IF;
END;
$controllo_risa$
LANGUAGE plpgsql;

CREATE TRIGGER CONTROLLO_RISA AFTER UPDATE OF PUNTEGGIO_RISA 
ON RISPOSTA_APERTA
FOR EACH ROW EXECUTE PROCEDURE controllo_risa(); 
```

Si controlla che il punteggio assegnato dal professore ad una risposta aperta non violi il range di punteggio possibile.

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION assegna_bool() RETURNS TRIGGER AS $assegna_bool$
DECLARE
Rispostad RISPOSTE_APERTE.RISPOSTA_DATA%type;
runo QUESITO_MULTIPLO.R_UNOC%type;
idrm RISPOSTE_MULTIPLE.IDR_M%type;
piu QUESITO_MULTIPLO.PUNTEGGIO_ESATTO%TYPE;
meno QUESITO_MULTIPLO.PUNTEGGIO_ERRATO%TYPE;

BEGIN

SELECT RISPOSTA_APERTA.RISPOSTA_DATA INTO rispostad, idrm
FROM RISPOSTE_APERTE
WHERE RISPOSTA_APERTA.RISPOSTA_DATA = NEW.RISPOSTA_DATA;

SELECT QUESITO_MULTIPLO.R_UNOC, QUESITO_MULTIPLO.PUNTEGGIO_ERRATO, QUESITO_MULTIPLO.PUNTEGGIO_ESATTO INTO runo, piu, meno
FROM QUESITO_MULTIPLO
WHERE QUESITO_MULTIPLO.ID_M = idrm;

    IF(rispostad = runo) THEN
		UPDATE RISPOSTE_MULTIPLE
		SET NEW.CORRETTA = TRUE
		WHERE RISPOSTE_MULTIPLE.IDR_M = idrm;
	
		UPDATE RISPOSTE_MULTIPLE
		SET NEW.PUNTEGGIO_RISM = piu
		WHERE RISPOSTE_MULTIPLE.IDR_M = idrm;
	END IF;	
	IF (rispostad <> runo) THEN
		UPDATE RISPOSTE_MULTIPLE
		SET NEW.CORRETTA = FALSE
		WHERE RISPOSTE_MULTIPLE.IDR_M = idrm;
	
		
		UPDATE RISPOSTE_MULTIPLE
		SET NEW.PUNTEGGIO_RISM = meno
		WHERE RISPOSTE_MULTIPLE.IDR_M = idrm;
		END IF;
RETURN NULL;
END;

$assegna_bool$ LANGUAGE PLPGSQL;

CREATE TRIGGER ASSEGNA_BOOL AFTER INSERT OR UPDATE OF RISPOSTA_DATA
ON RISPOSTE_MULTIPLE
FOR EACH ROW EXECUTE PROCEDURE assegna_bool();
```

Verifica la correttezza di una risposta assegnata da uno studente (vedendo se la stringa assegnata corrisponde alla stringa
della risposta vera) e assegna il relativo punteggio alla risposta data da uno studente

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION controllo_risposta() RETURNS TRIGGER AS $controllo_risposta$
DECLARE
rispostaData RISPOSTE_MULTIPLE.RISPOSTA_DATA%type;
rispostaU RISPOSTE_MULTIPLE.RISPOSTA_DATA%type;
rispostaD RISPOSTE_MULTIPLE.RISPOSTA_DATA%type;
rispostaT RISPOSTE_MULTIPLE.RISPOSTA_DATA%type;
rispostaQ RISPOSTE_MULTIPLE.RISPOSTA_DATA%type;
rispostaC RISPOSTE_MULTIPLE.RISPOSTA_DATA%type;

BEGIN
	SELECT RISPOSTE_MULTIPLE.RISPOSTA_DATA INTO rispostaData
	FROM RISPOSTE_MULTIPLE
	WHERE RISPOSTE_MULTIPLE.RISPOSTA_DATA = NEW.RISPOSTADATA;

	SELECT QUESITO_MULTIPLO.R_UNOC INTO rispostaU
FROM QUESITO_MULTIPLO
WHERE QUESITO_MULTIPLO.ID_M = RISPOSTE_MULTIPLE.IDR_M;

SELECT QUESITO_MULTIPLO.R_DUE INTO rispostaD
FROM QUESITO_MULTIPLO
WHERE QUESITO_MULTIPLO.ID_M = RISPOSTE_MULTIPLE.IDR_M;

SELECT QUESITO_MULTIPLO.R_TRE INTO rispostaT
FROM QUESITO_MULTIPLO
WHERE QUESITO_MULTIPLO.ID_M = RISPOSTE_MULTIPLE.IDR_M;

SELECT QUESITO_MULTIPLO.R_QUATTRO INTO rispostaQ
FROM QUESITO_MULTIPLO
WHERE QUESITO_MULTIPLO.ID_M = RISPOSTE_MULTIPLE.IDR_M;


SELECT QUESITO_MULTIPLO.R_CINQUE INTO rispostaC
FROM QUESITO_MULTIPLO
WHERE QUESITO_MULTIPLO.ID_M = RISPOSTE_MULTIPLE.IDR_M;

		IF(rispostaData <> rispostaU AND rispostaData<> rispostaD
		AND rispostaT IS NULL AND rispostaQ IS NULL AND rispostaC IS NULL)
		THEN RAISE EXCEPTION 'Risposta data non valida.';
		END IF;
		
		IF(rispostaData <> rispostaU AND rispostaData<> rispostaD
		AND (rispostaT IS NOT NULL AND rispostaData <> rispostaT) AND rispostaQ IS NULL AND rispostaC IS NULL)
		THEN RAISE EXCEPTION 'Risposta data non valida.';
		END IF;
		
		IF(rispostaData <> rispostaU AND rispostaData<> rispostaD
		AND (rispostaT IS NOT NULL AND rispostaData <> rispostaT)  AND 
		    (rispostaQ IS NOT NULL AND rispostaD<> rispostaQ) AND rispostaC IS NULL)
		THEN RAISE EXCEPTION 'Risposta data non valida.';
		END IF;
			
		IF (rispostaData <> rispostaU AND rispostaData<> rispostaD
		AND (rispostaT IS NOT NULL AND rispostaData <> rispostaT)  AND 
		    (rispostaQ IS NOT NULL AND rispostaD<> rispostaQ) AND
			(rispostaC IS NOT NULL AND rispostaD <> rispostaC))
		THEN RAISE EXCEPTION 'Risposta data non valida.';
		END IF;

RETURN NULL;
END;

$controllo_risposta$ LANGUAGE PLPGSQL;

CREATE TRIGGER CONTROLLO_RISPOSTA_VALIDA AFTER INSERT OR UPDATE OF RISPOSTA_DATA
ON RISPOSTE_MULTIPLE
FOR EACH ROW EXECUTE PROCEDURE controllo_risposta();
```

Controlla se la risposta data dall'utente rientri nelle risposte possibili del quiz.

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION controllo_username_i() RETURNS TRIGGER AS $controllo_username_i$
DECLARE
username_s VARCHAR(25);
username_i VARCHAR(25);
BEGIN
	SELECT INSEGNANTE.USERNAME_I INTO username_i
	FROM INSEGNANTE
	WHERE INSEGNANTE.USERNAME_I = NEW.USERNAME_I;

	SELECT STUDENTE.USERNAME_S INTO username_s
	FROM STUDENTE
	WHERE STUDENTE.USERNAME_S = username_i;
	
	IF(username_s = username_i AND username_s IS NOT NULL) THEN
	RAISE EXCEPTION 'Questo username non è disponibile.'
		USING HINT = 'Prova con un inserire un username diverso.';
	END IF;
RETURN NULL;
END;

$controllo_username_i$ LANGUAGE PLPGSQL;


CREATE TRIGGER CONTROLLO_USERNAME_I AFTER INSERT OR UPDATE OF USERNAME_I
ON INSEGNANTE
FOR EACH ROW EXECUTE PROCEDURE controllo_username_i();


CREATE OR REPLACE FUNCTION controllo_username_s() RETURNS TRIGGER AS $controllo_username_s$
DECLARE
username_s VARCHAR(25);
username_i VARCHAR(25);
BEGIN

    SELECT STUDENTE.USERNAME_S INTO username_s
	FROM STUDENTE
	WHERE STUDENTE.USERNAME_S = NEW.USERNAME_S;
	
	SELECT INSEGNANTE.USERNAME_I INTO username_i
	FROM INSEGNANTE
	WHERE INSEGNANTE.USERNAME_I = username_s;


	IF(username_s = username_i AND username_i IS NOT NULL) THEN
	RAISE EXCEPTION 'Questo username non è disponibile.'
		USING HINT = 'Prova con un inserire un username diverso.';
	END IF;
RETURN NULL;
END;

$controllo_username_s$ LANGUAGE PLPGSQL;


CREATE TRIGGER CONTROLLO_USERNAME_S AFTER INSERT OR UPDATE OF USERNAME_S
ON STUDENTE
FOR EACH ROW EXECUTE PROCEDURE controllo_username_s();
```

Si controlla che fra username ci siano username uguali.

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION verifica_insegnanteCorrezione() RETURNS TRIGGER AS $verifica_insegnanteCorrezione$
DECLARE
username INSEGNANTE.USERNAME_I%TYPE;
idTest TEST.ID_TEST%TYPE;
f TEST.ID_TEST%TYPE;

BEGIN
	
	SELECT INSEGNANTE.USERNAME_I, INSEGNANTE.ID_TEST INTO username, idTest
	FROM CORREZIONE
	WHERE INSEGNANTE.USERNAME_I = NEW.USERNAME_I;
	
	SELECT TEST.ID_TEST into f
	FROM TEST
	WHERE TEST.USERNAME_I = username AND TEST.ID_TEST = idTest;
	
IF (f is null) THEN
RAISE EXCEPTION '% non ha creato nessun test', username;
END IF;


RETURN NULL;
END;
$verifica_insegnanteCorrezione$ LANGUAGE PLPGSQL;

CREATE TRIGGER verifica_insegnanteCorrezione AFTER INSERT ON CORREZIONE
FOR EACH ROW EXECUTE PROCEDURE verifica_insegnanteCorrezione();
```

Si verifica che un insegnante in correzione abbia effettivamente creato il test da correggere

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION aggiorna_voto_a() RETURNS TRIGGER AS $aggiorna_voto_a$ 
DECLARE
punteggio RISPOSTA_APERTA.PUNTEGGIO_RISA%TYPE;
username RISPOSTA_APERTA.USERNAME_S%TYPE;
idra RISPOSTA_APERTA.IDR_A%TYPE;
idTestQ QUESITO_APERTO.ID_TEST%TYPE;
voto CORREZIONE.VOTO_TEST%TYPE;

BEGIN
SELECT RISPOSTA_APERTA.PUNTEGGIO_RISA, RISPOSTA_APERTE.USERNAME_S, RISPOSTA_APERTA.IDR_A INTO punteggio, username, idra
FROM RISPOSTA_APERTA
WHERE RISPOSTA_APERTA.PUNTEGIO_RISA = NEW.PUNTEGGIO_RISA;

SELECT QUESITO_APERTO.ID_TEST INTO idTestQ
FROM QUESITO_APERTO
WHERE QUESITO_APERTO.ID_A = idra;

SELECT CORREZIONE.VOTO_TEST INTO voto
FROM CORREZIONE
WHERE CORREZIONE.ID_TEST = idTestQ;

voto := voto + punteggio;

UPDATE CORREZIONE
SET CORREZIONE.VOTO_TEST = voto
WHERE CORREZIONE.USERNAME_S = username; 



RETURN NULL;
END;

$aggiorna_voto_a$ LANGUAGE PLPGSQL;

CREATE TRIGGER AGGIORNA_VOTO_A AFTER UPDATE OF PUNTEGGIO_RISA 
ON RISPOSTA_APERTA
FOR EACH ROW EXECUTE PROCEDURE aggiorna_voto_a(); 
```

Trigger che somma automaticamente le risposte aperte al voto di un test di uno studente

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE FUNCTION somma_mul() RETURNS TRIGGER AS $somma_mul$ 
DECLARE
punteggio RISPOSTE_MULTIPLE.PUNTEGGIO_RM%TYPE;
username RISPOSTE_MULTIPLE.USERNAME_S%TYPE;
idrm RISPOSTE_MULTIPLE.IDR_M%TYPE;
idTestQ QUESITO_MULTIPLO.ID_TEST%TYPE;
voto CORREZIONE.VOTO_TEST%TYPE;
idTestC CORREZIONE.ID_TEST%TYPE;

BEGIN
SELECT RISPOSTE_MULTIPLE.PUNTEGGIO_RM, RISPOSTE_MULTIPLE.USERNAME_S, RISPOSTE_MULTIPLE.IDR_M INTO
punteggio, username, idrm
FROM RISPOSTE_MULTIPLE
WHERE RISPOSTE_MULTIPLE.PUNTEGIO_RM = NEW.PUNTEGGIO_RM;

SELECT QUESITO_MULTIPLO.ID_TEST INTO idTestQ
FROM QUESITO_MULTIPLO
WHERE QUESITO_MULTIPLO.ID_M = idrm;

SELECT CORREZIONE.VOTO_TEST INTO voto
FROM CORREZIONE
WHERE CORREZIONE.ID_TEST = idTestQ;

voto := voto + punteggio;

UPDATE CORREZIONE
SET CORREZIONE.VOTO_TEST = voto
WHERE CORREZIONE.USERNAME_S = username; 

RETURN NULL;
END;

$somma_mul$ LANGUAGE PLPGSQL;

CREATE TRIGGER SOMMA_PUNTEGGIOM AFTER UPDATE OF PUNTEGGIO_RM
ON RISPOSTE_MULTIPLE
FOR EACH ROW EXECUTE PROCEDURE somma_mul();
```

Trigger che somma a voto il punteggio delle risposte aperte

--------------------------------------------------------------------------------------------
```SQL
CREATE OR REPLACE FUNCTION aggiorna_punteggiotot() RETURNS TRIGGER AS $aggiorna_punteggiotot$
DECLARE
username STUDENTE.USERNAME_S%TYPE;
punteggio STUDENTE.PUNTEGGIO_TOT%TYPE;
Voto CORREZIONE.VOTO_TEST%TYPE;
BEGIN

	SELECT CORREZIONE.VOTO_TEST, CORREZIONE.USERNAME_S INTO voto, username
	FROM CORREZIONE
	WHERE CORREZIONE.VOTO_TEST = NEW.VOTO_TEST;

	SELECT STUDENTE.PUNTEGGIO_TOT INTO punteggio
	FROM STUDENTE
	WHERE STUDENTE.USERNAME_S = username;

	punteggio := punteggio + voto;
                UPDATE STUDENTE
	SET STUDENTE.PUNTEGGIO_TOT = punteggio
	WHERE (STUDENTE.USERNAME_S = username);
RETURN NULL;
END;

$aggiorna_punteggiotot$ LANGUAGE PLPGSQL;


CREATE TRIGGER AGGIORNA_PUNTEGGIOTOT AFTER UPDATE OF VOTO_TEST
ON CORREZIONE
FOR EACH ROW EXECUTE PROCEDURE aggiorna_punteggiotot();  
```

Trigger che somma a punteggio totali di uno studente tutti i voti ottenuti

--------------------------------------------------------------------------------------------
VISTE

```SQL
CREATE OR REPLACE VIEW risposte_esatte (STUDENTE, ESATTE, TEST)
AS (SELECT R.USERNAME_S, COUNT(R.PUNTEGGIO_RISA) + COUNT(W.CORRETTA), Q.ID_TEST
    FROM RISPOSTA_APERTA AS R, QUESITO_APERTO AS Q, QUESITO_MULTIPLO AS M, 
	 RISPOSTE_MULTIPLE AS W, RISPOSTA_APERTA AS F, RISPOSTE_MULTIPLE AS Y 
    WHERE (R.PUNTEGGIO_RISA>PUNTEGGIO_MIN OR W.CORRETTA=TRUE) AND (R.USERNAME_S = W.USERNAME_S) AND
          (R.USERNAME_S = F.USERNAME_S) AND (W.USERNAME_S = Y.USERNAME_S) AND (Q.ID_TEST = M.ID_TEST) AND
          (M.ID_M = W.IDR_M) AND (R.IDR_A = Q.ID_A)
    GROUP BY R.USERNAME_S, Q.ID_TEST)
```
	
Vista che raggruppa tutte le risposte esatte degli studenti

--------------------------------------------------------------------------------------------


```SQL
CREATE OR REPLACE VIEW risposte_errate (STUDENTE, ERRATE, TEST)
AS (SELECT R.USERNAME_S, COUNT(R.PUNTEGGIO_RISA) + COUNT(W.CORRETTA), Q.ID_TEST
    FROM RISPOSTA_APERTA AS R, QUESITO_APERTO AS Q, QUESITO_MULTIPLO AS M, 
	 RISPOSTE_MULTIPLE AS W, RISPOSTA_APERTA AS F, RISPOSTE_MULTIPLE AS Y 
    WHERE (R.PUNTEGGIO_RISA = PUNTEGGIO_MIN OR W.CORRETTA=FALSE) AND 
          (R.USERNAME_S = W.USERNAME_S) AND (R.USERNAME_S = F.USERNAME_S)
	  AND (W.USERNAME_S = Y.USERNAME_S) AND (Q.ID_TEST = M.ID_TEST) AND (M.ID_M = W.IDR_M) AND (R.IDR_A = Q.ID_A)
    GROUP BY R.USERNAME_S, Q.ID_TEST)
```
	    
Vista che raggruppa tutte le risposte errate degli studenti

--------------------------------------------------------------------------------------------

```
CREATE OR REPLACE VIEW visualizza_dati_studente (NOME_TEST, N_STUDENTI)
AS (SELECT NOME_TEST, COUNT(USERNAME_S)
   FROM CORREZIONE AS C, TEST AS T
   WHERE C.ID_TEST = T.ID_TEST
   GROUP BY NOME_TEST)
```
   
Vista che permette la visualizzazione delle informazioni relative agli studenti

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE VIEW visualizza_risultati (NOME_STU, NOME_TEST, NOME_INS, RIS_ESATTE, RIS_ERRATE, VOTO)
AS (SELECT C.USERNAME_S, T.NOME_TEST, C.USERNAME_I, E.ESATTE, R.ERRATE, C.VOTO_TEST,
   FROM CORREZIONE AS C, RISPOSTE_ESATTE AS E, RISPOSTE_ERRATE AS R, TEST AS T, TEST AS Y
   WHERE T.ID_TEST = Y.ID_TEST)
```
   
   
Vista che permette di visualizzare i risultati di un test dato uno studente

--------------------------------------------------------------------------------------------

```SQL
CREATE OR REPLACE VIEW media_categoria (NOME_TEST, MATERIA, STUDENTE, MEDIA) AS
(SELECT T.NOME_TEST, T.MATERIA_TEST, C.USERNAME_S, AVG(C.VOTO_TEST)
FROM TEST AS T, TEST AS P, CORREZIONE AS C
GROUP BY T.NOME_TEST, T.MATERIA_TEST, C.USERNAME_S, P.MATERIA_TEST
HAVING T.MATERIA_TEST = P.MATERIA_TEST
)
```

Vista che raggruppa le medie degli studenti

--------------------------------------------------------------------------------------------