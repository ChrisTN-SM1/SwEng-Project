package it.ludina.bugboard26.dao;

import java.sql.SQLException;

import it.ludina.bugboard26.data.user.Utente;

public interface AuthDAO {
	public String login(Utente user) throws SQLException;
}