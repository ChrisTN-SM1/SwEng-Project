package it.ludina.bugboard26.dao;

import java.sql.SQLException;

import it.ludina.bugboard26.data.user.Utente;

public interface UserDAO {
    public void add(Utente user) throws SQLException;
}