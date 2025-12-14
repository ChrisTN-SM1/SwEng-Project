package it.ludina.bugboard26.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ludina.bugboard26.connections.PostgresConnection;
import it.ludina.bugboard26.dao.IssueDAO;
import it.ludina.bugboard26.data.IssueFactory;
import it.ludina.bugboard26.data.issue.Issue;
import it.ludina.bugboard26.data.issue.enums.PrioritaEnum;
import it.ludina.bugboard26.data.issue.enums.StatoEnum;

public class PGIssueDAO implements IssueDAO{

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps;

    @Override
    public List<Issue> getAllIssues() throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        List<Issue> result = new ArrayList<>();

        ps = conn.prepareStatement("SELECT visualizza_lista_issue()");

        rs = ps.executeQuery();

        while (rs.next()) {

            int id = rs.getInt(1);
            String titolo = rs.getString(2);
            String tipologia = rs.getString(3);
            PrioritaEnum priorita = PrioritaEnum.valueOf(rs.getString(4));
            StatoEnum stato = StatoEnum.valueOf(rs.getString(5));

            Issue i = IssueFactory.create(id, titolo, tipologia, priorita, stato);

            result.add(i);
        }
        rs.close();
        conn.close();
        return result;
    }

    @Override
    public void add(Issue issue) throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        ps = conn.prepareStatement("CALL crea_issue(?,?,?,?,?)");

        ps.setString(1, issue.getTitolo());
        ps.setString(2, issue.getDescrizione());
        ps.setString(3, issue.getIssueType());
        ps.setString(4, issue.getPriorita().toString());

        ps.execute();

        conn.close();
    }

    @Override
    public void setArchived(int id) throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        ps = conn.prepareStatement("CALL imposta_bug_archiviato(?)");
        ps.setInt(1, id);

        ps.execute();

        conn.close();
    }

    @Override
    public void setCompleted(int id) throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        ps = conn.prepareStatement("CALL imposta_issue_completata(?)");
        ps.setInt(1, id);

        ps.execute();

        conn.close();
    }

    @Override
    public void assignIssue(int id, String[] users) throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        ps = conn.prepareStatement("CALL assegna_issue(?, ?)");
        ps.setInt(1, id);

        for (String user : users) {
            ps.setString(2, user);
            ps.addBatch();
            
        }
        
        ps.executeBatch();

        conn.close();
    }


}
