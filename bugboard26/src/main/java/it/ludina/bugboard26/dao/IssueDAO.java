package it.ludina.bugboard26.dao;

import java.sql.SQLException;
import java.util.List;

import it.ludina.bugboard26.data.issue.Issue;

public interface IssueDAO {
    List<Issue> getIssueList() throws SQLException;

    List<Issue> getBugArchive() throws SQLException;

    void add(Issue issue) throws SQLException;

    void setArchived(int idIssue) throws SQLException;

    void setCompleted(int idIssue) throws SQLException;

    void assignIssue(int idIssue, String[] users) throws SQLException;

    List<String> getAssignedTo(int idIssue) throws SQLException;

    List<String> getNotAssignedTo(int idIssue) throws SQLException;

}