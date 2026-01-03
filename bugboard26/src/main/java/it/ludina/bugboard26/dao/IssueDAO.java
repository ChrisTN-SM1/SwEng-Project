package it.ludina.bugboard26.dao;

import java.sql.SQLException;
import java.util.List;

import it.ludina.bugboard26.data.issue.Issue;

public interface IssueDAO {
    public List<Issue> getIssueList() throws SQLException;

    public List<Issue> getBugArchive() throws SQLException;

    public void add(Issue issue) throws SQLException;

    public void setArchived(Issue issue) throws SQLException;

    public void setCompleted(Issue issue) throws SQLException;

    public String getImage(int idIssue) throws SQLException;
}
