package it.ludina.bugboard26.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ludina.bugboard26.connections.PostgresConnection;
import it.ludina.bugboard26.dao.IssueDAO;
import it.ludina.bugboard26.data.issue.Issue;
import it.ludina.bugboard26.data.issue.IssueFactory;
import it.ludina.bugboard26.data.issue.enums.PriorityEnum;
import it.ludina.bugboard26.data.issue.enums.StatusEnum;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PGIssueDAO implements IssueDAO {
    private Connection conn = null;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<Issue> getIssueList() throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        List<Issue> result = new ArrayList<>();

        ps = conn.prepareStatement(
                "SELECT identificatoreIssue, titoloIssue, descrizioneIssue, tipologiaIssue, prioritaIssue, statoIssue FROM visualizza_lista_issue()");

        rs = ps.executeQuery();

        while (rs.next()) {

            int id = rs.getInt(1);
            String title = rs.getString(2);
            String description = rs.getString(3);
            String issueType = rs.getString(4);
            PriorityEnum priority = PriorityEnum.valueOf(rs.getString(5).toUpperCase());
            StatusEnum state = StatusEnum.valueOf(rs.getString(6).toUpperCase());

            Issue issue = IssueFactory.create(id, title, description, issueType, priority, state);

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

        ps = conn.prepareStatement(
                "SELECT identificatoreIssue, titoloIssue, descrizioneIssue, tipologiaIssue, prioritaIssue, statoIssue FROM visualizza_archivio_bug()");

        rs = ps.executeQuery();

        while (rs.next()) {

            int id = rs.getInt(1);
            String title = rs.getString(2);
            String description = rs.getString(3);
            String issueType = rs.getString(4);
            PriorityEnum priority = PriorityEnum.valueOf(rs.getString(5).toUpperCase());
            StatusEnum state = StatusEnum.valueOf(rs.getString(6).toUpperCase());

            Issue issue = IssueFactory.create(id, title, description, issueType, priority, state);

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

        InputStream stream = new ByteArrayInputStream(issue.getImage().getBytes());

        ps.setString(1, issue.getTitle());
        ps.setString(2, issue.getDescription());
        ps.setString(3, issue.getIssueType());
        ps.setString(4, issue.getPriority().toString().toLowerCase());
        ps.setBinaryStream(5, stream, issue.getImage().length());

        ps.execute();

        conn.close();
    }

    @Override
    public void setArchived(Issue issue) throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        ps = conn.prepareStatement("CALL imposta_bug_archiviato(?)");
        ps.setInt(1, issue.getIdIssue());

        ps.execute();

        conn.close();
    }

    @Override
    public void setCompleted(Issue issue) throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();

        ps = conn.prepareStatement("CALL imposta_issue_completata(?)");
        ps.setInt(1, issue.getIdIssue());

        ps.execute();

        conn.close();
    }

    public String getImage(int idIssue) throws SQLException {
        conn = PostgresConnection.getInstance().getConnection();
        ps = conn.prepareStatement("SELECT immagineIssue FROM ottieni_immagine_issue(?)");
        ps.setInt(1, idIssue);

        rs = ps.executeQuery();

        rs.next();

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];

        InputStream stream = rs.getBinaryStream(1);

        try {
            for (int length; (length = stream.read(buffer)) != -1;) {
                result.write(buffer, 0, length);
            }
        } catch (IOException e) {
            return "";
        }

        conn.close();

        return result.toString();
    }

}
