package it.ludina.bugboard26.dao;

import java.sql.SQLException;

import it.ludina.bugboard26.data.utente.Utente;

public interface UtenteDAO {

    void add(Utente user) throws SQLException;
}