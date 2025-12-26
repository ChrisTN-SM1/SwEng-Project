package it.ludina.bugboard26.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.ludina.bugboard26.connections.PostgresConnection;
import it.ludina.bugboard26.dao.UtenteDAO;
import it.ludina.bugboard26.data.utente.Utente;

public class PGUtenteDAO implements UtenteDAO{

    private Connection conn = null;
    private PreparedStatement ps;
    ResultSet rs;

    @Override
    public void add(Utente user) throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        ps = conn.prepareStatement("CALL crea_utente(?,?,?)");

        ps.setString(1, user.getEmail());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());

        ps.execute();

        conn.close();
    }
}
