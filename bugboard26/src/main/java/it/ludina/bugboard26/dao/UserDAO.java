package it.ludina.bugboard26.dao;

import java.sql.SQLException;

import it.ludina.bugboard26.data.user.GenericUser;

public interface UserDAO {
    public void add(GenericUser user) throws SQLException;
}