package it.ludina.bugboard26.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ludina.bugboard26.connections.PostgresConnection;
import it.ludina.bugboard26.dao.AssignmentDAO;
import it.ludina.bugboard26.data.Assignment;

public class PGAssignmentDAO implements AssignmentDAO {

    private Connection conn = null;
    private PreparedStatement ps;
    ResultSet rs;

    @Override
    public void assign(Assignment assignment) throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        ps = conn.prepareStatement("CALL assegna_issue(?, ?)");
        ps.setInt(1, assignment.getIdIssue());

        for (String user : assignment.getEmails()) {
            ps.setString(2, user);
            ps.addBatch();
            
        }
        
        ps.executeBatch();

        conn.close();
    }

    @Override
    public List<String> getAssignedTo(int idIssue) throws SQLException {
        List<String> results = new ArrayList<>();
        
        conn = PostgresConnection.getInstance().getConnection();
        ps = conn.prepareStatement("SELECT emailResponsabile from visualizza_responsabili_issue(?)");
        ps.setInt(1, idIssue);
        rs = ps.executeQuery();

        while (rs.next()) {
            results.add(rs.getString(1));
        }

        conn.close();
        return results;

    }

    @Override
    public List<String> getNotAssignedTo(int idIssue) throws SQLException {
        List<String> results = new ArrayList<>();
        
        conn = PostgresConnection.getInstance().getConnection();
        ps = conn.prepareStatement("SELECT emailResponsabile from visualizza_non_responsabili_issue(?)");
        ps.setInt(1, idIssue);
        rs = ps.executeQuery();

        while (rs.next()) {
            results.add(rs.getString(1));
        }

        conn.close();
        return results;
    }
}
