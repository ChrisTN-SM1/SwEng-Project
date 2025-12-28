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
    private PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Issue> getIssueList() throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        List<Issue> result = new ArrayList<>();

        ps = conn.prepareStatement("SELECT identificatoreIssue, titoloIssue, tipologiaIssue, prioritaIssue, statoIssue FROM visualizza_lista_issue()");

        rs = ps.executeQuery();

        while (rs.next()) {

            int id = rs.getInt(1);
            String titolo = rs.getString(2);
            String tipologia = rs.getString(3);
            PrioritaEnum priorita = PrioritaEnum.valueOf(rs.getString(4).toUpperCase());
            StatoEnum stato = StatoEnum.valueOf(rs.getString(5).toUpperCase());

            Issue issue = IssueFactory.create(id, titolo, tipologia, priorita, stato);

            result.add(issue);
        }
        rs.close();
        conn.close();
        return result;
    }

    @Override
    public List<Issue> getBugArchive() throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        List<Issue> result = new ArrayList<>();

        ps = conn.prepareStatement("SELECT identificatoreIssue, titoloIssue, tipologiaIssue, prioritaIssue, statoIssue FROM visualizza_archivio_bug()");

        rs = ps.executeQuery();

        while (rs.next()) {

            int id = rs.getInt(1);
            String titolo = rs.getString(2);
            String tipologia = rs.getString(3);
            PrioritaEnum priorita = PrioritaEnum.valueOf(rs.getString(4).toUpperCase());
            StatoEnum stato = StatoEnum.valueOf(rs.getString(5).toUpperCase());

            Issue issue = IssueFactory.create(id, titolo, tipologia, priorita, stato);

            result.add(issue);
        }
        rs.close();
        conn.close();
        return result;
    }

    @Override
    public void add(Issue issue) throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        ps = conn.prepareStatement("CALL crea_issue(?,?,?,?,?)");

        ps.setString(1, issue.getTitle());
        ps.setString(2, issue.getDescription());
        ps.setString(3, issue.getIssueType());
        ps.setString(4, issue.getPriority().toString().toLowerCase());
        ps.setString(5, issue.getImage());

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
