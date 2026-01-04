package it.ludina.bugboard26.dao;

import java.sql.SQLException;

import it.ludina.bugboard26.data.user.GenericUser;

public interface AuthDAO {
	public String login(GenericUser user) throws SQLException;
}