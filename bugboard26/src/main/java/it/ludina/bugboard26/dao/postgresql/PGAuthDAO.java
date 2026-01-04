package it.ludina.bugboard26.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.ludina.bugboard26.connections.PostgresConnection;
import it.ludina.bugboard26.dao.AuthDAO;
import it.ludina.bugboard26.data.user.GenericUser;

public class PGAuthDAO implements AuthDAO {
	private Connection conn = null;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public String login(GenericUser user) throws SQLException {
		conn = PostgresConnection.getInstance().getConnection();
		ps = conn.prepareStatement("select login_utente(?,?)");

		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());

		rs = ps.executeQuery();
		rs.next();

		return rs.getString(1);
	}

}
