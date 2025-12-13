--Enumerations

CREATE TYPE UserType AS ENUM ('semplice', 'admin');
CREATE TYPE IssueType AS ENUM ('question', 'bug', 'documentation', 'feature');
CREATE TYPE IssuePriority AS ENUM ('bassa', 'media', 'alta', 'vitale');
CREATE TYPE IssueStatus AS ENUM ('todo', 'assegnato', 'completato', 'archiviato');

--Tables

CREATE TABLE utente (
    email VARCHAR(50) PRIMARY KEY,
    "password" VARCHAR(50),
    tipologia UserType
);

CREATE TABLE issue (
    "id" INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    titolo VARCHAR(50),
    descrizione VARCHAR(2000),
    tipologia IssueType,
    priorita IssuePriority,
    stato IssueStatus DEFAULT 'todo',
    immagine VARCHAR(200)
);

CREATE TABLE assegnazione (
    idIssue INT REFERENCES issue("id") ON DELETE CASCADE,
    emailUtente VARCHAR(50) REFERENCES utente(email) ON DELETE CASCADE,
    PRIMARY KEY (idIssue, emailUtente)
);

--Procedures

CREATE OR REPLACE PROCEDURE crea_utente(newMail VARCHAR(50), newPass VARCHAR(50), "type" UserType)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO utente(email, "password", tipologia) VALUES (newMail, newPass, "type");
END; $$;

CREATE OR REPLACE PROCEDURE crea_issue(newTitle VARCHAR(50), newDesc VARCHAR(2000), "type" IssueType, priority IssuePriority, image VARCHAR(200))
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO issue(titolo, descrizione, tipologia, priorita, immagine) VALUES (newTitle, newDesc, "type", priority, image);
END; $$;

CREATE OR REPLACE PROCEDURE imposta_issue_completata(idIssue INT)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE issue
    SET stato = 'completato'
    WHERE  "id" = idIssue;
END; $$;

CREATE OR REPLACE PROCEDURE assegna_issue(newIdIssue INT, newMailUtente VARCHAR(50))
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO assegnazione(idIssue, emailUtente) VALUES (newIdIssue, newMailUtente);
END; $$;

CREATE OR REPLACE PROCEDURE elimina_issue(issueID INT)
LANGUAGE plpgsql
AS $$
BEGIN
    DELETE FROM issue
    where "id" = issueID;
END; $$;

CREATE OR REPLACE PROCEDURE elimina_utente(userMail VARCHAR(50))
LANGUAGE plpgsql
AS $$
BEGIN
    DELETE FROM utente
    WHERE email = userMail;
END; $$;

--Functions

CREATE OR REPLACE FUNCTION login_utente(userMail VARCHAR(50), userPassword VARCHAR(50))
RETURNS integer AS $outcome$
DECLARE
    outcome integer;
BEGIN
    IF userMail NOT IN (SELECT email FROM utente) THEN
        outcome = 1;
    ELSIF userPassword <> (SELECT "password" FROM utente WHERE email = userMail) THEN
        outcome = 2;
    ELSE
        outcome = 0;
    END IF;
    RETURN outcome;
END;
$outcome$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION visualizza_lista_issue()
RETURNS TABLE("id" INT, titolo VARCHAR(50), tipologia IssueType, priorita IssuePriority,  stato IssueStatus)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
        SELECT "id", titolo, tipologia, priorità, stato
        FROM issue
        WHERE stato <> 'archiviato';
END; $$;

CREATE OR REPLACE FUNCTION visualizza_archivio_bug()
RETURNS TABLE("id" INT, titolo VARCHAR(50), tipologia IssueType, priorita IssuePriority,  stato IssueStatus)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
        SELECT "id", titolo, tipologia, priorità, stato
        FROM issue
        WHERE stato = 'archiviato';
END; $$;

CREATE OR REPLACE FUNCTION visualizza_dettagli_issue(idIssue INT)
RETURNS TABLE("id" INT, titolo VARCHAR(50), descrizione VARCHAR(2000), tipologia IssueType, priorita IssuePriority,  stato IssueStatus)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
        SELECT "id", titolo, descrizione, tipologia, priorità, stato
        FROM issue
        WHERE "id" = idIssue;
END; $$;

--Trigger e Trigger Functions

CREATE OR REPLACE FUNCTION controlla_stato_issue_function()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    IF (SELECT stato FROM assegnazione JOIN issue
        ON assegnazione.idIssue = issue."id"
        WHERE issue."id" = new.idIssue;) LIKE 'todo' THEN
        UPDATE issue
        SET stato = 'assegnato'
        WHERE "id" = new."id";
    END IF;
    RETURN;
END; $$;

CREATE or REPLACE TRIGGER controlla_stato_issue
AFTER IDENTITY ON assegnazione
FOR EACH ROW
EXECUTE FUNCTION controlla_stato_issue_function();

CALL crea_utente('gianni@company.net', '0000', 'admin');