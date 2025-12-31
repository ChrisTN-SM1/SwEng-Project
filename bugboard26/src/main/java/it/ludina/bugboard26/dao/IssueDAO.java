package it.ludina.bugboard26.dao;

import java.sql.SQLException;
import java.util.List;

import it.ludina.bugboard26.data.issue.Issue;

public interface IssueDAO {
    List<Issue> getIssueList() throws SQLException;

    List<Issue> getBugArchive() throws SQLException;

    void add(Issue issue) throws SQLException;

    void setArchived(Issue issue) throws SQLException;

    void setCompleted(Issue issue) throws SQLException;

    public String getImage(int idIssue) throws SQLException;

}